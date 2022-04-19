package com.webapp.acc.service;

import java.util.List;

import com.webapp.acc.entity.Income;

public interface IncomeService {
	List<Income> getAllIncomes();
	Income saveIncome(Income income);
	Income getIncomeById (long id);
	Income updateIncome (Income income);
	void deleteIncomeById(long id);
	Double getTotalIncome();

}
