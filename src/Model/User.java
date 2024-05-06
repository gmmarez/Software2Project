package Model;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class User {

    private int userId;
    private String userName;
    private String userPassword;
    private Date createDate;
    private String createdBy;
    private Timestamp lastUpdate;
    private String lastUpdatedBy;

    public User(int userId, String userName, String userPassword, Date createDate, String createdBy, Timestamp lastUpdate,
                String lastUpdatedBy) {
        this.userId = userId;
        this.userName = userName;
        this.userPassword = userPassword;
        this.createDate = createDate;
        this.createdBy = createdBy;
        this.lastUpdate = lastUpdate;
        this.lastUpdatedBy = lastUpdatedBy;
    }

}
