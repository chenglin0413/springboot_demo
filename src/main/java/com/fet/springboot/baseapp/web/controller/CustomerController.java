package com.fet.springboot.baseapp.web.controller;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fet.springboot.baseapp.logic.service.impl.CustomerServiceImpl;
import com.fet.springboot.baseapp.repo.domain.Customer;


/**
 * Handle Response/Request from API , Business Logic here. 
 * @author jamlin
 * @See - README.md (reference:github/bezkoder)
 */
@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class CustomerController {
	private static Logger logger = LoggerFactory.getLogger(CustomerController.class);
	@Autowired
	CustomerServiceImpl customerServiceImpl;
	
	private Sort.Direction getSortDirection(String direction) {
	    if (direction.equals("asc")) {
	      return Sort.Direction.ASC;
	    } else if (direction.equals("desc")) {
	      return Sort.Direction.DESC;
	    }

	    return Sort.Direction.ASC;
	 }
	  /**
	   * 
	   * @param  sort
	   * @return return new ResponseEntity<>(customers, HttpStatus.OK);
	   */
	  @GetMapping("/sortedcustomers")
	  public ResponseEntity<List<Customer>> getAllCustomers(@RequestParam(defaultValue = "id,desc") String[] sort) {

	    try {
	      List<Order> orders = new ArrayList<Order>();

	      if (sort[0].contains(",")) {
	        // will sort more than 2 fields
	        // sortOrder="field, direction"
	        for (String sortOrder : sort) {
	          String[] _sort = sortOrder.split(",");
	          orders.add(new Order(getSortDirection(_sort[1]), _sort[0]));
	        }
	      } else {
	        // sort=[field, direction]
	        orders.add(new Order(getSortDirection(sort[1]), sort[0]));
	      }

	      List<Customer> customers = customerServiceImpl.findAll(Sort.by(orders));

	      if (customers.isEmpty()) {
	    	logger.info("CustomerController - getAllCustomers - No content ");
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	      }

	      logger.info("CustomerController - getAllCustomers - OK ");
	      return new ResponseEntity<>(customers, HttpStatus.OK);
	    } catch (Exception e) {
	      logger.error("CustomerController - getAllCustomers - INTERNAL_SERVER_ERROR ");
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
	  /**
	   * 
	   * @param firstName
	   * @param page
	   * @param size
	   * @param sort
	   * @return new ResponseEntity<>(response, HttpStatus.OK)
	   */
	  @GetMapping("/customers")
	  public ResponseEntity<Map<String, Object>> getAllCustomersPage(
	      @RequestParam(required = false) String firstName,
	      @RequestParam(defaultValue = "0") int page,
	      @RequestParam(defaultValue = "3") int size,
	      @RequestParam(defaultValue = "id,desc") String[] sort) {

	    try {
	      List<Order> orders = new ArrayList<Order>();

	      if (sort[0].contains(",")) {
	        // will sort more than 2 fields
	        // sortOrder="field, direction"
	        for (String sortOrder : sort) {
	          String[] _sort = sortOrder.split(",");
	          orders.add(new Order(getSortDirection(_sort[1]), _sort[0]));
	        }
	      } else {
	        // sort=[field, direction]
	        orders.add(new Order(getSortDirection(sort[1]), sort[0]));
	      }

	      List<Customer> customers = new ArrayList<Customer>();
	      Pageable pagingSort = PageRequest.of(page, size, Sort.by(orders));

	      Page<Customer> pageCusts;
	      
	      if (firstName == null) 
	    	  pageCusts = customerServiceImpl.findAll(pagingSort);
	      else
	    	  pageCusts = customerServiceImpl.findByFirstNameContaining(firstName, pagingSort);

	      customers = pageCusts.getContent();

	      Map<String, Object> response = new HashMap<>();
	      response.put("customers", customers);
	      response.put("currentPage", pageCusts.getNumber());
	      response.put("totalItems", pageCusts.getTotalElements());
	      response.put("totalPages", pageCusts.getTotalPages());

	      logger.info("CustomerController - getAllCustomersPage - OK ");
	      return new ResponseEntity<>(response, HttpStatus.OK);
	    } catch (Exception e) {
	      logger.error("CustomerController - getAllCustomersPage - INTERNAL_SERVER_ERROR ");
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }

	  /**
	   * 
	   * @param id
	   * @return new ResponseEntity<>(customerData.get(), HttpStatus.OK);
	   */
	  @GetMapping("/customers/{id}")
	  public ResponseEntity<Customer> getCustomerById(@PathVariable("id") long id) {
	    Optional<Customer> customerData = customerServiceImpl.findById(id);

	    if (customerData.isPresent()) {
	      logger.info("CustomerController - getCustomerById - OK");
	      return new ResponseEntity<>(customerData.get(), HttpStatus.OK);
	    } else {
	      logger.info("CustomerController - getCustomerById - Not Found");
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }
	  @PostMapping("/customers")
	  public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
	    try {
			Date currentDate=new Date();
			System.out.println(currentDate);
	    	Customer newCustomer = customerServiceImpl.save(new Customer(
	    			customer.getFirstName(),
	    			customer.getLastName(), 
	    			customer.getEmailAddress(),
	    			currentDate));
	      logger.info("CustomerController - createCustomer - OK");
	      return new ResponseEntity<>(newCustomer, HttpStatus.CREATED);
	    } catch (Exception e) {
	      logger.error("CustomerController - createCustomer - INTERNAL_SERVER_ERROR");
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
}
