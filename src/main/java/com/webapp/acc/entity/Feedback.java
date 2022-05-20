package com.webapp.acc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "feedback")
public class Feedback {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
		
	@Column(name = "content")
	private String feedback;


	public String getFeedback() {
		return feedback;
	}

	
	public Feedback(String feedback) {
		super();
		this.feedback = feedback;
	}


	public Feedback() {

	}


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}


	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
	
}
	
