package Model;

import java.time.LocalDateTime;
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

    public void setAppointmentDescription(String appointmentDescription) { this.appointmentDescription = appointmentDescription; }

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

    public LocalDateTime getAppointmentEndTime() {return appointmentEndTime;}

    public void setAppointmentEndTime(LocalDateTime appointmentEndTime) { this.appointmentEndTime = appointmentEndTime; }

    public int getContactId() { return contactId;}

    public void setContactId(int contactId) {
        this.contactId = contactId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getUserId() { return userId;}

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public static boolean withinBusinessHours (LocalDateTime appointmentStart, LocalDateTime appointmentEnd) {

        ZoneId LOCAL_ZONE = ZoneId.systemDefault();
        ZoneId EST_ZONE = ZoneId.of("America/New_York");

        LocalDateTime appointmentStartEST = appointmentStart.atZone(LOCAL_ZONE).withZoneSameInstant(EST_ZONE).toLocalDateTime();
        LocalDateTime appointmentEndEST = appointmentEnd.atZone(LOCAL_ZONE).withZoneSameInstant(EST_ZONE).toLocalDateTime();

        LocalDateTime businessStartEST = appointmentStartEST.withHour(8).withMinute(0);
        LocalDateTime businessEndEST = appointmentEndEST.withHour(22).withMinute(0);
    }
}
