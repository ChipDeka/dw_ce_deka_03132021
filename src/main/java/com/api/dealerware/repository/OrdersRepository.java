package com.api.dealerware.repository;

import org.springframework.data.repository.CrudRepository;

import com.api.dealerware.model.Orders;

public interface OrdersRepository extends CrudRepository<Orders, Integer> {

}
