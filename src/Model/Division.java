package Model;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class Division {

    private int divisionId;
    private String divisionName;
    private Date createDate;
    private String createdBy;
    private Timestamp lastUpdate;
    private String lastUpdatedBy;
    private int countryId;

    public Division(int divisionId, String divisionName, Date createDate, String createdBy,
                    Timestamp lastUpdate, String lastUpdatedBy, int countryId) {
        this.divisionId = divisionId;
        this.divisionName = divisionName;
        this.createDate = createDate;
        this.createdBy = createdBy;
        this.lastUpdate = lastUpdate;
        this.lastUpdatedBy = lastUpdatedBy;
        this.countryId = countryId;
    }

}
