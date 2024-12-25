package com.sathya.spring1.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name="product")

public class productEntity {
	@jakarta.persistence.Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long Id;
	private String Name;
	private String Brand;
	private String MadeIn;
	private double Price;
	private int Quantity;
	private double discountRate;
	private double taxRate;
	private double discountprice;
	private double offerprice;
	private double stockvalue;
	private double finalprice;
	

}
