# dw_ce_deka_03132021
if you have any question regarding this code please email me at bobdeka1978@gmail.com.  -- Chip

Technology used:-
      1. spring boot 2.8
      2.Java 1.8
      3. maven 4
      4 h2 database as storage

To run :-  got to the directory  and execute   ./mvnw spring-boot:run

To Test:-   got to the directory  and execute  ./mvnw  test

API implemented:-

User can create a new Customer (POST /customers)
User can view a list of Products (GET /products)
User can create a Customer Order (POST /customers/:id/orders)
User can view a Customer’s Order History (GET /customers/:id/orders)

Notes: 1. please be mindfull of a folder used in the H2 connections.
          ~/Desktop/data/dealerware
          used in  spring.datasource.url=jdbc:h2:file:~/Desktop/data/dealerware
       2. hard coded the total as primary.yml didn't mention from where to get in 
        POST /customers/:id/orders)
       2.I would have like to add foreign key constraint in Order table  but because of
         restarting difficulties , I didn't. 

       
