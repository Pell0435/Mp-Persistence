package database;

import model.SalesOrder;

public interface ISalesOrderDB {
	SalesOrder FindSalesOrderByOrderNo(int orderNo);
}
