package database;
/**
 * @author (Mikal)
 */
import model.Product;


public interface IProductDB {

    void addProduct(Product product);

    void removeProduct(Product product);

    Product findProductByProductID(String productID);
}
