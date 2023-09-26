package com.ipm.api;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.Optional;
import com.ipm.api.admin.AdminRepo;
import com.ipm.api.customer.Customer;
import com.ipm.api.customer.CustomerRepo;

@SpringBootTest
public class TestOne {
	@Autowired
	private CustomerRepo userRepository;
	@Autowired
	private AdminRepo adminRepository;
	
	  @Autowired
	    private CustomerRepo customerRepo;
	// Testing with Customer
	
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
				
    //delete the customer
		 @Test
		    public void testDeleteCustomer() {
		        // Create a new customer to be deleted
		        Customer customerToDelete = new Customer();
		        customerToDelete.setCemail("test@example.com"); 
		        customerToDelete.setCname("Test Customer");

		        // Save the customer to the database
		        Customer savedCustomer = customerRepo.save(customerToDelete);

		        // Delete the customer by ID
		        customerRepo.deleteById(savedCustomer.getCid());

		        // Try to find the deleted customer by ID
		        Optional<Customer> deletedCustomer = customerRepo.findById(savedCustomer.getCid());

		        // Assert that the customer is not found (it should be deleted)
		        assertTrue(deletedCustomer.isEmpty());
		    }
		
		
	
}
