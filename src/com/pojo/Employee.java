package com.pojo;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@javax.persistence.Entity
@Table(name = "employee")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "empName")
	private String userName;
	@Transient
	Address address;

	public Employee() {
		System.out.println("def cons");
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
//
	public Employee(int id, String name) {
		this.id = id;
		this.userName = name;
//		this.address = a;
	}
	
	public Employee(int id, String name, Address address) {  
	    super();  
	    this.id = id;  
	    this.userName = name;  
	    this.address = address;  
	}  

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void printData() {
		System.out.println("User Name is " + userName);
	}

	public void showData() {
		System.out.println(id + " " + userName );
	}
	
	public void show(){  
	    System.out.println(id+" "+userName);  
	    System.out.println(address);  
	}  
}
