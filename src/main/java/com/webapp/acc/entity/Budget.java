package com.webapp.acc.entity;

import org.springframework.beans.factory.annotation.Autowired;

import com.webapp.acc.service.SpendingService;



public class Budget {
	/*
	@Autowired
	private SpendingService service;
	*/
	
	private Double input_budget;
	private Double less;
	
	
	public Double getInput_budget() {
		return input_budget;
	}
	public void setInput_budget(Double input_budget) {
		this.input_budget = input_budget;
	}

	public Double getLess() {
		return less;
	}
	public void setLess(Double less) {
		this.less = less;
	}
	
	/*
	public double getMoney() {
	less = input_budget - service.getTotalPrice();
	return less; */
	
	
	
	
	
	
	
	
	
	
	
}
