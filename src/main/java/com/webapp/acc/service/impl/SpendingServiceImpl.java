package com.webapp.acc.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webapp.acc.entity.Spending;
import com.webapp.acc.repository.SpendingRepository;
import com.webapp.acc.service.SpendingService;

@Service
public class SpendingServiceImpl implements SpendingService {
	@Autowired
	private SpendingRepository spendingRepository;
	
	public SpendingServiceImpl(SpendingRepository spendingRepository) {
		super();
		this.spendingRepository = spendingRepository;
	}

	@Override
	public List<Spending> getAllSpendings() {	
		return spendingRepository.findAll();
	}
	
	@Override
	public Spending saveSpending(Spending spending) {
		return spendingRepository.save(spending);
	}

	@Override
	public Spending getSpendingById(long id) {
		return spendingRepository.findById(id).get();
	}

	@Override
	public Spending updateSpending(Spending spending) {
		return spendingRepository.save(spending);
	}

	@Override
	public void deleteSpendingById(long id) {
		this.spendingRepository.deleteById(id);;

	}





	
	

}
