package com.infy.springbootrestapicrudapp.app.repositary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.infy.springbootrestapicrudapp.app.model.Product;

@Repository
public interface ProductRepositary extends JpaRepository<Product,Long > {
	
	public Product findByProductName(String productName);

}
