 package com.webapp.acc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PostMapping;

import com.webapp.acc.entity.Spending;
import com.webapp.acc.repository.SpendingRepository;
import com.webapp.acc.service.SpendingService;

@SpringBootApplication
public class AccountingWebAppApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(AccountingWebAppApplication.class, args);
	}

	@Autowired
	private SpendingRepository spendingRepository;
	@Override
	public void run(String... args) throws Exception {
		//Spending spending1 = new Spending("cola", "food",  2.21,"0315","for John");
		//spendingRepository.save(spending1);
	}

}
