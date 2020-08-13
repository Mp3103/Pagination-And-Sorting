package com.meet.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "STUDENTS")
@DynamicUpdate
public class Student {
	@Id
	@Column(name = "ID_STUDENT")
	private int ID_STUDENT;
	@Column(name = "USERNAME")
	private String username;
	@Column(name = "PASSWORD")
	private String password;
	@Column(name = "ENABLED")
	private int enabled;

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Student(int iD_STUDENT, String username, String password, int enabled) {
		super();
		this.ID_STUDENT = iD_STUDENT;
		this.username = username;
		this.password = password;
		this.enabled = enabled;
	}

	@JsonProperty
	public int getID_STUDENT() {
		return ID_STUDENT;
	}

	public void setID_STUDENT(int iD_STUDENT) {
		ID_STUDENT = iD_STUDENT;
	}
	
	@JsonProperty
	public int getEnabled() {
		return enabled;
	}

	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}
	
	@JsonProperty
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@JsonProperty
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
