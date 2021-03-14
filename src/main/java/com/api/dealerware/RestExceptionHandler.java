package com.api.dealerware;

import java.sql.SQLException;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.api.dealerware.util.ExceptionData;

@RestControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class RestExceptionHandler {

	@ExceptionHandler(SQLException.class)
	public ExceptionData handleSqlException(SQLException sqlException) {
		return new ExceptionData(sqlException.getMessage());

	}

	@ExceptionHandler(Exception.class)
	public ExceptionData handleException(Exception exception) {
		return new ExceptionData(exception.getMessage());

	}

}
