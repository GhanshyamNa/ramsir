package com.infy.springbootrestapicrudapp.app.servicei;

import java.util.List;

import com.infy.springbootrestapicrudapp.app.model.Product;

public interface ProductServiceI {

	public Product saveProduct(Product p);

	public List<Product> getproducts();

	public Product updateProdcut(Long productId, Product p);

	public void deleteProduct(Long productId);

	public Product getProduct(String productName);

}
