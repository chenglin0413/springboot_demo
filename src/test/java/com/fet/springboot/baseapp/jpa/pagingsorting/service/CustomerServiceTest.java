package com.fet.springboot.baseapp.jpa.pagingsorting.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.fet.springboot.baseapp.logic.service.CustomerService;
import com.fet.springboot.baseapp.repo.domain.Customer;

@SpringBootTest
class CustomerServiceTest {
	@Autowired
	private CustomerService customerService;
	@BeforeEach
	void setUp() throws Exception {
	}
	
	@Test
	public void whenValidCustomerName_thenCustomerShouldFound() {
		String firstName = "jam";
		Customer found  =
				customerService.findByFirstName(firstName);
		assertEquals(firstName,found.getFirstName());
	}


}
