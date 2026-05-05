package com.employyemanagementsystem.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="users")
@Data
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String userName;
	
	private String password;
	
	private String role; 
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return userName;
	}
	public void setUsername(String username) {
		this.userName = username;
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
	
	
}