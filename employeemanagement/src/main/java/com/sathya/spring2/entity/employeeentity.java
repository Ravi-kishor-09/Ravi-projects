package com.sathya.spring2.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name="Employee")
public class employeeentity {
	@jakarta.persistence.Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	private long Id;
	private String Name;
	private int age;
	private String gender;
	double basicSalary;      
	double hra;              
	double da; 
	double incometax; 
	double allowances;       
	double deductions;       
	double grossSalary;      
	double netSalary;  
    double providentFund;
    double otherDeductions;

}
