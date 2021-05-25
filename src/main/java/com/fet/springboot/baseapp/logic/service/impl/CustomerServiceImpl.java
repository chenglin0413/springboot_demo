package com.fet.springboot.baseapp.logic.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.fet.springboot.baseapp.logic.service.CustomerService;
import com.fet.springboot.baseapp.repo.domain.Customer;
import com.fet.springboot.baseapp.repo.jpa.repository.CustomerRepository;
@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public Page<Customer> findByFirstNameContaining(String firstName, Pageable pageable) {
		return customerRepository.findByFirstNameContaining(firstName, pageable);
	}

	@Override
	public List<Customer> findByFirstNameContaining(String firstName, Sort sort) {
		return customerRepository.findByFirstNameContaining(firstName, sort);
	}
	@Override
	public List<Customer> findAll(Sort sort) {
		return customerRepository.findAll(sort);
	}
	
	@Override
	public Page<Customer> findAll(Pageable pageable) {
		return customerRepository.findAll(pageable);
	}
	@Override
	public Customer save(Customer customer) {
		return customerRepository.save(customer);
	}
	@Override
	public Optional<Customer> findById(Long id) {
		return customerRepository.findById(id);
	}
	
}
