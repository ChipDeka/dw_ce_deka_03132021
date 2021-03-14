package com.api.dealerware;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.api.dealerware.controller.RestControllers;

@SpringBootTest
class DealerwareApplicationTests {
	
	@Autowired
	private RestControllers restController;

	@Test
	public void contextLoads() throws Exception {
		assertThat(restController).isNotNull();
	}


}
