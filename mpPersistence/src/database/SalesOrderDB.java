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

    public SalesOrder FindSalesOrderByOrderNo(int orderNo) {
        String sql = "SELECT * FROM SalesOrder WHERE OrderNo = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, orderNo);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                // Mapping database columns to the SalesOrder constructor
                int orderNoFromDb = rs.getInt("OrderNo");
                Date deliveryDateDb = rs.getDate("DeliveryDate");  // Assuming the date is in this column
                boolean deliveryStatus = rs.getBoolean("DeliveryStatus");  // Assuming a boolean column
                double totalPrice = rs.getDouble("TotalPrice");  // Assuming a numeric column
                String deliveryNote = rs.getString("DeliveryNote");
                Date dateDb = rs.getDate("Date");  // Assuming this is another date column

                // Converting SQL Date to LocalDate
                LocalDate deliveryDate = deliveryDateDb != null ? deliveryDateDb.toLocalDate() : null;
                LocalDate date = dateDb != null ? dateDb.toLocalDate() : null;

                return new SalesOrder(orderNoFromDb, deliveryDate, deliveryStatus, totalPrice, deliveryNote, date);
            }
        } catch (SQLException e) {
            System.err.println("Error retrieving sales order: " + e.getMessage());
        }
        return null;
    }

    public static void main(String[] args) {
        SalesOrderDB salesOrderDB = new SalesOrderDB();
        SalesOrder order = salesOrderDB.FindSalesOrderByOrderNo(2);  // Example order number

        if (order != null) {
            System.out.println("SalesOrder Found: " + order.getOrderNo());
        } else {
            System.out.println("SalesOrder not found.");
        }
    }
}
