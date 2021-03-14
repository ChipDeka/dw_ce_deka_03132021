package com.api.dealerware;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(RestExceptionHandler.class)
public class DealerwareApplication {

	public static void main(String[] args) {
		SpringApplication.run(DealerwareApplication.class, args);
	}

}
