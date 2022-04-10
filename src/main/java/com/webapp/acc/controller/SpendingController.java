package com.webapp.acc.controller;


import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.webapp.acc.entity.Spending;
import com.webapp.acc.repository.SpendingRepository;
import com.webapp.acc.service.SpendingService;

@Controller

public class SpendingController {
	private SpendingService service;

	public SpendingController(SpendingService spendingService) {
		super();
		this.service = spendingService;
	}
	
	
	@GetMapping("/expenses")
	public String listSpendings(Model model){
		model.addAttribute("spends", service.getAllSpendings());
		return "expenses";
	}
	
	@GetMapping("/showNewExpenseForm")
	public String showNewExpenseForm(Model model){
		Spending spending = new Spending();
		model.addAttribute("spending", spending);
		return "create_expense";
	}
	
	@PostMapping("/saveExpense")
	public String saveExpense(@ModelAttribute("spending") Spending spending) {
		service.saveSpending(spending);
		return "redirect:/expenses";
	}
	
	@GetMapping("/spending/edit/{id}")
	public String showFormForUpdate(@PathVariable (value = "id") long id, Model model) { 
		model.addAttribute("spending", service.getSpendingById(id));

		return "update_expense";
	}
	@PostMapping("/saveExpense/{id}")
	public String updateSpending(@PathVariable long  id,
			@ModelAttribute("spending") Spending spending,
			Model model) {
		Spending existingSpending = service.getSpendingById(id);
		existingSpending.setId(id);
		existingSpending.setDate(spending.getDate());
		existingSpending.setName(spending.getName());
		existingSpending.setNote(spending.getNote());
		existingSpending.setPrice(spending.getPrice());
		existingSpending.setType(spending.getType());
		service.updateSpending(existingSpending);
		return "redirect:/expenses";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable (value = "id") long id) {
		service.deleteSpendingById(id);

		return "redirect:/expenses";
	}
	
	@GetMapping("/dataAnalyze")
	public String data() {
		return ("/data");
	}
	
}
