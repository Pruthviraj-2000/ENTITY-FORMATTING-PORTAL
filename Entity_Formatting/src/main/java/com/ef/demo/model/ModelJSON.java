package com.ef.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "JSONdata")
public class ModelJSON {
	@Id
	@GeneratedValue
	private long id;
	private String name;
	private String date;
	private String price;
	private String tax;
	private String description;

	
	public String getTax() {
		return tax;
	}
	public void setTax(String tax) {
		this.tax = tax;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public ModelJSON(String name, String date, String price, String tax, String description) {
		super();
		this.name = name;
		this.date = date;
		this.price = price;
		this.tax=tax;
		this.description=description;
	}
	public ModelJSON() {
		super();
		// TODO Auto-generated constructor stub
	}
}
