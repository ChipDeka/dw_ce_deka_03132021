package com.api.dealerware.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="product")
public class Product {
	
	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column (name = "id")
    private Integer id;
    @Column (name = "name")
	private String name;
    @Column (name = "description")
	private String description;
    @Column (name = "sku")
	private String sku;
    
    public Product() {
    	
    }
    
    
	public Product(String name, String description, String sku) {
		super();
		this.name = name;
		this.description = description;
		this.sku = sku;

	}
	public Integer getId() {
		return id;
	}
	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public String getSku() {
		return sku;
	}
	



}
