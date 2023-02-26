package com.cts.ss.model;


import javax.persistence.Entity;
import javax.persistence.Id;

//import lombok.Data;



@Entity
public class Stock {

	@Id
	private String stock_Id;
	private String stock_Name;
	private Double stock_Value;
	public String getStock_Id() {
		return stock_Id;
	}
	public void setStock_Id(String stock_Id) {
		this.stock_Id = stock_Id;
	}
	public String getStock_Name() {
		return stock_Name;
	}
	public void setStock_Name(String stock_Name) {
		this.stock_Name = stock_Name;
	}
	public Double getStock_Value() {
		return stock_Value;
	}
	public void setStock_Value(Double stock_Value) {
		this.stock_Value = stock_Value;
	}
	
	
//	public Stock(String stock_Id, String stock_Name, Double stock_Value) {
//		super();
//		this.stock_Id = stock_Id;
//		this.stock_Name = stock_Name;
//		this.stock_Value = stock_Value;
//	}
//	
	
	

}

