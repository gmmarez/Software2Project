package DAO;

import Main.JDBC;
import Model.Users;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/** This is the DAO file in which SQL queries regarding Users are made to the MySQL Workbench database. */
public class UserDAO {

    public UserDAO(int userID, String userName, String userPassword) {
        super();
    }

    /** This method is used when validating a User login attempt. It takes in a both a username and password.
     * @param username Username
     * @param password Password
     **/
    public static int validateUser(String username, String password){
        try {
            String query = "SELECT * FROM client_schedule.users WHERE User_Name = '" + username + "' AND Password = '" + password + "'";

            PreparedStatement ps = JDBC.getConnection().prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            rs.next();
            if (rs.getString("User_Name").equals(username)) {
                if (rs.getString("Password").equals(password)){
                    return rs.getInt("User_ID");
                }
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return -1;
    }

    /** This method is used when getting a list of all the User records in the database.
     *@return usersObservableList All User records
     * */
    public static ObservableList<Users> getAllUsers() throws SQLException {
        ObservableList<Users> usersObservableList = FXCollections.observableArrayList();
        String sql = "SELECT * from users";
        PreparedStatement ps = JDBC.getConnection().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            int userId = rs.getInt("User_ID");
            String userName = rs.getString("User_Name");
            String userPassword = rs.getString("Password");

            Users users = new Users(userId, userName, userPassword);
            usersObservableList.add(users);
        }
        return usersObservableList;
    }

}
