package database;
/**
 * @author (Mikal)
 */
import model.Product;


public interface IProductDB {
	//Added methods from ProductDB

    void addProduct(Product product);

    void removeProduct(Product product);

    Product findProductByProductID(String productID);
}
