package com.project.technicalTest.models;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name = "user_name",nullable = false)
	private String name;
	
	@Column(name = "user_birthdate",nullable = false)
	private LocalDate birthdate;
	
	@Column(name = "residence_country",nullable = false)
	private String country;
	
	@Column(name = "phone_number",nullable = true)
	private String phoneNumber;
	
	@Column(name = "gender_name",nullable = true)
	private char gender;
	
	public User() {
		
	}
	
	public User(String name, String residenceCountry) {
		super();
		this.name = name;
		this.country = residenceCountry;
	}

	public User(String name, LocalDate birthdate, String residenceCountry) {
		super();
		this.name = name;
		this.birthdate = birthdate;
		this.country = residenceCountry;
	}
	
	public User(String name, LocalDate birthdate, String residenceCountry, String phoneNumber, char gender) {
		this(name, birthdate, phoneNumber);
		this.country = residenceCountry;
		this.phoneNumber = phoneNumber;
		this.gender = gender;
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

	public LocalDate getBirthdate() {
		return birthdate;
	}

	public void setBirthday(LocalDate birthdate) {
		this.birthdate = birthdate;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String residenceCountry) {
		this.country = residenceCountry;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}
	
}
