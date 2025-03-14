package database;
//Author Thomas
//Importing af vigtige ting
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.time.LocalDate;

import model.Employee;
import model.SalesOrder;

public class SalesOrderDB implements ISalesOrderDB {
    private Connection connection;

    public SalesOrderDB() {
        this.connection = ConnectDB.getInstance().getConnection();
    }

    public SalesOrder FindSalesOrderByOrderNo(int orderNo) {
        String sql = "SELECT * FROM SalesOrder WHERE OrderNo = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, orderNo);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Date salesDate = rs.getDate("salesDate");
                String deliveryNote = rs.getString("deliveryNote");
                boolean deliveryStatus = rs.getBoolean("deliveryStatus");
                int orderNoFromDb = rs.getInt("orderNo");
                Date deliveryDateDb = rs.getDate("deliveryDate");
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

    public boolean makeSalesOrder(SalesOrder order) {
        String sql = "INSERT INTO SalesOrder (OrderNo, SalesDate, DeliveryDate, DeliveryStatus, TotalPrice, DeliveryNote) " +
                     "VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, order.getOrderNo());
            stmt.setDate(2, Date.valueOf(order.getDate())); 
            stmt.setDate(3, order.getDeliveryDate() != null ? Date.valueOf(order.getDeliveryDate()) : null);
            stmt.setBoolean(4, order.getDeliveryStatus());
            stmt.setDouble(5, order.getTotalPrice());
            stmt.setString(6, order.getDeliveryNote());

            int rowsInserted = stmt.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            System.err.println("Error creating sales order: " + e.getMessage());
        }
        return false;
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

