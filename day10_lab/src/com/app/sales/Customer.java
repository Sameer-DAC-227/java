package com.app.sales;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Customer {

	private String name;
	private String email;
	private String password;
	private Date dateofBirth;
	private ShippingAddress address;
	private CustomerType custType;
	private double regAmount;
	
	
	private static final SimpleDateFormat format = new SimpleDateFormat("dd/MM/YYYY");;
	
	public Customer(String mName, String mEmail, String mPassword, Date mDateofBirth, 
			CustomerType mCustType, double mRegAmount) {
		this.name = mName;
		this.email = mEmail;
		this.password = mPassword;
		this.dateofBirth = mDateofBirth;
		this.custType = mCustType;
		this.regAmount = mRegAmount;
	}
	
	public String toString() {
		
		return ("Name-" + this.name + " Email-" + this.email + " Password-" + this.password
				+ " Date of Birth-" + format.format(this.dateofBirth) + " Customer Type-" + this.custType
				+ " Reg Amount-" + this.regAmount);
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public void setPassword(String pass) {
		this.password=pass;
	}

	public ShippingAddress getAddress() {
		return address;
	}

	public void setAddress(ShippingAddress address) {
		this.address = address;
	}
	
	
	
	
}
