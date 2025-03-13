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
	private int customerId;

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

public int getCustomerId(){
	return customerId;
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

public void setCustomerId(int newCustomerId) {
	this.customerId = newCustomerId;
}
}
