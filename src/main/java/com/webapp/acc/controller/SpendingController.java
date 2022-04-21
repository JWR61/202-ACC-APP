package com.webapp.acc.controller;



import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@Autowired
	SpendingRepository spendingRepository;
	

	
	
	@GetMapping("/expenses")
	public String listSpendings(Model model, 
			@Param("keyword") String keyword){
		model.addAttribute("spends", service.getAllSpendings(keyword));
		model.addAttribute("keyword", keyword);
		return "expenses";
		//return findPaginated(1, model);
	} 
	
	/*
	@GetMapping("/expenses")
	public String listSpendings(Model model   
	 //, @Param("keyword") String keyword
			){
		//model.addAttribute("spends", service.getAllSpendings(keyword));
		//model.addAttribute("keyword", keyword);
		//return "expenses";
		return findPaginated(null, 1, model);
	}
	*/
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
		//existingSpending.setIotype(spending.getIotype());
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
	
	/*
	@GetMapping("/page/{pageNo}")
	public String findPaginated(@Param("keyword") String keyword, @PathVariable (value = "pageNo") int pageNo, Model model) {
		int pageSize = 3;
		Page<Spending> page = service.findPaginated(pageNo, pageSize);
		List <Spending> listSpendings = page.getContent();
		model.addAttribute("currentPage" , pageNo);
		model.addAttribute("totalPages" , page.getTotalPages());
		model.addAttribute("totalItems" , page.getTotalElements());
		model.addAttribute("spends", service.getAllSpendings(keyword));
		model.addAttribute("keyword", keyword);

		return "expenses";
	}
*/
	
	@GetMapping("/chart")
	public String chart(Model model) {
		List<String> typeList = spendingRepository.findAll().stream().map(x->x.getType()).collect(Collectors.toList());
		List<Double> PriceList = spendingRepository.findAll().stream().map(x->x.getPrice()).collect(Collectors.toList());
		model.addAttribute("type", typeList);
		model.addAttribute("price",PriceList);
		return "chart";
		
	}


	
	
}
