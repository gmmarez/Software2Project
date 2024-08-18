package DAO;

import Main.JDBC;
import Model.Appointments;
import Model.Divisions;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

/** This is the DAO file in which SQL queries regarding Divisions are made to the MySQL Workbench database. */
public class DivisionDAO {

    /** This method will return all Division records from the database.
     * @return divisionsObservableList All Divisions
     * */
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

    /** This method will return all Divisions in a Country given a Country ID.
     * @param countryId Country ID
     *
     * @return chosenCountryDivision*/
    public static ObservableList<Divisions> getCountryDivision(int countryId) {

        ObservableList<Divisions> chosenCountryDivision = FXCollections.observableArrayList();

        try {
            String sql = "SELECT * FROM first_level_divisions JOIN countries ON first_level_divisions.Country_ID = countries.Country_ID WHERE first_level_divisions.Country_ID = " + countryId + " ";
            PreparedStatement ps = JDBC.getConnection().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int divisonId = rs.getInt("Division_ID");
                String divisionName = rs.getString("Division");
                countryId = rs.getInt("Country_ID");


                Divisions countryDivisions = new Divisions(divisonId, divisionName, countryId);

                chosenCountryDivision.add(countryDivisions);
            }

        } catch (SQLException e) {throw new RuntimeException(e);}

        return chosenCountryDivision;
    }

}
