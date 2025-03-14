package controller;
import java.time.LocalDate;
import database.SalesOrderDB;
import model.SalesOrder;

public class SalesOrderController {
	SalesOrderDB salesOrderDB;
	
	public SalesOrderController() {
		this.salesOrderDB = new SalesOrderDB();
	}
	public SalesOrder makeSalesOrder(int orderNo, LocalDate deliveryDate, boolean deliveryStatus, double totalPrice, String deliveryNote, LocalDate date) {
		SalesOrder s = new SalesOrder(orderNo, deliveryDate, deliveryStatus, totalPrice, deliveryNote, date);
		salesOrderDB.makeSalesOrder(s);
		return s;
	
	}
	public SalesOrder findSalesOrderByOrderNo(int orderNo) {
		return salesOrderDB.FindSalesOrderByOrderNo(orderNo);
	}
}
