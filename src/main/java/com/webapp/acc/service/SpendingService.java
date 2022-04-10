package com.webapp.acc.service;

import java.util.List;

import com.webapp.acc.entity.Spending;

public interface SpendingService {
	List<Spending> getAllSpendings();
	Spending saveSpending(Spending spending);
	Spending getSpendingById (long id);
	Spending updateSpending (Spending spending);
	void deleteSpendingById(long id);

}
