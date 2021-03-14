package com.api.dealerware.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Orders_history")
public class OrdersHistory {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;

	@Column(name = "sku")
	private String sku;

	@Column(name = "total")
	private BigDecimal total;

	@Column(name = "created_at")
	private LocalDateTime createdAt;

	@JsonIgnore
	@Column(name = "customer_id")
	private Integer customerId;

	@JsonIgnore
	@Column(name = "customer_name")
	private String customerName;

	@JsonIgnore
	@Column(name = "customer_email")
	private String customerEmail;

	@JsonIgnore
	@Column(name = "product_name")
	private String productName;

	@JsonIgnore
	@Column(name = "product_description")
	private String productDescription;

	public Long getId() {
		return id;
	}

	public String getSku() {
		return sku;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

}
