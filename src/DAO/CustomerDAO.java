package DAO;

import Main.JDBC;
import Model.Appointments;
import Model.Country;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import Model.Customers;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

/** This is the DAO file in which SQL queries regarding Customers are made to the MySQL Workbench database. */
public class CustomerDAO {

    /** This method will make a SQL query to return all Customers and return it to the Customer object.
     * @return customersObservableList All Customers
     * */
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

    /** This method will add a Customer to the Customer table in the database.
     * @param customerName
     * @param customerAddress
     * @param customerPostalCode
     * @param customerPhone
     * @param createdDate
     * @param lastUpdated
     * @param divisionId
     * */
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

    /** This method deletes a Customer record from the Customer table in the database.
     * @param customerId Customer ID
     * */
    public static void deleteCustomer(int customerId) {
        try {
            String sql = "DELETE FROM customers WHERE Customer_ID = ?";
            PreparedStatement deleteCustomer = JDBC.conn.prepareStatement(sql);
            deleteCustomer.setInt(1, customerId);
            deleteCustomer.execute();
        } catch (SQLException e) {e.printStackTrace();}
    }

    /** This method will return a Customer ID given a Customer Name
     * @param customerName Customer Name
     *
     * @return customerId Customer ID
     * */
    public static int getCustomerId(String customerName) throws SQLException {
        String sql = "SELECT * FROM customers WHERE Customer_Name = ?";
        PreparedStatement ps = JDBC.getConnection().prepareStatement(sql);
        ps.setString(1, customerName);
        ResultSet rs = ps.executeQuery();

        int customerId = 0;
        while (rs.next()) {
            customerId = rs.getInt("Customer_ID");
        }
        return customerId;
    }

    /** This method is used when needing to make updates to Customer records in the database.
     * @param customerId
     * @param customerName
     * @param customerAddress
     * @param customerPostalCode
     * @param customerPhone
     * @param createdDate
     * @param lastUpdated
     * @param divisionId
     * */
    public static void updateCustomer(int customerId, String customerName, String customerAddress, String customerPostalCode, String customerPhone, LocalDateTime createdDate, LocalDateTime lastUpdated, int divisionId) {
        try {

            String sql = "UPDATE customers SET Customer_Name = ?, Address = ?, Postal_Code = ?, Phone = ?, Create_Date = ?, Last_Update = ?, Division_ID = ? WHERE Customer_ID = ?";
            PreparedStatement updateAppointment = JDBC.conn.prepareStatement(sql);

            updateAppointment.setString(1, customerName);
            updateAppointment.setString(2, customerAddress);
            updateAppointment.setString(3, customerPostalCode);
            updateAppointment.setString(4, customerPhone);
            updateAppointment.setTimestamp(5, Timestamp.valueOf(createdDate));
            updateAppointment.setTimestamp(6, Timestamp.valueOf(lastUpdated));
            updateAppointment.setInt(7, divisionId);
            updateAppointment.setInt(8, customerId);

            updateAppointment.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
