package com.webapp.acc.controller;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.webapp.acc.service.SpendingService;



@Controller
public class BudgetController {
	
	@Autowired
	private SpendingService service;

	/*
	@GetMapping("/barChart")
	public String getAllEmployee(Model model) {	
		
	List<String> nameList= service.getAllSpendings().stream().map(x->x.getType()).collect(Collectors.toList());
	List<Double> ageList = service.getAllSpendings().stream().map(x-> x.getPrice()).collect(Collectors.toList());
	model.addAttribute("name", nameList);
	model.addAttribute("age", ageList);
	return "data";*/
	
	
	@GetMapping("/budget")
	public String  budgetControl(Model model) {
		model.addAttribute("budget",service.getTotalPrice());
		return "data";
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		//Double total =service .getAllSpendings().forEach(x->x.getPrice());
		//service.getAllSpendings().stream().map(x-> x.getPrice());
		//return "data";
		/*DataSeries dataseries = new DataSeries();
		
		<Double> total =  service.getAllSpendings().forEach(x->x.getPrice());
		System.out.println(service .getAllSpendings().forEach(x->x.getPrice()));
		*/
	}
	
		
	
	

	
	
	
	
	
	
	

}
