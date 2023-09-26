package com.ipm.api;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.ipm.api.customerQuery.*;


@SpringBootTest
class Queries {
	@Autowired
	private QustionsCustomerRepo CQuestions;


	
	// Add customer query
	@Test
	public void cQueries() {
		QuestionsCustomer queries = new QuestionsCustomer();
		queries.setCustomeremail("userone@gmail.com");
		queries.setQid((long) 24);
		queries.setQtopic("Policy");
		queries.setQdetails("What is Tenure for LIC Policy?");
		CQuestions.save(queries);
	}

	// Customer Query Answer
	@Test
	public void aCQueries() {
		QuestionsCustomer queries = CQuestions.findById((long) 23).get();
		queries.setQanswer("3 Years");
		queries.setAnswerdate("24/09/2023");
		CQuestions.save(queries);
		assertNotNull(CQuestions.findById((long) 23).get());
	}

	// Customer Query List
	@Test
	public void cQueryList() {
		List<QuestionsCustomer> list = CQuestions.findAll();
		assertThat(list).size().isGreaterThan(0);
		System.out.println("\n");
		list.forEach(System.out::println);
	}
	
	
}
