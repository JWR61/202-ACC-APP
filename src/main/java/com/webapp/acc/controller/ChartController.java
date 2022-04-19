package com.webapp.acc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.webapp.acc.entity.Spending;
import com.webapp.acc.repository.SpendingRepository;



@Controller
public class ChartController {
	
	@Autowired
	SpendingRepository spendingRepository;
	
	@RequestMapping("piechart")
	public ResponseEntity<?> getPieChartData(){
		List<Spending> databaseData = spendingRepository.findAll();
		
		return new ResponseEntity<>(databaseData, HttpStatus.OK);
		
	}
	
	
}