package DAO;

import Main.JDBC;
import Model.Divisions;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DivisionDAO {
    public static ObservableList<Divisions> getAllDivisions() throws SQLException {
        ObservableList<Divisions> divisionsObservableList = FXCollections.observableArrayList();
        String sql = "SELECT * from first_level_divisions";
        PreparedStatement ps = JDBC.getConnection().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            int divisionId = rs.getInt("Division_ID");
            String divisionName = rs.getString("Division");
            int countryId = rs.getInt("Country_ID");

            Divisions divisions = new Divisions(divisionId,divisionName, countryId);
            divisionsObservableList.add(divisions);
        }

        return divisionsObservableList;
    }

}
