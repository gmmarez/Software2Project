package Model;

import DAO.AppointmentDAO;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;

import java.sql.SQLException;
import java.sql.SQLOutput;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;

public class Appointments {

    private int appointmentId;
    private String appointmentTitle;
    private String appointmentDescription;
    private String appointmentLocation;
    private String appointmentType;
    private LocalDateTime appointmentStartTime;
    private LocalDateTime appointmentEndTime;
    private int contactId;
    private int customerId;
    private int userId;

    public Appointments(int appointmentId, String appointmentTitle, String appointmentDescription, String appointmentLocation,
                        String appointmentType, LocalDateTime appointmentStartTime, LocalDateTime appointmentEndTime,
                        int contactId, int customerId, int userId) {
        this.appointmentId = appointmentId;
        this.appointmentTitle = appointmentTitle;
        this.appointmentDescription = appointmentDescription;
        this.appointmentLocation = appointmentLocation;
        this.appointmentType = appointmentType;
        this.appointmentStartTime = appointmentStartTime;
        this.appointmentEndTime = appointmentEndTime;
        this.contactId = contactId;
        this.customerId = customerId;
        this.userId = userId;
    }

    public int getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(int appointmentId) {
        this.appointmentId = appointmentId;
    }

    public String getAppointmentTitle() {
        return appointmentTitle;
    }

    public void setAppointmentTitle(String appointmentTitle) {
        this.appointmentTitle = appointmentTitle;
    }

    public String getAppointmentDescription() {
        return appointmentDescription;
    }

    public void setAppointmentDescription(String appointmentDescription) {
        this.appointmentDescription = appointmentDescription;
    }

    public String getAppointmentLocation() {
        return appointmentLocation;
    }

    public void setAppointmentLocation(String appointmentLocation) {
        this.appointmentLocation = appointmentLocation;
    }

    public String getAppointmentType() {
        return appointmentType;
    }

    public void setAppointmentType(String appointmentType) {
        this.appointmentType = appointmentType;
    }

    public LocalDateTime getAppointmentStartTime() {
        return appointmentStartTime;
    }

    public void setAppointmentStartTime(LocalDateTime appointmentStartTime) {
        this.appointmentStartTime = appointmentStartTime;
    }

    public LocalDateTime getAppointmentEndTime() {
        return appointmentEndTime;
    }

    public void setAppointmentEndTime(LocalDateTime appointmentEndTime) {
        this.appointmentEndTime = appointmentEndTime;
    }

    public int getContactId() {
        return contactId;
    }

    public void setContactId(int contactId) {
        this.contactId = contactId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public static boolean withinBusinessHours(LocalDateTime appointmentStart, LocalDateTime appointmentEnd) {
        ZoneId LocalZone = ZoneId.systemDefault();
        ZoneId EasternTimeZone = ZoneId.of("America/New_York");

        LocalDateTime appointmentStartEST = appointmentStart.atZone(LocalZone).withZoneSameInstant(EasternTimeZone).toLocalDateTime();
        LocalDateTime appointmentEndEST = appointmentEnd.atZone(LocalZone).withZoneSameInstant(EasternTimeZone).toLocalDateTime();

        LocalDateTime businessStartEST = appointmentStartEST.withHour(8).withMinute(0);
        LocalDateTime businessEndEST = appointmentStartEST.withHour(22).withMinute(0);

        // System.out.println("Local Appointment End: " + appointmentEnd);
        // System.out.println("EST Appointment End: " + appointmentEndEST);
        // System.out.println("EST Business End: " + businessEndEST);

        // Before business open for the day.
        if (appointmentStartEST.isBefore(businessStartEST)) {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Appointment start not within business hours");
            alert.setContentText("Appointment needs to be scheduled withing business hours. (Daily 0800-2200 EST)");
            alert.showAndWait();

            return true;

        // After business close.
        } else if (appointmentEndEST.isAfter(businessEndEST)) {

            Alert alert1 = new Alert(Alert.AlertType.ERROR);
            alert1.setTitle("Appointment end not within business hours");
            alert1.setContentText("Appointment needs to be scheduled withing business hours. (Daily 0800-2200 EST)");
            alert1.showAndWait();

            return true;

        } else {
            return false;

        }

    }

    public static boolean overlapCheck(int customerId, LocalDateTime appointmentStartTime, LocalDateTime appointmentEndTime) throws SQLException {
        ObservableList<Appointments> allAppointments = AppointmentDAO.getAllAppointments();
        LocalDateTime checkAppointmentStart;
        LocalDateTime checkAppointmentEnd;




        return false;
    }

}
