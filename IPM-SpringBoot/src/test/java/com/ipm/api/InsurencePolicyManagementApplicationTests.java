package com.ipm.api;

import org.junit.jupiter.api.Test;

import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.ipm.api.customer.*;
import com.ipm.api.admin.*;

@SpringBootTest
class InsurencePolicyManagementApplicationTests {
	@Autowired
	private CustomerRepo userRepository;
	@Autowired
	private AdminRepo adminRepository;



	// Testing with Customer
	// Creating a customer
	@Test
	public void addCustomer() {
		Customer user = new Customer();
//		user.setCid((long) 2);
		user.setCname("Vaishu4");
		user.setCphno("7685943241");
		user.setCpassword("Vaishu543");
		user.setCemail("vaishu4@gmail.com");
		user.setCage("25");
		user.setCgender("female");
		user.setCaddress("Adn");
		userRepository.save(user);
	}

	// List of Customers
	@Test
	public void customers() {
		List<Customer> list = userRepository.findAll();
		System.out.println("\n  | List of the Customers | \n");
		list.forEach(System.out::println);
		assertThat(list).size().isGreaterThan(0);
		System.out.println("\n");
		assertThat(list).size().isGreaterThan(0);
	}

	// customer details update
	@Test
	public void updateCustomer() {
		Customer user = userRepository.findById((long) 2).get();
		user.setCname("Abc");
		user.setCemail("abc@gmail.com");
		user.setCpassword("abd5132001");
		user.setCphno("6655448899");
		userRepository.save(user);
		assertNotEquals("abcd@gmail.com", userRepository.findById((long) 2).get().getCemail());
		assertNotEquals("Abcd2001", userRepository.findById((long) 2).get().getCpassword());
		assertNotEquals("9988776655", userRepository.findById((long) 2).get().getCphno());
	}

	// Get user by id
	@Test
	public void getUserbn() {
		Customer user = userRepository.findById((long) 1).get();
		assertEquals("Void Alpha", user.getCname());
		System.out.println("\n" + user);
	}

	// End of user testing

	
	

	// admin test cases
	// add admin

	@Test
	public void addAdmin() {
		Admin admin = new Admin();
		admin.setAdminname("admin9");
		admin.setAdminphno("8543269782");
		admin.setAdminpassword("Admin@123");
		admin.setAdminemail("admin9gmail.com");
		admin.setAdminage("23");
		admin.setAdmingender("male");
		admin.setAdminaddress("KA");
		admin.setAdminJoinDate("15/09/2023 13:30s");
		admin.setSeniormangeremail("senior@gmail.com");
		adminRepository.save(admin);
	}

	// List of Admins

	@Test
	public void listAdmins() {
		List<Admin> list = adminRepository.findAll();
		System.out.println("\n  | List of the Admins | \n");
		list.forEach(System.out::println);
		assertThat(list).size().isGreaterThan(0);
		System.out.println("\n");
	}




}
