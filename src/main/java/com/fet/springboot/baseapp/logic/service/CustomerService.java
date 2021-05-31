package com.fet.springboot.baseapp.logic.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.fet.springboot.baseapp.repo.domain.Customer;

public interface CustomerService {
	Page<Customer> findByFirstNameContaining(String firstName, Pageable pageable);
	List<Customer> findByFirstNameContaining(String firstName, Sort sort);
	List<Customer> findAll(Sort sort);
	Page<Customer> findAll(Pageable pageable);
	Optional<Customer> findById(Long id);
	Customer save(Customer customer);
	Customer findByFirstName(String firstName);
}
