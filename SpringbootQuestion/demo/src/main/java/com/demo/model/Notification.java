package com.demo.model;

import java.time.LocalDateTime;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Notification {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	private String message;

	@Column
	private String type;
	@Column
	private LocalDateTime timestamp;
	@Column
	private String response;

	
	public Notification() {
		
	}
	public Notification(String message, String type, LocalDateTime timestamp, String response) {
		super();
		this.message = message;
		this.type = type;
		this.timestamp = timestamp;
		this.response = response;
	}

	public Notification(Long id, String message, String type, LocalDateTime timestamp, String response) {
		super();
		this.id = id;
		this.message = message;
		this.type = type;
		this.timestamp = timestamp;
		this.response = response;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

}
