package com.example.demo.Entity;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;


@Entity
@Table(name="friendslist")
public class Friend {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@NotNull
	@Size(min=3,message="Name should be greater than 3 chars")
	@Column
	private String name;
	
	@NotNull
	@Range(min=0,max=100,message="Please provide a valid age between 0 to 100")
	@Column
	private int age;
	
	
	public Friend(@NotNull @Size(min = 3, message = "Name should be greater than 3 chars") String name,
			@NotNull int age,
			@Size(min = 10, max = 10, message = "Please provide a valid 10digit mobile number") String mobNumber,
			@NotNull String email, LocalDate date) {
		super();
		this.name = name;
		this.age = age;
		this.mobNumber = mobNumber;
		this.email = email;
		this.dob = date;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Size(min=10,max=10,message="Please provide a valid 10digit mobile number")
	@Column(name="mobnumber")
	private String mobNumber;
	
	@NotNull
	@Email
	@Column
	private String  email;
	
	
	
	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	@NotNull
	@Column(name="dob")
	private LocalDate dob;
	
	public Friend() {
		
	}

	public Friend(@NotNull @Size(min = 3, message = "Name should be greater than 3 chars") String name, String mobNumber,
			@NotNull String email, LocalDate dob) {
		super();
		this.name = name;
		this.mobNumber = mobNumber;
		this.email = email;
		this.dob = dob;
	}

	public Friend(String name, String mobNumber, String email) {
		super();
		this.name = name;
		this.mobNumber = mobNumber;
		this.email = email;
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

	public String getMobNumber() {
		return mobNumber;
	}

	public void setMobNumber(String mobNumber) {
		this.mobNumber = mobNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	

}
