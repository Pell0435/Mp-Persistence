package model;
//Author er Thomas og Pelle

public class Customer {
	// Privates og pullers
	private String name;
	private String address;
	private String phoneNo;
	private String email;
	private String zipcode;
	private String city;
	private String customerCategory;
	private int customerID;
	
	
	public Customer(String name,String address,String phoneNo, String email,String zipcode,String city, String customerCategory,int customerID) {
	this.name = name;
	this.address = address;
	this.phoneNo = phoneNo;
	this.email = email;
	this.zipcode = zipcode;
	this.city = city;
	this.customerCategory = customerCategory;
	this.customerID = customerID;
	
	
	}
	
//Getter's incoming!
public String getName() {
	return name;
}

public String getAddress() {
	return address;
}

public String getPhoneNo() {
	return phoneNo;
}

public String getEmail() {
	return email;
}
public String getZipcode() {
	return zipcode;
}

public String getCity() {
	return city; 
}
public String getCustomerCategory() {
	return customerCategory;
}

public int getCustomerID(){
	return customerID;
}
// Her kommer setter's

public void setName(String newName) {
	this.name = newName;
}

public void setAddress(String newAddress) {
	this.address = newAddress;
}

public void setPhoneNo(String newPhoneNo) {
	this.phoneNo = newPhoneNo;
}

public void setEmail (String newEmail) {
	this.email = newEmail;
}

public void setZipcode(String newZipcode) {
	this.zipcode = newZipcode;
}

public void setCity(String newCity) {
	this.city = newCity;
}

public void setCustomerCategory(String newCustomerCategory) {
	this.customerCategory = newCustomerCategory;
}

public void setCustomerID(int newCustomerID) {
	this.customerID = newCustomerID;
}
}
