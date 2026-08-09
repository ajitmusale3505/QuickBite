package com.jsp.fdms.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table( name = "Users")
public class User {
	
	@Id
	@GeneratedValue
	private int id;
	private String name;
	@Column(unique = true)
	private String email;
	private String password;
	private String role;
//	private String salt;  
	
	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(String name, String email, String password, String role) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.role = role;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

//	public String getSalt() {
//		return salt;
//	}
//
//	public void setSalt(String salt) {
//		this.salt = salt;
//	}
	
	
	
	
}
