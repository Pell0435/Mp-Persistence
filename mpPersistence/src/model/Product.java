package model;
// Author: Thomas (Getters og setters)
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
	private Supplier Supplier
	 
	
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
 
 public String getCategory() {
	 return category;
 }
 
 public int getMinStock() {
	 return minStock;
 }
 public String getPurchasePrice() {
	 return purchasePrice;
 }
 
//Setters incoming
 
 public void setSalesPrice (double newSalesPrice) {
	 this.salesPrice = newSalesPrice;
 }
 
 public void setRentPrice (double newRentPrice) {
	 this.rentprice = newRentprice;
 }
 
 public void SetName (String newName) {
	 this.name = newName;
 }

 public void setManufacturerName(String newManufacturerName) {
	 this.manufacturerName = newManufacturerName;
 }
 
 public void setProductID(int newProduct) {
	 this.productID = newProduct;
 }
 
 public void setModel (String newModel) {
	 this.setModel = newModel;
 }
 
 public void setCountryOfOrigin(String newCountryOfOrigin) {
	 this.countryOfOrigin = newCountryOfOrigin;
 }
 
 public void setBarcode (String newBarcode) {
	 this.barcode = newBarcode;
 }
 
 public void setCategory (String newCategory) {
	 this.category = newCategory;
 }
 
 public void setMinStock (int newMinStock) {
	 this.minStock = newMinStock;
 }
 
}
