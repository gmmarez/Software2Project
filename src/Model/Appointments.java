package Model;

import DAO.AppointmentDAO;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;

import java.sql.SQLException;
import java.sql.SQLOutput;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;

/** This is the Appointments class where we construct the Appointments object and make manipulations to them. */
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

    /** Appointment Constructor
     * @param appointmentId
     * @param appointmentTitle
     * @param appointmentDescription
     * @param appointmentLocation
     * @param appointmentType
     * @param appointmentStartTime
     * @param appointmentEndTime
     * @param contactId
     * @param customerId
     * @param userId
     * */
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
    public void setAppointmentDescription(String appointmentDescription) {this.appointmentDescription = appointmentDescription;}

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
    public void setAppointmentStartTime(LocalDateTime appointmentStartTime) {this.appointmentStartTime = appointmentStartTime;}

    public LocalDateTime getAppointmentEndTime() {
        return appointmentEndTime;
    }
    public void setAppointmentEndTime(LocalDateTime appointmentEndTime) {this.appointmentEndTime = appointmentEndTime;}

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

    /** This is the method to determine whether a created appointment is made within the business operating hours.
     * @param appointmentStart Appointment Start Time
     * @param appointmentEnd  Appointment End Time
     * @return true/false Whether it galls in operating business hours
     * */
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

    /** This method will check whether an Appointment is made for a Customer and that it doesn't overlap
     * any other Appointment's that Customer may have made.
     * @param customerId Customer ID
     * @param appointmentStartTime Appointment Start Time
     * @param appointmentEndTime Appointment End Time
     * @return true/false Whether it overlaps a Customer's Appointment.
     * */
    public static boolean overlapCheck(int customerId, LocalDateTime appointmentStartTime, LocalDateTime appointmentEndTime) throws SQLException {
        ObservableList<Appointments> allAppointments = AppointmentDAO.getAllAppointments();
        LocalDateTime checkAppointmentStart;
        LocalDateTime checkAppointmentEnd;

        for (Appointments appointment : allAppointments) {
            checkAppointmentStart = appointment.getAppointmentStartTime();
            checkAppointmentEnd = appointment.getAppointmentEndTime();

            if (customerId != appointment.getCustomerId()) {
                continue;

            } else if (checkAppointmentStart.isEqual(appointmentStartTime) || checkAppointmentEnd.isEqual(appointmentEndTime)) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setContentText("Appointment can't overlap an already existing appointment.(1)");
                alert.showAndWait();
                return true;

            } else if (appointmentStartTime.isAfter(checkAppointmentStart) && (appointmentStartTime.isBefore(checkAppointmentEnd))) {

                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setContentText("Appointment can't overlap an already existing appointment.(2)");
                alert.showAndWait();
                return true;

            } else if (appointmentEndTime.isAfter(checkAppointmentStart) && appointmentEndTime.isBefore(checkAppointmentEnd)) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setContentText("Appointment can't overlap an already existing appointment.(3)");
                alert.showAndWait();
                return true;

            } else if (appointmentStartTime.isBefore(checkAppointmentStart) && appointmentEndTime.isAfter(checkAppointmentEnd)) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setContentText("Appointment can't overlap an already existing appointment.(4)");
                alert.showAndWait();
                return true;

            }
        } return false;
    }

}
