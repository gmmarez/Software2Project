package Model;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class Appointment {

    private int appointmentId;
    private String appointmentTitle;
    private String appointmentDescription;
    private String appointmentLocation;
    private String appointmentType;
    private Timestamp appointmentStartTime;
    private Timestamp appointmentEndTime;
    private Date createDate;
    private String createdBy;
    private Timestamp lastUpdate;
    private String lastUpdatedBy;
    private int contactId;
    private int customerId;
    private int userId;

    public Appointment(int appointmentId, String appointmentTitle, String appointmentDescription, String appointmentLocation,
                       String appointmentType, Timestamp appointmentStartTime, Timestamp appointmentEndTime,
                       Date createDate, String createdBy, Timestamp lastUpdate, String lastUpdatedBy,
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
