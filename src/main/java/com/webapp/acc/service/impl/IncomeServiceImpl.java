package com.webapp.acc.service.impl;

import java.util.List;
import java.util.stream.Collectors;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webapp.acc.entity.Income;
import com.webapp.acc.repository.IncomeRepository;
import com.webapp.acc.service.IncomeService;

@Service
public class IncomeServiceImpl implements IncomeService {
	@Autowired
	private IncomeRepository incomeRepository;
	
	public IncomeServiceImpl(IncomeRepository incomeRepository) {
		super();
		this.incomeRepository = incomeRepository;
	}

	@Override
	public List<Income> getAllIncomes(String keyword) {	
		if (keyword != null) {
			return incomeRepository.findAll(keyword);
		}
		return incomeRepository.findAll();
	}
	
	@Override
	public Income saveIncome(Income income) {
		return incomeRepository.save(income);
	}

	@Override
	public Income getIncomeById(long id) {
		return incomeRepository.findById(id).get();
	}

	@Override
	public Income updateIncome(Income income) {
		return incomeRepository.save(income);
	}

	@Override
	public void deleteIncomeById(long id) {
		this.incomeRepository.deleteById(id);

	}
	
	@Override
	public Double getTotalIncome() {
		Double totalincome = 0.0;
		List<Double> priceList = incomeRepository.findAll().stream().map(x->x.getPrice()).collect(Collectors.toList());
		int count = priceList.size();
		for(int i=0; i<count;i++) {
			Double single = priceList.get(i);
			totalincome = totalincome + single;
		}
		return totalincome;
	}
	








	
	

}

