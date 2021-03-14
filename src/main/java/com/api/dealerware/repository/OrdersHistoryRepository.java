package com.api.dealerware.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;


import com.api.dealerware.model.OrdersHistory;

public interface OrdersHistoryRepository extends CrudRepository<OrdersHistory, Long> {
	
	 List<OrdersHistory> findBycustomerId(Integer customerId);

}
