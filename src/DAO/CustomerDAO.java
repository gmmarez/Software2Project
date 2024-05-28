package DAO;

import Main.JDBC;
import Model.Country;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import Model.Customers;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class CustomerDAO {
    public static ObservableList<Customers> getAllCustomers() throws SQLException {
        ObservableList<Customers> customersObservableList = FXCollections.observableArrayList();
        try {
            String sql = "SELECT Customer_ID, Customer_Name, Address, Postal_Code, Phone, Division_ID from customers ";
            PreparedStatement ps = JDBC.getConnection().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int customerId = rs.getInt("Customer_ID");
                String customerName = rs.getString("Customer_Name");
                String customerAddress = rs.getString("Address");
                String customerPostalCode = rs.getString("Postal_Code");
                String customerPhone = rs.getString("Phone");
                int divisionId = rs.getInt("Division_ID");

                Customers customers = new Customers(customerId, customerName, customerAddress, customerPostalCode, customerPhone, divisionId);
                customersObservableList.add(customers);
            }
        } catch (SQLException exception) {
        throw new RuntimeException(exception);
    }
        return customersObservableList;
    }

    public static void addCustomer(String customerName, String customerAddress, String customerPostalCode,
                                   String customerPhone, LocalDateTime createdDate, LocalDateTime lastUpdated,
                                   int divisionId) throws SQLException {
        String sql = "INSERT INTO customers (Customer_Name, Address, Postal_Code, Phone, Create_Date, Last_Update, Division_ID) VALUES (?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement insertCustomer = JDBC.conn.prepareStatement(sql);
        insertCustomer.setString(1, customerName);
        insertCustomer.setString(2, customerAddress);
        insertCustomer.setString(3, customerPostalCode);
        insertCustomer.setString(4, customerPhone);
        insertCustomer.setTimestamp(5, Timestamp.valueOf(createdDate));
        insertCustomer.setTimestamp(6, Timestamp.valueOf(lastUpdated));
        insertCustomer.setInt(7, divisionId);
        insertCustomer.executeUpdate();
    }

}
