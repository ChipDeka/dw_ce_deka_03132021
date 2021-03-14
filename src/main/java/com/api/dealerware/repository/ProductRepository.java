package com.api.dealerware.repository;



import java.util.List;

import org.springframework.data.repository.CrudRepository;


import com.api.dealerware.model.Product;

public interface ProductRepository extends CrudRepository<Product, Integer> {
	List<Product> findBySku(String sku);
}
