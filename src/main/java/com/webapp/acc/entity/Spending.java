package com.webapp.acc.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "spendings")

public class Spending {	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
		
	@Column(name = "Name")
	private String name;
    
	@Column(name = "Type")
	private String type;
    
	@Column(name = "Price")
	private double price;
    
	@Column(name = "Date")
	
	private String date;
    
	@Column(name = "Note")
	private String note;
	
	public Spending() {
		
	}
		
	public Spending(String name, String type, double price, String date, String note) {
		super();
		this.name = name;
		this.type = type;
		this.price = price;
		this.date = date;
		this.note = note;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	
	

}
