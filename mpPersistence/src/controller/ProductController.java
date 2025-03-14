package controller;
import database.ProductDB;
import model.Customer;
import model.Product;
//Author Thomas
public class ProductController {
	private ProductDB productDB;
	
	public ProductController(){
		this.productDB = new ProductDB();
	}
	//Adds a new product in the system
	public Product addProduct(String barcode, String name, String manufacturerName, String productID,
			int minStock, double purchasePrice, double salesPrice, double rentPrice, String countryOfOrigin, String productType, String supplierID)
	{
		Product p = new Product(barcode, name, manufacturerName, productID, minStock, purchasePrice, salesPrice, rentPrice, countryOfOrigin, productType, supplierID);
		productDB.addProduct(p);
		return p;
		
	}
	//Finding Products by its ID
	public Product findProductbyProductID(String Product) {
		return productDB.findProductByProductID(Product);
	}
	//RemoveProduct
	public void removeProduct(Product product) {
		productDB.removeProduct(product);
		
	}
}