package DAO;

import Main.JDBC;
import Model.Users;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {

    public UserDAO(int userID, String userName, String userPassword) {
        super();
    }
    public static int validateUser(String username, String password){
        try {
            String query = "SELECT * FROM users WHERE user_name = '\" + username + \"' AND password = '\" + password +\"'\";\n";
            PreparedStatement ps = JDBC.getConnection().prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            rs.next();
            if (rs.getString("User_name").equals(username)) {
                if (rs.getString("Password").equals(password)){
                    return rs.getInt("user_ID");
                }
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return -1;
    }
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
