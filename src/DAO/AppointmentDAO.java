package DAO;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import Model.Appointments;
import Main.JDBC;
import java.sql.*;
import java.time.LocalDateTime;

public class AppointmentDAO {
    ObservableList<Appointments> getAllAppointments() throws SQLException {
        ObservableList<Appointments> appointmentsObservableList = FXCollections.observableArrayList();
        String sql = "SELECT * from appointments";
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
            Appointments appointments = new Appointments(appointmentId, appointmentTitle, appointmentDescription, appointmentLocation,
                    appointmentType, appointmentStartTime, appointmentEndTime, contactId, customerId, userId);
            appointmentsObservableList.add(appointments);

        }

        return appointmentsObservableList;
    }

}
