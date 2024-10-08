package Model;

/** This is the Users class where we construct the Users object and make manipulations to them. */
public class Users {

    private int userId;
    private String userName;
    private String userPassword;

    /** User Constructor
     * @param userId
     * @param userName
     * @param userPassword
     * */
    public Users(int userId, String userName, String userPassword) {
        this.userId = userId;
        this.userName = userName;
        this.userPassword = userPassword;
    }
    public int getUserId() {
        return userId;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String toString() {
        return this.userName;
    }
}
