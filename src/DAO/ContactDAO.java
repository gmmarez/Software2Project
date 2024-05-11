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

public class ContactDAO {
    ObservableList<Contacts> getAllContacts() throws SQLException {
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

}
