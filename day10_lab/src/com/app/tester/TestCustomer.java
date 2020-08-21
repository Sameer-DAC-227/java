package com.app.tester;

import java.util.Date;
import java.util.Scanner;

import com.app.exception.InvalidInputException;
import com.app.sales.Customer;
import com.app.sales.CustomerType;
import com.app.sales.ShippingAddress;

import static com.app.utils.ValidationUtils.*;


public class TestCustomer {

	public static void main(String[] args) {
		try(Scanner scan = new Scanner(System.in);) {
			Customer[] sales = null;
			int count = 0;
			int choice = 0;
			do {
				System.out.println("Enter 1 to Input customers");
				System.out.println("Enter 2 to Display all customers");
				System.out.println("Enter 3 to Login");
				System.out.println("Enter 4 to Change Password");
				System.out.println("Enter 5 to Assign Shipping Address");
				System.out.println("Enter 6 to Place Order");
				System.out.println("Enter 7 to Quit");
				choice = scan.nextInt();
				switch (choice) {
				case 1:
					System.out.println("Enter the number of customers to be input:");
					count = scan.nextInt();
					sales = new Customer[count];
					for(int i=0; i<count; i++) {
						System.out.println("\n\n\nEnter name:");
						String name = scan.next();
						boolean error = false;
						String email;
						do {
							System.out.println("Enter email:");
							email = scan.next();
							try {
								email = validateEmail(email);
								error = false;
							} catch (InvalidInputException ie) {
								System.out.println(ie.getMessage());
								error = true;
							}
						}while(error);
						
						String password;
						do {
							System.out.println("Enter password");
							password = scan.next();
							try {
								password = validatePassword(password);
								error = false;
							} catch (InvalidInputException ie) {
								System.out.println(ie.getMessage());
								error = true;
							}
						}while(error);
						Date dateOfBirth=null;
						do {
							System.out.println("Enter date of birth in dd/MM/yyyy format(eg:27/02/2001):");
							String dob = scan.next();
							try {
								dateOfBirth = validateDate(dob);
								error = false;
							} catch (InvalidInputException ie) {
								System.out.println(ie.getMessage());
								error = true;
							}
						}while(error);

						
						String type;
						CustomerType custType = null;
						do {
							System.out.println("Enter customer type: (GOLD/SILVER/PLATINUM)");
							type = scan.next();

							try {
								custType = validateCustomerType(type);
								error = false;
							} catch (InvalidInputException ie) {
								System.out.println(ie.getMessage());
								error = true;
							}
						}while(error);
						

						double amt;
						do {
							System.out.println("Enter reg amount:");
							amt = scan.nextDouble();
							try {
								amt = validateAmount(amt);
								error = false;
							} catch (InvalidInputException ie) {
								System.out.println(ie.getMessage());
								error = true;
							}
						}while(error);
						
						Customer customer = new Customer(name,email,password,dateOfBirth,custType,amt);
						sales[i]=customer;
					}
					
					break;

				case 2:
					if(sales == null) {
						System.out.println("There are no customers to display");
						break;
					}
					for (Customer customer : sales) {
						System.out.println(customer);
					}					
					break;

				case 3:
					if(sales == null) {
						System.out.println("There are no customers in the system");
						break;
					}
					System.out.println("Enter the email id:");
					String email = scan.next();
					System.out.println("Enter the password");
					String password = scan.next();
					try {
						Customer customer = authenticateCustomer(email, password, sales);
						System.out.println("Customer-" + customer.getEmail() + " logged in successfully");
					}catch(InvalidInputException ie) {
						System.out.println(ie.getMessage());
					}
					break;

				case 4:
					if(sales == null) {
						System.out.println("There are no customers in the system");
						break;
					}
					System.out.println("Enter the email id for which password needs to be changed:");
					email = scan.next();
					System.out.println("Enter the password to login to change the password:");
					password = scan.next();
					Customer customer;
					try {
						customer = authenticateCustomer(email, password, sales);
					} catch (InvalidInputException ie) {
						System.out.println(ie.getMessage());
						break;
					}
					System.out.println("Enter the new password");
					password = scan.next();
					customer.setPassword(password);
					try {
						updateCustomerDetails(customer, sales);
						System.out.println("Password changed successfully");
					}catch(InvalidInputException ie) {
						System.out.println(ie.getMessage());
					}
					break;

				case 5:
					if(sales == null) {
						System.out.println("There are no customers in the system");
						break;
					}
					System.out.println("Enter the email id:");
					email = scan.next();
					System.out.println("Enter the password");
					password = scan.next();
					try {
						customer = authenticateCustomer(email, password, sales);
						System.out.println("Customer-" + customer.getEmail() + " logged in successfully");
						System.out.println("Enter the city");
						String city = scan.next();
						System.out.println("Enter the state");
						String state = scan.next();
						System.out.println("Enter the country");
						String country = scan.next();
						System.out.println("Enter the zip code");
						String zipCode = scan.next();
						System.out.println("Enter the landline number");
						String landLine = scan.next();
						System.out.println("Enter the mobile number");
						String mobile = scan.next();
						String[] phone = {landLine,mobile};
						ShippingAddress address = new ShippingAddress(email, city, state, country, zipCode, phone);
						customer.setAddress(address);
						customer = updateCustomerDetails(customer, sales);
						System.out.println("Address updated successfully");
						
					}catch(InvalidInputException ie) {
						System.out.println(ie.getMessage());
					}
					break;

				case 6:
					if(sales == null) {
						System.out.println("There are no customers in the system");
						break;
					}
					System.out.println("Enter the email id:");
					email = scan.next();
					try {
						customer = validateCustomer(email, sales);
						if(customer.getAddress()==null) {
							System.out.println("The shipping address has not been set. Please update it first.");
							break;
						}
						System.out.println("Your order has been placed successfully");
						System.out.println("The order will be delivered in 3 days at below address");
						System.out.println(customer.getAddress());
							
					}catch(InvalidInputException ie) {
						System.out.println(ie.getMessage());
					}
					break;

				case 7:
					System.out.println("Thank you for using Customer Application");
					break;

				default:
					System.out.println("Enter a valid choice");
					break;
				}
			}while(choice!=7);
			

		} 
	}

}
