package DAO;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import Model.Appointments;
import Main.JDBC;
import javafx.scene.control.Cell;

import java.sql.*;
import java.time.LocalDateTime;

public class AppointmentDAO {
    public static ObservableList<Appointments> getAllAppointments() throws SQLException {
        ObservableList<Appointments> appointmentsObservableList = FXCollections.observableArrayList();
        try {
            String sql = "SELECT Appointment_ID, Title, Description, Location, Type, Start, End, Customer_ID, User_ID, Contact_ID from appointments";
            PreparedStatement ps = JDBC.getConnection().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int appointmentId = rs.getInt("Appointment_ID");
                String appointmentTitle = rs.getString("Title");
                String appointmentDescription = rs.getString("Description");
                String appointmentLocation = rs.getString("Location");
                String appointmentType = rs.getString("Type");
                LocalDateTime appointmentStartTime = rs.getTimestamp("Start").toLocalDateTime();
                LocalDateTime appointmentEndTime = rs.getTimestamp("End").toLocalDateTime();
                int contactId = rs.getInt("Contact_ID");
                int customerId = rs.getInt("Customer_ID");
                int userId = rs.getInt("User_ID");

                Appointments appointment = new Appointments(appointmentId, appointmentTitle, appointmentDescription, appointmentLocation,
                        appointmentType, appointmentStartTime, appointmentEndTime, contactId, customerId, userId);
                appointmentsObservableList.add(appointment);


            }
        } catch (SQLException exception) {
            throw new RuntimeException(exception);

        }
        return appointmentsObservableList;
    }

    public static void addAppointment(String appointmentTitle, String appointmentDescription, String appointmentLocation,
                                      String appointmentType, LocalDateTime appointmentStartTime, LocalDateTime appointmentEndTime,
                                      LocalDateTime createdDate, LocalDateTime lastUpdated, int contactId, int customerId, int userId) throws SQLException {
        String sql = "INSERT INTO appointments (Title, Description, Location, Type, Start, End, Create_Date, Last_Update, Contact_ID, Customer_ID, User_ID) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement insertAppointment = JDBC.conn.prepareStatement(sql);
        insertAppointment.setString(1, appointmentTitle);
        insertAppointment.setString(2, appointmentDescription);
        insertAppointment.setString(3, appointmentLocation);
        insertAppointment.setString(4, appointmentType);
        insertAppointment.setTimestamp(5, Timestamp.valueOf(appointmentStartTime));
        insertAppointment.setTimestamp(6, Timestamp.valueOf(appointmentEndTime));
        insertAppointment.setTimestamp(7, Timestamp.valueOf(createdDate));
        insertAppointment.setTimestamp(8, Timestamp.valueOf(lastUpdated));
        insertAppointment.setInt(9, contactId);
        insertAppointment.setInt(10, customerId);
        insertAppointment.setInt(11, userId);

        insertAppointment.executeUpdate();
    }

    public static void deleteAppointment(int appointmentId) {
        try {
            String sql = "DELETE FROM appointments WHERE Appointment_ID = ?";
            PreparedStatement deleteAppointment = JDBC.conn.prepareStatement(sql);
            deleteAppointment.setInt(1, appointmentId);
            deleteAppointment.execute();
        } catch (SQLException e) {e.printStackTrace();}
    }

    public static ObservableList<Appointments> getContactAppointment(int contactId) {

        ObservableList<Appointments> chosenContactAppointment = FXCollections.observableArrayList();

        try {
            String sql = "SELECT * FROM appointments JOIN contacts ON appointments.Contact_ID = contacts.Contact_ID WHERE appointments.Contact_ID = " + contactId + " ";
            PreparedStatement ps = JDBC.getConnection().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int appointmentId = rs.getInt("Appointment_ID");
                String appointmentTitle = rs.getString("Title");
                String appointmentDescription = rs.getString("Description");
                String appointmentLocation = rs.getString("Location");
                String appointmentType = rs.getString("Type");
                LocalDateTime appointmentStart = rs.getTimestamp("Start").toLocalDateTime();
                LocalDateTime appointmentEnd = rs.getTimestamp("End").toLocalDateTime();
                int appointmentContact = rs.getInt("Contact_ID");
                int appointmentCustomerId = rs.getInt("Customer_ID");
                int appointmentUserId = rs.getInt("User_ID");

                Appointments contactAppointments = new Appointments(appointmentId, appointmentTitle, appointmentDescription,
                        appointmentLocation, appointmentType, appointmentStart, appointmentEnd, appointmentContact,
                        appointmentCustomerId, appointmentUserId);

                chosenContactAppointment.add(contactAppointments);
            }

        } catch (SQLException e) {throw new RuntimeException(e);}

        return chosenContactAppointment;
    }

    public static ObservableList<Appointments> getCustomerAppointment(int customerId) {

        ObservableList<Appointments> chosenCustomerAppointment = FXCollections.observableArrayList();

        try {
            String sql = "SELECT * FROM appointments JOIN customers ON appointments.Customer_ID = customers.Customer_ID WHERE appointments.Customer_ID = " + customerId + " ";
            PreparedStatement ps = JDBC.getConnection().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int appointmentId = rs.getInt("Appointment_ID");
                String appointmentTitle = rs.getString("Title");
                String appointmentDescription = rs.getString("Description");
                String appointmentLocation = rs.getString("Location");
                String appointmentType = rs.getString("Type");
                LocalDateTime appointmentStart = rs.getTimestamp("Start").toLocalDateTime();
                LocalDateTime appointmentEnd = rs.getTimestamp("End").toLocalDateTime();
                int appointmentContact = rs.getInt("Contact_ID");
                int appointmentCustomerId = rs.getInt("Customer_ID");
                int appointmentUserId = rs.getInt("User_ID");

                Appointments customerAppointments = new Appointments(appointmentId, appointmentTitle, appointmentDescription,
                        appointmentLocation, appointmentType, appointmentStart, appointmentEnd, appointmentContact,
                        appointmentCustomerId, appointmentUserId);

                chosenCustomerAppointment.add(customerAppointments);
            }

        } catch (SQLException e) {throw new RuntimeException(e);}

        return chosenCustomerAppointment;








    }
}
