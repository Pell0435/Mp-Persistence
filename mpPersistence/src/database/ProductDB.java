package database;
import java.util.ArrayList;
import java.util.List;

import model.Product;
// Author er Thomas
public class ProductDB {

	private static ProductDB instance;
	private ArrayList<Product> products;
	
	//Instance
	public static ProductDB getIntance() {
		if(instance == null) {
			instance = new ProductDB();
		}
		return instance;
	} // 
	private ProductDB(){
		products = new ArrayList<>();
	}
	// AddProduct
	public void addProduct (Product p) throws IllegalArgumentException {
		if(findByProductID(p.getProductID()) == null) {
			Product res = null;
			for (int i = 0 ; i <products.size() && res == null; i++) {
				if(products.get(i).getProductID().equalsIgnoreCase(CustomerID)) {
					res = Product.get(i);
				}
		}
		return res;
	}

	public List<Product> findAll() {
		return new ArrayList<>(this.products);
	}
	
}
