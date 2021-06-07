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
 * @author jamLin
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
	 * Query data from DB , and return the result List<Customer> Object with specific firstName
	 * @param name
	 * @param Sort
	 * @return List<Customer>
	 */ 
	List<Customer> findByFirstNameContaining(String firstName, Sort sort);
	
	/**
	 * Query data from DB,and return List<Customer> , and sort by id desc.
	 * @param Sort
	 * @return List<Customer>
	 */
	List<Customer> findAll(Sort sort);
	
	/**
	 * Query data from DB,and return Page<Customer> , with pageable object.
	 * @param pageable
	 * @return Page<Customer>
	 */
	Page<Customer> findAll(Pageable pageable);
	
	/**
	 * Save data to DB, and return  Customer Object .
	 * @param pageable
	 * @return Page<Customer>
	 */
	Customer save(Customer customer);
	/**
	 * get non null Customer data with specific id.
	 * @param id
	 * @return Optional<Customer>
	 */
	Optional<Customer>  findById(Long id);
	
	/**
	 * Query data from DB ,find by FirstName, and return  Customer Object .
	 * @param firstName
	 * @return Customer
	 */
	Customer findByFirstName(String firstName);
}
