package Test;
/*
 * @author (Mikal)
 */
import model.Product;
import org.junit.jupiter.api.*;

import database.ProductDB;

import java.sql.*;

import static org.junit.jupiter.api.Assertions.*;

public class TESTProduct {

    private ProductDB productDB;
    private Connection connection;

    @BeforeEach
    void setUp() {
        productDB = ProductDB.getInstance();
        connection = productDB.getConnection();
        assertNotNull(connection, "Database connection should not be null");
    }

    @AfterEach
    void tearDown() {
        try {
            if (connection != null && !connection.isClosed()) {
                deleteTestProduct("TP01");
                deleteTestProduct("TP02");
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void deleteTestProduct(String productID) throws SQLException {
        try (PreparedStatement stmt = connection.prepareStatement("DELETE FROM Products WHERE productID = ?")) {
            stmt.setString(1, productID);
            stmt.executeUpdate();
        }
    }

    @Test // tester om et produkt kan tilfæjes i databasen
    void testAddProduct() {
        Product product = new Product(
                "1234567890",
                "Test Product",
                "Test Manufacturer",
                "TP01",
                5,
                10.00,
                20.00,
                5.00,
                "Test Country",
                "Test Type",
                "02" 
        );

        productDB.addProduct(product);

        // bekræfter at produkter er tilføjet ved hjælp af den givne query
        String query = "SELECT productName, purchasePrice, salesPrice, rentPrice, countryOfOrigin, minStock, productID, productType, barcode, ssid FROM Products WHERE productID = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, "TP01"); 
            ResultSet rs = stmt.executeQuery();

            assertTrue(rs.next(), "Product should be found in the database");

            assertEquals("Test Product", rs.getString("productName"), "Product name should match");
            assertEquals(10.00, rs.getDouble("purchasePrice"), "Purchase price should match");
            assertEquals("1234567890", rs.getString("barcode"), "Barcode should match");
            assertEquals(5, rs.getInt("minStock"), "MinStock should match");
            assertEquals(20.00, rs.getDouble("salesPrice"), "SalesPrice should match");
            assertEquals(5.00, rs.getDouble("rentPrice"), "RentPrice should match");
            assertEquals("Test Country", rs.getString("countryOfOrigin"), "CountryOfOrigin should match");
            assertEquals("Test Type", rs.getString("productType"), "ProductType should match");
            assertEquals("02", rs.getString("ssid"), "SupplierID should match");

        } catch (SQLException e) {
            e.printStackTrace();
            fail("Exception during database verification: " + e.getMessage());
        }
    }

    @Test // fjerner et produkt
    void testRemoveProduct() {
        Product productToRemove = new Product(
                "555566667777",
                "Remove Product",
                "Remove Manufacturer",
                "TP02",
                7,
                15.00,
                25.00,
                7.00,
                "Remove Country",
                "Remove Type",
                "RS001"
        );
        productDB.addProduct(productToRemove);

        productDB.removeProduct(productToRemove);

        Product retrievedProduct = productDB.findProductByProductID("RP001");
        assertNull(retrievedProduct, "Product should be removed");
    }

    @Test // finder et produkt som allerede ligger i databasen
    void testFindProductByProductID() {
        Product productToFind = new Product(
                "444455556666", // barcode
                "Work Gloves",    // name
                "Some Manufacturer", // manufacturerName (add this)
                "WG01",          // productID
                10,               // minStock
                15.00,            // purchasePrice
                30.00,            // salesPrice
                10.00,            // rentPrice
                "Denmark",        // countryOfOrigin
                "Equipment",      // productType
                "02"             // supplierID
        );
        productDB.addProduct(productToFind);

        // Act: Find produktet med det givne query
        String query = "SELECT productName, purchasePrice, salesPrice, rentPrice, countryOfOrigin, minStock, productID, productType, barcode, ssid FROM Products WHERE productID = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, "WG002"); 
            ResultSet rs = stmt.executeQuery();

            // Assert: Bekræfte at produktet og dens attributer passer
            assertTrue(rs.next(), "Product with productID 'WG002' should be found");

            assertEquals("444455556666", rs.getString("barcode"), "Barcode should match");
            assertEquals("Work Gloves", rs.getString("productName"), "Product name should match");
            assertEquals(10, rs.getInt("minStock"), "MinStock should match");
            assertEquals(15.00, rs.getDouble("purchasePrice"), "Purchase price should match");
            assertEquals(30.00, rs.getDouble("salesPrice"), "SalesPrice should match");
            assertEquals(10.00, rs.getDouble("rentPrice"), "RentPrice should match");
            assertEquals("Denmark", rs.getString("countryOfOrigin"), "CountryOfOrigin should match");
            assertEquals("Equipment", rs.getString("productType"), "Product type should match");
            assertEquals("02", rs.getString("ssid"), "Supplier ID should match");

        } catch (SQLException e) {
            e.printStackTrace();
            fail("Exception during database verification: " + e.getMessage());
        }
    }
    
    @Test //prøver at finde et ikke eksisterne produkt i databasen.
    void testFindProductByProductID_NotFound() {
        String query = "SELECT productName, purchasePrice, salesPrice, rentPrice, countryOfOrigin, minStock, productID, productType, barcode, ssid FROM Products WHERE productID = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, "IkkeEksisterndeID"); 
            ResultSet rs = stmt.executeQuery();

            
            assertFalse(rs.next(), "Productet med productID 'IkkeEksisterndeID' skal ikke blive fundet");

        } catch (SQLException e) {
            e.printStackTrace();
            fail("Exception during database verification: " + e.getMessage());
        }
    }
    
}