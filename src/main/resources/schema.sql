CREATE SCHEMA IF NOT EXISTS dealerware;

DROP TABLE IF EXISTS dealerware.customer;

CREATE TABLE dealerware.customer (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  name VARCHAR(250) NOT NULL,
  email VARCHAR(250) NOT NULL
);
CREATE SEQUENCE IF NOT EXISTS  dealerware.HIBERNATE_SEQUENCE START WITH 1 INCREMENT BY 1;

CREATE UNIQUE INDEX dealerware.customer_index
ON dealerware.customer ( email,name asc );

DROP TABLE IF EXISTS dealerware.product;

CREATE TABLE dealerware.product (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  name VARCHAR(250) NOT NULL,
  description VARCHAR(250) NOT NULL,
  sku VARCHAR(250) NOT NULL
);

CREATE UNIQUE INDEX dealerware.product_index
ON dealerware.product ( sku );

DROP TABLE IF EXISTS dealerware.orders;

CREATE TABLE dealerware.orders (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  customer_id INT NOT NULL,
  sku VARCHAR(250) NOT NULL,
  total decimal ( 12, 2 ),
  created_at timestamp NOT NULL
);

CREATE  INDEX dealerware.order_index
ON dealerware.orders ( customer_id );

CREATE  INDEX dealerware.order_index1
ON dealerware.orders ( sku );

DROP TABLE IF EXISTS dealerware.orders_history;

CREATE TABLE dealerware.orders_history (
  id BIGINT AUTO_INCREMENT  PRIMARY KEY,
  sku VARCHAR(250) NOT NULL,
  total decimal ( 12, 2 ),
  created_at timestamp NOT NULL,
  customer_id INT NOT NULL,
  customer_name VARCHAR(250) NOT NULL,
  customer_email VARCHAR(250) NOT NULL,
  product_name VARCHAR(250) NOT NULL,
  product_description VARCHAR(250) NOT NULL
  
);

CREATE  INDEX dealerware.orders_history_index
ON dealerware.orders_history ( customer_id,created_at );

CREATE  INDEX dealerware.orders_history_index1
ON dealerware.orders_history ( product_name,created_at );

CREATE  INDEX dealerware.orders_history_index2
ON dealerware.orders_history ( sku,created_at );


