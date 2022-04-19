package com.webapp.acc.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.webapp.acc.entity.Income;



@Repository
public interface IncomeRepository extends JpaRepository<Income, Long> {
}