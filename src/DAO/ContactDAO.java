package DAO;

import Main.JDBC;
import Model.Appointments;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import Model.Contacts;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.*;

/** This is the DAO file in which SQL queries regarding Contacts are made to the MySQL Workbench database. */
public class ContactDAO {

    /** This method return all Contacts from the database using a SQL query.
     * @return contactsObservableList All Contacts
     * */
    public static ObservableList<Contacts> getAllContacts() throws SQLException {
        ObservableList<Contacts> contactsObservableList = FXCollections.observableArrayList();
        String sql = "SELECT * from contacts";
        PreparedStatement ps = JDBC.getConnection().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            int contactId = rs.getInt("Contact_ID");
            String contactName = rs.getString("Contact_Name");
            String contactEmail = rs.getString("Email");

            Contacts contacts = new Contacts(contactId, contactName, contactEmail);
            contactsObservableList.add(contacts);
        }

        return contactsObservableList;
    }

    /** This method will return a Contact's ID when given a Contact Name.
     * @param contactName Contact Name
     * @return contactId Contact ID
     * */
    public static int getContactId(String contactName) throws SQLException {
        String sql = "SELECT * FROM contacts WHERE Contact_Name = ?";
        PreparedStatement ps = JDBC.getConnection().prepareStatement(sql);
        ps.setString(1, contactName);
        ResultSet rs = ps.executeQuery();

        int contactId = 0;
        while (rs.next()) {
            contactId = rs.getInt("Contact_ID");
        }
        return contactId;
    }

}
