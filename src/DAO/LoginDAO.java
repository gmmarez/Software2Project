package DAO;

import Main.JDBC;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDAO {

    public LoginDAO(int userID, String userName, String userPassword) {
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

}
