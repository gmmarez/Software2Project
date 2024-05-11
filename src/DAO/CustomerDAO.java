package DAO;

import Main.JDBC;
import Model.Country;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import Model.Customers;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerDAO {
    ObservableList<Customers> getAllCustomers() throws SQLException {
        ObservableList<Customers> customersObservableList = FXCollections.observableArrayList();
        String sql = "SELECT * from customers";
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

        }

        return customersObservableList;
    }

}
