package DAO;

import Main.JDBC;
import Model.Contacts;
import Model.Country;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

public class CountryDAO {
    public static ObservableList<Country> getAllCountries() throws SQLException {
        ObservableList<Country> countryObservableList = FXCollections.observableArrayList();
        String sql = "SELECT Country_ID, Country from countries";
        PreparedStatement ps = JDBC.getConnection().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            int countryId =rs.getInt("Country_ID");
            String countryName = rs.getString("Country");

            Country country = new Country(countryId, countryName);
            countryObservableList.add(country);
        }

        return countryObservableList;
    }

    public static int getCountryId(String countryName) throws SQLException {
        String sql = "SELECT * FROM countries WHERE Country = ?";
        PreparedStatement ps = JDBC.getConnection().prepareStatement(sql);
        ps.setString(1, countryName);
        ResultSet rs = ps.executeQuery();

        int countryId = 0;
        while (rs.next()) {
            countryId = rs.getInt("Country_ID");
        }
        return countryId;
    }


}
