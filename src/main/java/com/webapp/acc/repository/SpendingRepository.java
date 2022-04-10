package com.webapp.acc.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.webapp.acc.entity.Spending;



@Repository
public interface SpendingRepository extends JpaRepository<Spending, Long> {

}
