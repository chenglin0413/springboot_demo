package com.fet.springboot.baseapp.repo.jpa.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fet.springboot.baseapp.repo.domain.Customer;
/**
 * JpaRepository Object
 * leverage JpaRepository<Object,Long> , generate Query Method 
 * 
 * @author jamlin
 *
 */
@Repository("customerRepository")
public interface CustomerRepository extends JpaRepository<Customer, Long> {
	/**
	 * Query data from DB , and return Pageable<Customer> Object .
	 * @param name
	 * @param pageable
	 * @return Page<Customer>
	 */  
	Page<Customer> findByFirstNameContaining(String firstName, Pageable pageable);
	
	/**
	 * Query data from DB , and return List<Customer> Object .
	 * @param name
	 * @param Sort
	 * @return List<Customer>
	 */ 
	List<Customer> findByFirstNameContaining(String firstName, Sort sort);
	List<Customer> findAll(Sort sort);
	Page<Customer> findAll(Pageable pageable);
	Customer save(Customer customer);
	Optional<Customer>  findById(Long id);
}
