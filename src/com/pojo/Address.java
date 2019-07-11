package com.pojo;

public class Address {

	private String area;
	private String city;
	private int pin;

	public Address(String area, String city, int pin) {
		super();
		this.area = area;
		this.city = city;
		this.pin = pin;
	}
	
	public String toString(){  
	    return area+" "+city+" "+pin;  
	}  

}
