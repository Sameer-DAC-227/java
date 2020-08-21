package com.app.sales;

public class ShippingAddress {
	
	private String email;
	private String city;
	private String state;
	private String country;
	private String zipCode;
	private String[] phoneNumbers;
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String[] getPhoneNumbers() {
		return phoneNumbers;
	}

	public void setPhoneNumbers(String[] phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}

	public ShippingAddress(String mEmail, String mCity, String mState, String mCountry, String mZipCode,
			String[] mPhoneNumbers) {
		this.email = mEmail;
		this.city = mCity;
		this.state = mState;
		this.country = mCountry;
		this.zipCode = mZipCode;
		this.phoneNumbers = mPhoneNumbers;
	}
	
	public String toString() {
		return ("Adddress-" + city + "," + state + "," + country);
	}

}
