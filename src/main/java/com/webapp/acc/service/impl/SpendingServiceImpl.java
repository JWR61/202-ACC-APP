package com.webapp.acc.service.impl;


import java.util.List;
import java.util.stream.Collectors;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
	public List<Spending> getAllSpendings(String keyword) {	
		if (keyword != null) {
			return spendingRepository.findAll(keyword);
		}
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
		this.spendingRepository.deleteById(id);

	}
	
	@Override
	public Double getTotalPrice() {
		
		
		Double total = 0.0;
		List<Double> priceList = spendingRepository.findAll().stream().map(x->x.getPrice()).collect(Collectors.toList());
		
		int count = priceList.size();
		for(int i=0; i<count;i++) {
			Double single = priceList.get(i);
			total = total + single;
		}
		return total;
	}
/*
	@Override
	public Page<Spending> findPaginated(int pageNo, int pageSize) {
		Pageable pageable = PageRequest.of(pageNo-1, pageSize);
		return this.spendingRepository.findAll(pageable);
	}
	*/
	








	
	

}
