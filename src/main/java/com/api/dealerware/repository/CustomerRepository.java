package com.api.dealerware.repository;

import org.springframework.data.repository.CrudRepository;

import com.api.dealerware.model.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {
	
}
