package com.webapp.acc.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.webapp.acc.entity.Spending;

public interface SpendingService {
	List<Spending> getAllSpendings(String keyword);
	Spending saveSpending(Spending spending);
	Spending getSpendingById (long id);
	Spending updateSpending (Spending spending);
	void deleteSpendingById(long id);
	Double getTotalPrice();
	//Page <Spending> findPaginated(int pageNo, int pageSize);
	//Page <Spending> findPagination(int offset, int pageSize);
}
