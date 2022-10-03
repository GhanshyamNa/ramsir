package com.infy.springbootrestapicrudapp.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infy.springbootrestapicrudapp.app.exception.ProductNotFoundException;
import com.infy.springbootrestapicrudapp.app.model.Product;
import com.infy.springbootrestapicrudapp.app.servicei.ProductServiceI;

@RestController
@RequestMapping(value = "/api")
public class ProductController {

	@Autowired
	ProductServiceI psi;
	
	// POST API
	@PostMapping(value = "/product",consumes = { "application/json","application/xml"})
	public ResponseEntity<Product> saveProduct(@RequestBody Product p) {
		
			try {
				int a=10/0;
			} catch (Exception e) {
				return new ResponseEntity<Product>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
					if(p.getProductId()==0) {
						return new ResponseEntity<Product>(HttpStatus.BAD_REQUEST);
					}
					else {
						Product product=psi.saveProduct(p);
						
						return	new ResponseEntity<Product>(product, HttpStatus.CREATED);
					}
		
		
	}
	
	//GET API
	
	@GetMapping(value = "/products")
	public ResponseEntity<List<Product>> getproducts(){
		List<Product> list=psi.getproducts();
				if(list.isEmpty()) {
					return new ResponseEntity(HttpStatus.NO_CONTENT);
				}
		
		return new ResponseEntity(list,HttpStatus.OK);
	}
	
	//PUT API
	
	@PutMapping(value = "/product/{productId}")
	public ResponseEntity<Product> updateProdcut(@RequestBody Product p,@PathVariable Long productId)
	{
		
		Product pp=psi.updateProdcut(productId,p);
	return new ResponseEntity<Product>(pp,HttpStatus.OK);
	}
	 // delete Api
	
	@DeleteMapping(value = "/product/{productId}")
	public ResponseEntity deleteProduct(@PathVariable Long productId) {
		psi.deleteProduct(productId);
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}
	
	// getApi
	@GetMapping(value = "/product/{productName}",produces = {"application/xml","application/json"})
	public ResponseEntity<Product> getProduct(@PathVariable String productName){
		               Product p=psi.getProduct(productName);
		               		
		               				return new ResponseEntity<Product>(p,HttpStatus.OK);
		               		
	}
		               		
	/*
	 * @ExceptionHandler(ProductNotFoundException.class) public
	 * ResponseEntity<String>
	 * productNotFoundExceptionHandler(ProductNotFoundException e){
	 * System.out.println("handle"); return new
	 * ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_FOUND); }
	 */		               
		        
	/*
	 * @ExceptionHandler(ArithmeticException.class) public ResponseEntity<String>
	 * ArithmeticExceptionExceptionHandler(ArithmeticException e){
	 * System.out.println("handle"); return new
	 * ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_FOUND); }
	 */
	
	
	}
	
	
	
	
	
	
	
	

