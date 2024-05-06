package Model;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class User {

    private int userId;
    private String userName;
    private String userPassword;
    private LocalDateTime createDate;
    private String createdBy;
    private LocalDateTime lastUpdate;
    private String lastUpdatedBy;

    public User(int userId, String userName, String userPassword, LocalDateTime createDate, String createdBy, LocalDateTime lastUpdate,
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
