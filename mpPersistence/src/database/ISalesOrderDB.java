package database;
/*
 * @author Nicklas
 */
import model.SalesOrder;

public interface ISalesOrderDB {
	//Added methods from SalesOrderDB
	
	SalesOrder FindSalesOrderByOrderNo(int orderNo);
	
	boolean makeSalesOrder(SalesOrder order);
}
