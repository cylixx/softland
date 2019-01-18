package com.example.springbootrestexample.vo;

import java.util.Date;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description="All details about the user")
public class User {
	private Integer id;
	
	@ApiModelProperty(notes="Name should have at least 2 characters")
	@Size(min=2, message="Name should have at least 2 characters")
	private String name;
	
	@ApiModelProperty(notes="Birth date should be in the past")
	@Past
	private Date birthDate;
	
	public User() {
		super();
	}
	public User(Integer id, String name, Date birthDate) {
		super();
		this.id = id;
		this.name = name;
		this.birthDate = birthDate;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	@Override
	public String toString() {
		return "User [" + (id != null ? "id=" + id + ", " : "") + (name != null ? "name=" + name + ", " : "")
				+ (birthDate != null ? "birthDate=" + birthDate : "") + "]";
	}
	
}
