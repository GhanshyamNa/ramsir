package com.infy.springbootrestapicrudapp.app.model;

import javax.persistence.Entity;

import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@XmlRootElement
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
	@Id
	private Long productId;
	private String productName;
	private String productDescription;
	private Double productPrices;
	

}
