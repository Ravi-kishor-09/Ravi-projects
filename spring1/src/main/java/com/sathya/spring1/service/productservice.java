package com.sathya.spring1.service;

import java.util.*;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sathya.spring1.entity.productEntity;
import com.sathya.spring1.model.productmodel;
import com.sathya.spring1.repository.productrepositort;

@Service

public class productservice {
	@Autowired
	productrepositort productrepositort;
	
	public void saveproductDetails(productmodel productmodel) {
		double stockvalue;
	    stockvalue = productmodel.getPrice()*productmodel.getQuantity();
	    
	    double discountprice;
	    discountprice = productmodel.getPrice()*productmodel.getDiscountRate()/100;
	    
	    double taxrate =18.0;
	    
	    double offerprice;
	    offerprice = productmodel.getPrice()-discountprice;
	    
	    double finalprice;
	    finalprice = offerprice+(offerprice*taxrate/100);
	    
	    productEntity productEntity = new productEntity();
	    productEntity.setName(productmodel.getName());
	    productEntity.setBrand(productmodel.getBrand());
	    productEntity.setMadeIn(productmodel.getMadeIn());
	    productEntity.setDiscountprice(discountprice);
	    productEntity.setPrice(productmodel.getPrice());
	    productEntity.setQuantity(productmodel.getQuantity());
	    productEntity.setDiscountRate(productmodel.getDiscountRate());
	    productEntity.setOfferprice(offerprice);
	    productEntity.setFinalprice(finalprice);
	    productEntity.setStockvalue(stockvalue);
	    productEntity.setTaxRate(taxrate);
	    
	    productrepositort.save(productEntity);
		
	}
	public List<productEntity> getallproducts(){
		List<productEntity> products = productrepositort.findAll();
		
		return products;
		
	}
	public productEntity searchById(Long id) {
		Optional<productEntity> optionalData = productrepositort.findById(id);
		if(optionalData.isPresent()) {
			productEntity product = optionalData.get();
			return product;
		}
		else {
			return null;
		}
	}
	public productEntity searchById1(Long id) {
		
		return null;
	}
	public void deleteproductById(Long id) {
		productrepositort.deleteById(id);
		
	}
	public productmodel editById(Long id) {
		Optional<productEntity> optionalData = productrepositort.findById(id);
		productEntity entity = optionalData.get();
		productmodel productmodel = new productmodel();
		productmodel.setName(entity.getName());
		productmodel.setBrand(entity.getBrand());
		productmodel.setPrice(entity.getPrice());
		productmodel.setMadeIn(entity.getMadeIn());
		productmodel.setDiscountRate(entity.getDiscountRate());
		productmodel.setQuantity(entity.getQuantity());
		return productmodel;
		
	}
	public void editById(Long id, productmodel productModel) {
		Optional<productEntity> optionalData = productrepositort.findById(id);
		if(optionalData.isPresent()) {
			productEntity productEntity = optionalData.get();
			double stockvalue;
		    stockvalue = productModel.getPrice()*productModel.getQuantity();
		    
		    double discountprice;
		    discountprice = productModel.getPrice()*productModel.getDiscountRate()/100;
		    
		    double taxrate =18.0;
		    
		    double offerprice;
		    offerprice = productModel.getPrice()-discountprice;
		    
		    double finalprice;
		    finalprice = offerprice+(offerprice*taxrate/100);
		    
		   
		    productEntity.setName(productModel.getName());
		    productEntity.setBrand(productModel.getBrand());
		    productEntity.setMadeIn(productModel.getMadeIn());
		    productEntity.setDiscountprice(discountprice);
		    productEntity.setPrice(productModel.getPrice());
		    productEntity.setQuantity(productModel.getQuantity());
		    productEntity.setDiscountRate(productModel.getDiscountRate());
		    productEntity.setOfferprice(offerprice);
		    productEntity.setFinalprice(finalprice);
		    productEntity.setStockvalue(stockvalue);
		    productEntity.setTaxRate(taxrate);
		    
		    productrepositort.save(productEntity);
		}
		
	}
	

}
