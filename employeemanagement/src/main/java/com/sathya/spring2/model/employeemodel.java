package com.sathya.spring2.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class employeemodel {
	
	private String Name;
	private double basicSalary;
	private int age;
	private String gender;
    double allowances; 
    double providentFund; 
    double incomeTax;    
    double otherDeductions;
	
	

}
