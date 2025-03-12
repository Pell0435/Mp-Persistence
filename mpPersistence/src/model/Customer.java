package model;
//Author er Thomas

public class Customer {
	// Privates og pullers
	private String name;
	private String address;
	private String phoneNo;
	private String email;
	private String zipcode;
	private String city;

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
}
