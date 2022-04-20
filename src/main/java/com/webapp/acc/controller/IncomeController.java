package com.webapp.acc.controller;



import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.webapp.acc.entity.Income;
import com.webapp.acc.repository.IncomeRepository;
import com.webapp.acc.service.IncomeService;

@Controller

public class IncomeController {
	private IncomeService service;

	public IncomeController(IncomeService incomeService) {
		super();
		this.service = incomeService;
	}
	
	
	@GetMapping("/incomes")
	public String listIncomes(Model model, 
			@Param("keyword") String keyword){
		model.addAttribute("ins", service.getAllIncomes(keyword));
		model.addAttribute("keyword", keyword);
		return "incomes";
	}

	@GetMapping("/showNewIncomeForm")
	public String showNewIncomeForm(Model model){
		Income income = new Income();
		model.addAttribute("income", income);
		
		return "create_income";
	}
	
	@PostMapping("/saveIncome")
	public String saveIncome(@ModelAttribute("income") Income income) {
		service.saveIncome(income);
		return "redirect:/incomes";
	}
	
	@GetMapping("/income/edit/{id}")
	public String showFormForUpdate(@PathVariable (value = "id") long id, Model model) { 
		model.addAttribute("income", service.getIncomeById(id));

		return "update_income";
	}
	@PostMapping("/saveIncome/{id}")
	public String updateIncome(@PathVariable long  id,
			@ModelAttribute("income") Income income,
			Model model) {
		Income existingIncome = service.getIncomeById(id);
		existingIncome.setId(id);
		existingIncome.setDate(income.getDate());
		//existingIncome.setIotype(income.getIotype());
		existingIncome.setName(income.getName());
		existingIncome.setNote(income.getNote());
		existingIncome.setPrice(income.getPrice());
		existingIncome.setType(income.getType());
		service.updateIncome(existingIncome);
		return "redirect:/incomes";
	}
	
	@GetMapping("/delete_income/{id}")
	public String delete(@PathVariable (value = "id") long id) {
		service.deleteIncomeById(id);

		return "redirect:/incomes";
	}

	
	
	
	
}
