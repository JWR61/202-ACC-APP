package com.webapp.acc.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.webapp.acc.entity.Budget;
import com.webapp.acc.service.IncomeService;
import com.webapp.acc.service.SpendingService;

@Controller
public class BudgetController {

	@Autowired
	private SpendingService service;
	@Autowired
	private IncomeService iservice;

	@GetMapping("/budget")
	public String  SetBudget(Model model) {
		model.addAttribute("Budget", new Budget());
		return "set_budget";
	}
	
	@PostMapping("/result")
	public String BudgetResult(@ModelAttribute Budget budget, BindingResult result, Model model) {
		model.addAttribute("ou",service.getTotalPrice());
		model.addAttribute("in",iservice.getTotalIncome());
		model.addAttribute("Budget", budget);
		model.addAttribute("remain", budget.getInput_budget() - service.getTotalPrice());
		return "result";
	}
		
	
	

	
	
	
	
	
	
	

}
