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
@Table(name="orders")
public class Orders {
	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column (name = "id")
    private Integer id;
    
    @JsonIgnore
    @Column (name = "customer_id")
    private Integer customerId;
    
    @Column (name = "sku")
    private String sku;
    
    
    @Column (name = "total")
    private BigDecimal total;
        

    @Column (name = "created_at")
    private LocalDateTime createdAt;
    
    public Orders() {
    	
    }

	public Orders(Integer customerId, String sku, BigDecimal total, LocalDateTime createdAt) {
		super();
		this.customerId = customerId;
		this.sku = sku;
		this.total = total;
		this.createdAt = createdAt;
	}

	public Integer getId() {
		return id;
	}

	public Integer getCustomerId() {
		return customerId;
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
