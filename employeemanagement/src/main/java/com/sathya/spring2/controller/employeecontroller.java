package com.sathya.spring2.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import com.sathya.spring2.entity.employeeentity;
import com.sathya.spring2.model.employeemodel;
import com.sathya.spring2.service.employeeservice;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;




@Controller
public class employeecontroller {
	@Autowired
	employeeservice employeeservice;
	
	@GetMapping("/employee")
	public String greet() {
		return "add-employee";
	}
	@PostMapping("/saveemployee")
	public String saveemployee(employeemodel employeemodel) {
		employeeservice.saveemployeeDetails(employeemodel);
		
		return "success";
	}
	@GetMapping("/getallemployee")
	public String getallDetails(Model model) {
		List<employeeentity> employees = employeeservice.getallDetails();
		
		model.addAttribute("employees", employees);
		
		return  "employee-list";
	}
	@GetMapping("/search")
	public String getsearchemployee() {
		return "search-employee";
	}
	@PostMapping("/searchbyid")
	public String searchById(@RequestParam Long id, Model model) {
		employeeentity employee = employeeservice.searchById(id);
		model.addAttribute("employee", employee);
		return "search-employee";
	}
	@GetMapping("/delete/{id}")
	public String deleteemployeeById(@PathVariable Long id) {
		employeeservice.deleteemployeeById(id);
		return "redirect:/getallemployee";
	}
	
	@GetMapping("/edit/{id}")
	public String editemployeeById(@PathVariable("id") Long id, Model model) {
		employeemodel employee = employeeservice.editById(id);
		model.addAttribute("employee",employee);
		model.addAttribute("id",id);
		return "edit-employee";
	}
	@PostMapping("/editbyid/{id}")
	public String editById(@PathVariable("id") Long id, employeemodel employeeModel) {
		
		employeeservice.editById(id,employeeModel);
		
		return "redirect:/getallemployee";
	}
	
	
	
	
	
	

	
}
