package DAO;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import Model.Appointments;
import Main.JDBC;
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

}
