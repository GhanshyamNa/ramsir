package com.infy.springbootrestapicrudapp.app.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infy.springbootrestapicrudapp.app.exception.ProductNotFoundException;
import com.infy.springbootrestapicrudapp.app.model.Product;
import com.infy.springbootrestapicrudapp.app.repositary.ProductRepositary;
import com.infy.springbootrestapicrudapp.app.servicei.ProductServiceI;

import net.bytebuddy.asm.Advice.Return;
@Service
public class ProductServiceImpl implements ProductServiceI {
@Autowired
	ProductRepositary pr;
	
	@Override
	public Product saveProduct(Product p) {
		
		return pr.save(p);
	}

	@Override
	public List<Product> getproducts() {
	
		return pr.findAll();
	}

	@Override
	public Product updateProdcut(Long productId, Product p) {
							Optional<Product> op=pr.findById(productId);
									if(op.isPresent()) {
										Product pp=op.get();
										pp.setProductName(p.getProductName());
										pp.setProductDescription(p.getProductDescription());
										pp.setProductPrices(p.getProductPrices());
										 return pr.save(pp);
									}
									else {
										return null;
									}
				
	}

	@Override
	public void deleteProduct(Long productId) {
		pr.deleteById(productId);
		
	}

	@Override
	public Product getProduct(String productName) {
		  
		   Product p=pr.findByProductName(productName);
		      if(p!=null) {
		    	  return p;
		      }
		      else {
		    	  throw new ProductNotFoundException("Product Not AVAILABLE");
		      }
		
	}

}
