package Model;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;

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

}
