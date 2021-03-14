package com.api.dealerware;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import com.api.dealerware.controller.RestControllers;
import com.api.dealerware.model.Customer;
import com.api.dealerware.repository.CustomerRepository;
import com.api.dealerware.repository.OrdersHistoryRepository;
import com.api.dealerware.repository.OrdersRepository;
import com.api.dealerware.repository.ProductRepository;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import static org.assertj.core.api.Assertions.assertThat;

import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;

@WebMvcTest(RestControllers.class)
public class RestControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private CustomerRepository customerRepository;

	@MockBean
	private ProductRepository productRepository;

	@MockBean
	private OrdersRepository ordersRepository;

	@MockBean
	private OrdersHistoryRepository ordersHistoryRepository;

	@Test
	public void customerRepository() throws Exception {
		assertThat(customerRepository).isNotNull();
	}

	@Test
	public void testNewEmployee() throws Exception {
		Customer output = new Customer(1, "chip deka", "chip@dummy.org");
		when(this.customerRepository.save(any(Customer.class))).thenReturn(output);

		this.mockMvc
				.perform(post("/customers").contentType(MediaType.APPLICATION_JSON)
						.content("{ \"email\": \"chip@dummy.org\",\n" + "  \"name\": \"chip deka\"}"))
				.andDo(MockMvcResultHandlers.print()).andExpect(status().isCreated())
				.andExpect(content().json("{\"id\":1,\"name\":\"chip deka\",\"email\":\"chip@dummy.org\"}"));

	}

}
