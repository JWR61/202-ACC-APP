package com.webapp.acc.repository;
import java.awt.print.Pageable;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.webapp.acc.entity.Spending;




@Repository
public interface SpendingRepository extends JpaRepository<Spending, Long> {
	
	@Query("SELECT s FROM Spending s WHERE "
			+ "CONCAT(s.name, s.type, s.price, s.note)"
			+ "LIKE %?1%"
			)
	public List<Spending> findAll (String keyword );


}
