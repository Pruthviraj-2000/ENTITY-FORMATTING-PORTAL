package com.ef.demo.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
@Entity
public class User {
    @Id
    @GeneratedValue
    private Long id;
    
    private String firstname;
    
    private String lastname;
    
    
    @NotEmpty(message = "Email is required")
    @Column(unique = true)
    private String email;
    
    @NotEmpty(message = "Password is required")
    private String password;
    
    private String role;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
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

	public User(String firstname, String lastname, @NotEmpty(message = "Email is required") String email,
			@NotEmpty(message = "Password is required") String password) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.password = password;
		this.role="User";
	}

    protected User() {
    	
    }
    public List<String> getRoleAsList() {
        return Arrays.asList(this.role);
    }

    public String getRole() {
		return role;
	}

	public void setRoles(String role) {
        this.role = role;
    }
    }