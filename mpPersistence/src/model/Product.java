package model;
// Author: Thomas og Pelle (Getters og setters)
public class Product {
	//All of the private things
	private String barcode;
	private String name;
	private String manufacturerName;
	private String productID;
	private int minStock;
	private double purchasePrice;
	private double salesPrice;
	private double rentPrice;
	private String countryOfOrigin;
	 
	
// A lot of getter's	
public String getName() {
	 return name;
	 }
 
 public String getManufacturerName() {
	 return manufacturerName;
 }
 
 public double getSalesPrice() {
	 return salesPrice;	
 }

 public double getRentPrice() {
	 return rentPrice;	
 }
 
 public String getProductID() {
	 return productID;
 }
 
 public String getCountryOfOrigin() {
	 return countryOfOrigin;
 }

 public String getBarcode() {
	 return barcode;
 }
 
 
 public int getMinStock() {
	 return minStock;
 }
 public double getPurchasePrice() {
	 return purchasePrice;
 }
 
//Setters incoming
 
 public void setSalesPrice (double newSalesPrice) {
	 this.salesPrice = newSalesPrice;
 }
 
 public void setRentPrice (double newRentPrice) {
	 this.rentPrice = newRentPrice;
 }
 
 public void SetName (String newName) {
	 this.name = newName;
 }

 public void setManufacturerName(String newManufacturerName) {
	 this.manufacturerName = newManufacturerName;
 }
 
 public void setProductID(String newProductID) {
	 this.productID = newProductID;
 }
 
 
 public void setCountryOfOrigin(String newCountryOfOrigin) {
	 this.countryOfOrigin = newCountryOfOrigin;
 }
 
 public void setBarcode (String newBarcode) {
	 this.barcode = newBarcode;
 }
 
 
 public void setMinStock (int newMinStock) {
	 this.minStock = newMinStock;
 }
 
}
