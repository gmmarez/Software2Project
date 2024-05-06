package Model;

import java.time.LocalDateTime;

public class Appointment {

    private int appointmentId;
    private String appointmentTitle;
    private String appointmentDescription;
    private String appointmentLocation;
    private String appointmentType;
    private LocalDateTime appointmentStartTime;
    private LocalDateTime appointmentEndTime;
    private LocalDateTime createDate;
    private String createdBy;
    private LocalDateTime lastUpdate;
    private String lastUpdatedBy;
    private int contactId;
    private int customerId;
    private int userId;

    public Appointment(int appointmentId, String appointmentTitle, String appointmentDescription, String appointmentLocation,
                       String appointmentType, LocalDateTime appointmentStartTime, LocalDateTime appointmentEndTime,
                       LocalDateTime createDate, String createdBy, LocalDateTime lastUpdate, String lastUpdatedBy,
                       int contactId, int customerId, int userId) {
        this.appointmentId = appointmentId;
        this.appointmentTitle = appointmentTitle;
        this.appointmentDescription = appointmentDescription;
        this.appointmentLocation = appointmentLocation;
        this.appointmentType = appointmentType;
        this.appointmentStartTime = appointmentStartTime;
        this.appointmentEndTime = appointmentEndTime;
        this.createDate = createDate;
        this.createdBy = createdBy;
        this.lastUpdate = lastUpdate;
        this.lastUpdatedBy = lastUpdatedBy;
        this.contactId = contactId;
        this.customerId = customerId;
        this.userId = userId;
    }

}
