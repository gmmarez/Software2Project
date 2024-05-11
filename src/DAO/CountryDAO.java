package DAO;

import Main.JDBC;
import Model.Contacts;
import Model.Country;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

public class CountryDAO {
    ObservableList<Country> getAllCountries() throws SQLException {
        ObservableList<Country> countryObservableList = FXCollections.observableArrayList();
        String sql = "SELECT * from countries";
        PreparedStatement ps = JDBC.getConnection().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            int countryId =rs.getInt("Country_ID");
            String countryName = rs.getString("Country_Name");

            Country country = new Country(countryId, countryName);
            countryObservableList.add(country);
        }

        return countryObservableList;
    }

}
