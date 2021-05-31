package com.fet.springboot.baseapp.jpa.pagingsorting.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.fet.springboot.baseapp.repo.domain.Customer;
import com.fet.springboot.baseapp.repo.jpa.repository.CustomerRepository;



	

@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
class CustomerRepositoryTest {
	
	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private TestEntityManager entityManager;
	@BeforeEach
	void setUp() throws Exception {
		Date date = new  Date();
		Customer customer = new Customer();
		customer.setDateCreated(date);
		customer.setFirstName("Jack");
		customer.setLastName("JohnHandsome");
		customer.setEmailAddress("Jack.JohnHandsome@gmail.com");
		
		entityManager.persist(customer);
	}
	@Test
	public void whenFindById_thenReturnCustomer() {
		Customer customer = customerRepository.findByFirstName("jack");
		assertEquals(customer.getFirstName(),"jack");
	}


}
