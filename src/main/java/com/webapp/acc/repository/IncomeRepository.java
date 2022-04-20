package com.webapp.acc.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.webapp.acc.entity.Income;



@Repository
public interface IncomeRepository extends JpaRepository<Income, Long> {
	
	@Query("SELECT i FROM Income i WHERE "
			+ "CONCAT(i.name, i.type, i.price, i.note)"
			+ "LIKE %?1%"
			)
	public List<Income> findAll (String keyword );
}