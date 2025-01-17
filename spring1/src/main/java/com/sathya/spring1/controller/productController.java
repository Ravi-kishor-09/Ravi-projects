package com.sathya.spring1.controller;


import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.sathya.spring1.entity.productEntity;
import com.sathya.spring1.model.productmodel;
import com.sathya.spring1.service.productservice;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.RequestParam;






@Controller

public class productController {
	@Autowired
	productservice productservice;
	
	/*@GetMapping("/productform")
	public String greet() {
		return "add-product";
	}
	
	@PostMapping("/saveproduct")
	public String saveproduct(productmodel productmodel) {
		productservice.saveproductDetails(productmodel);
		
		return "success";
	} */
	
	// validation with default values
	@GetMapping("/productform")
	public String getProductForm(Model model)
	{
		productmodel productModel = new productmodel();
		productModel.setMadeIn("India");
		productModel.setQuantity(2);
		productModel.setDiscountRate(10.5);
		model.addAttribute("productModel", productModel);
		return "add-product";
	}
	
	
@PostMapping("/saveproduct")
	
	public String saveProduct(@Valid productmodel productModel , BindingResult bindingResult , Model model)
	{
		//used to store the fieldName : error message in the form of key : value
		HashMap<String, String> validationErrors = new HashMap<>();
		
		//to check errors are present or not
		if(bindingResult.hasErrors())
		{
			//to read all the field errors one by one 
			for(FieldError fieldError : bindingResult.getFieldErrors())
			{
				//putting the each field error into map
				validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
			}
			
			//adding the validationErrors into model object to send to view
			model.addAttribute("validationErrors", validationErrors);
			return "add-product";
		}
		//this code will execute when there is no errors
		productservice.saveproductDetails(productModel);
		return "redirect:/getallproducts";
	}
	
	
	@GetMapping("/getallproducts")
	public String getallproducts(Model model) {
		List<productEntity> products = productservice.getallproducts();
		
		model.addAttribute("products", products);
		
		return  "product-list";
	}
	@GetMapping("/searchbyid")
	public String searchproduct() {
		
		return "search-product";
	}
	
	@PostMapping("/searchbyid")
	public String searchById(@RequestParam Long id, Model model) {
		productEntity product = productservice.searchById(id);
		model.addAttribute("product",product);
		
		
		return "search-product";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteproductById(@PathVariable ("id") Long id) {
		productservice.deleteproductById(id);
		
		return  "redirect:/getallproducts";
	}
	@GetMapping("/edit/{id}")
	public String editproductById(@PathVariable("id") Long id, Model model) {
		productmodel product = productservice.editById(id);
		model.addAttribute("product",product);
		model.addAttribute("id",id);
		return "edit-product";
	}
	@PostMapping("/editbyid/{id}")
	public String editById(@PathVariable("id") Long id, productmodel productModel) {
		productservice.editById(id,productModel);
		
		
		return  "redirect:/getallproducts";
	}
	
	
	
	
	
	
	
	
	
	
	
}