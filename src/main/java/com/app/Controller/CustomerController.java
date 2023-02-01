package com.app.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.Service.CustomerService;

@RestController
	@RequestMapping("/api/customers")
	public class CustomerController {
	  
	  @Autowired
	  private CustomerService customerService;
	  
	  @PutMapping("/{customerId}/promote")
	  public ResponseEntity<Void> promoteCustomer(@PathVariable Long customerId) {
	    customerService.promoteCustomer(customerId);
	    return ResponseEntity.noContent().build();
	  }

	}

