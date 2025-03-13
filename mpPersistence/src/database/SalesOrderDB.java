package database;
//Author Thomas
//Importing af vigtige ting
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.time.LocalDate;

import model.SalesOrder;

public class SalesOrderDB implements ISalesOrderDB {
    private Connection connection;

    public SalesOrderDB() {
        this.connection = ConnectDB.getInstance().getConnection();
    }
// Dette var et absolute nightmare!
    public SalesOrder FindSalesOrderByOrderNo(int orderNo) {
        String sql = "SELECT * FROM SalesOrder WHERE OrderNo = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, orderNo);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Date salesDate = rs.getDate("salesDate");
                String deliveryNote = rs.getString("deliveryNote");
                boolean deliveryStatus = rs.getBoolean("deliveryStatus");
                int orderNoFromDb = rs.getInt("OrderNo");
                Date deliveryDateDb = rs.getDate("DeliveryDate");
                double totalPrice = rs.getDouble("totalPrice"); 
                LocalDate salesLocalDate = salesDate.toLocalDate();
                LocalDate deliveryLocalDate = deliveryDateDb != null ? deliveryDateDb.toLocalDate() : null;

                return new SalesOrder(orderNoFromDb, deliveryLocalDate, deliveryStatus, totalPrice, deliveryNote, salesLocalDate);
            }
            
        } catch (SQLException e) {
            System.err.println("Error retrieving sales order: " + e.getMessage());
        }
        return null;
    }


    public static void main(String[] args) {
        SalesOrderDB salesOrderDB = new SalesOrderDB();
        SalesOrder order = salesOrderDB.FindSalesOrderByOrderNo(2);  // Example number

        if (order != null) {
            System.out.println("SalesOrder Found: " + order.getOrderNo());
        } else {
            System.out.println("SalesOrder not found.");
        }
    }
    
}

