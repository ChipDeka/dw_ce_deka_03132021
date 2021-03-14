package com.api.dealerware.controller;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.dealerware.model.Customer;
import com.api.dealerware.model.Orders;
import com.api.dealerware.model.OrdersHistory;
import com.api.dealerware.model.Product;
import com.api.dealerware.repository.CustomerRepository;
import com.api.dealerware.repository.OrdersHistoryRepository;
import com.api.dealerware.repository.OrdersRepository;
import com.api.dealerware.repository.ProductRepository;

@RestController
public class RestControllers {

	private static final BigDecimal total = new BigDecimal(12.56);

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private OrdersRepository ordersRepository;

	@Autowired
	private OrdersHistoryRepository ordersHistoryRepository;

	@PostMapping("/customers")
	ResponseEntity<?> newUser(@RequestBody Customer customer) {
		Customer cust=customerRepository.save(customer);
		return new ResponseEntity<>(cust,HttpStatus.CREATED);
	}

	@GetMapping("/products")
	List<Product> products() {
		return (List<Product>) productRepository.findAll();
	}

	@GetMapping("/customers/{id}/orders")
	List<OrdersHistory> orders(@PathVariable Integer id) {
		return ordersHistoryRepository.findBycustomerId(id);
	}

	@PostMapping("/customers/{id}/orders")
	Orders createOrders(@PathVariable Integer id, @RequestBody Product product) throws SQLException, Exception {
		validateCreateOrdersInput(id, product);
		return ordersRepository.save(new Orders(id, product.getSku(), total, LocalDateTime.now()));
	}

	private void validateCreateOrdersInput(Integer id, Product product) throws SQLException, Exception {
		Optional<Customer> customer = customerRepository.findById(id);
		if (!customer.isPresent()) {
			throw new Exception("no customer found");
		}
		List<Product> listProducts = productRepository.findBySku(product.getSku());
		if (!(listProducts != null && listProducts.size() > 0)) {
			throw new Exception("no product found");
		}

	}
}
