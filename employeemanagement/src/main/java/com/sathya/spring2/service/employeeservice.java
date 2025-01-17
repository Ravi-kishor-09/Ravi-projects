package com.sathya.spring2.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.sathya.spring2.entity.employeeentity;
import com.sathya.spring2.model.employeemodel;
import com.sathya.spring2.repository.employeerepository;

@Service
public class employeeservice {
	@Autowired
	employeerepository employeerepository;
	
	public void saveemployeeDetails(employeemodel employeemodel) {
		double hra; 
		hra = employeemodel.getBasicSalary()*0.20;
		
		double da;
		da = employeemodel.getBasicSalary()*0.10;

		double deductions;
		deductions = employeemodel.getIncomeTax()+employeemodel.getProvidentFund()+employeemodel.getOtherDeductions();
		
		double grossSalary;    
		grossSalary = employeemodel.getBasicSalary()+hra+da+employeemodel.getAllowances();
		
		double netSalary;   
		netSalary = grossSalary - deductions;
		
		employeeentity employeeentity = new employeeentity();
		employeeentity.setAge(employeemodel.getAge());
		employeeentity.setAllowances(employeemodel.getAllowances());
		employeeentity.setBasicSalary(employeemodel.getBasicSalary());
		employeeentity.setIncometax(employeemodel.getIncomeTax());
		employeeentity.setName(employeemodel.getName());
		employeeentity.setGender(employeemodel.getGender());
		employeeentity.setOtherDeductions(employeemodel.getOtherDeductions());
		employeeentity.setProvidentFund(employeemodel.getProvidentFund());
		employeeentity.setNetSalary(netSalary);
		employeeentity.setDa(da);
		employeeentity.setDeductions(deductions);
		employeeentity.setHra(hra);
		employeeentity.setNetSalary(netSalary);
		employeeentity.setGrossSalary(grossSalary);
		
		employeerepository.save(employeeentity);
		
		
	}
	public List<employeeentity> getallDetails(){
		List<employeeentity> employees = employeerepository.findAll();
		
		return employees;
		
	}
	public employeeentity searchById(Long id) {
		Optional<employeeentity> optionalData =employeerepository.findById(id);
		if(optionalData.isPresent()) {
			employeeentity employee = optionalData.get();
			return employee;
			
		}
		else {
			return null;
		}
	}
	public void deleteemployeeById(Long id) {
		employeerepository.deleteById(id);
		
	}
	
	public employeemodel editById(Long id) {
		Optional<employeeentity> optionalData = employeerepository.findById(id);
		employeeentity entity = optionalData.get();
		employeemodel employeeModel = new employeemodel();
		employeeModel.setName(entity.getName());
		employeeModel.setAge(entity.getAge());
		employeeModel.setBasicSalary(entity.getBasicSalary());
		employeeModel.setAge(entity.getAge());
		employeeModel.setGender(entity.getGender());
		employeeModel.setAllowances(entity.getAllowances());
		employeeModel.setIncomeTax(entity.getIncometax());
		employeeModel.setOtherDeductions(entity.getOtherDeductions());
		employeeModel.setProvidentFund(entity.getProvidentFund());
		return employeeModel;
		
	}
	
		
			
		
		public void editById(Long id, employeemodel employeeModel) {
			Optional<employeeentity> optionalData = employeerepository.findById(id);
			if(optionalData.isPresent()) {
				employeeentity employeeentity = optionalData.get();
				
				double hra; 
				hra = employeeModel.getBasicSalary()*0.20;
				
				double da;
				da = employeeModel.getBasicSalary()*0.10;

				double deductions;
				deductions = employeeModel.getIncomeTax()+employeeModel.getProvidentFund()+employeeModel.getOtherDeductions();
				
				double grossSalary;    
				grossSalary = employeeModel.getBasicSalary()+hra+da+employeeModel.getAllowances();
				
				double netSalary;   
				netSalary = grossSalary - deductions;
				
				
				employeeentity.setAge(employeeModel.getAge());
				employeeentity.setAllowances(employeeModel.getAllowances());
				employeeentity.setBasicSalary(employeeModel.getBasicSalary());
				employeeentity.setIncometax(employeeModel.getIncomeTax());
				employeeentity.setName(employeeModel.getName());
				employeeentity.setGender(employeeModel.getGender());
				employeeentity.setOtherDeductions(employeeModel.getOtherDeductions());
				employeeentity.setProvidentFund(employeeModel.getProvidentFund());
				employeeentity.setNetSalary(netSalary);
				employeeentity.setDa(da);
				employeeentity.setDeductions(deductions);
				employeeentity.setHra(hra);
				employeeentity.setNetSalary(netSalary);
				employeeentity.setGrossSalary(grossSalary);
				
				employeerepository.save(employeeentity);
			
		}
		
	}
	
	
	

}
