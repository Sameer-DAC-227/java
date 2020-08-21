package com.app.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.app.exception.InvalidInputException;
import com.app.sales.Customer;
import com.app.sales.CustomerType;
import static com.app.sales.CustomerType.*;

public class ValidationUtils {

	private static final SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	public static String validateEmail(String email) throws InvalidInputException {
		if(email.contains("@") && email.endsWith(".com"))
			return email;
		else
			throw new InvalidInputException("Invalid Email Address");
	}
	
	public static String validatePassword(String password) throws InvalidInputException{
		if(password.length()<8)
			throw new InvalidInputException("Password should be of at least of 8 characters");
		return password;
	}
	
	public static Date validateDate(String date) throws InvalidInputException {
		Date dateObj;
		Date validDate;
		
		try {
			dateObj = formatter.parse(date);
			validDate = formatter.parse("01/01/1990");
			
		} catch (ParseException e) {
			throw new InvalidInputException("Invalid Date Format. Date should be in dd/MM/yyyy format");
		}
		if(!(dateObj.after(validDate))) {
			throw new InvalidInputException("Date of birth must be after 01/01/1990");
		}
		return dateObj;
	}

	public static double validateAmount(double amt) throws InvalidInputException {
		if((amt%500)==0) {
			return amt;
		}else {
			throw new InvalidInputException("Amount must be in multiple of 500");
		}
	}
	
	public static CustomerType validateCustomerType(String custType) throws InvalidInputException{
		try {
			CustomerType customerType = valueOf(custType);
			return customerType;
		} catch (IllegalArgumentException e) {
			throw new InvalidInputException("Invalid Customer Type");
		}
	}
	
	public static Customer authenticateCustomer(String email, String password, 
			Customer[] sales) throws InvalidInputException{
		for (Customer customer : sales) {
			if(customer!=null) {
				if((customer.getEmail()).equalsIgnoreCase(email)) {
					if((customer.getPassword()).equals(password)) 
						return customer;
					else
						throw new InvalidInputException("Invalid Email Address/ Password");
				}
			}
		}
		throw new InvalidInputException("Invalid User Exception");
	}
	
	public static Customer validateCustomer(String email, Customer[] sales) throws InvalidInputException{
		for (Customer customer : sales) {
			if(customer!=null) {
				if((customer.getEmail()).equalsIgnoreCase(email)) {
						return customer;
				}
			}
		}
		throw new InvalidInputException("Invalid User Exception");
	}
	public static Customer updateCustomerDetails(Customer customer, Customer[] sales) throws InvalidInputException{
		int count =sales.length;
		String email = customer.getEmail();
		for (int i=0; i<count; i++) {
			Customer cust = sales[i];
			if(customer!=null) {
				if((cust.getEmail()).equalsIgnoreCase(email)) {
					sales[i] = customer;
					return cust;
				}
			}
		}
		throw new InvalidInputException("Customer not found");
	}

}
