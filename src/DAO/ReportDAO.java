package DAO;

import Main.JDBC;
import Model.Reports;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/** This is the DAO file in which SQL queries regarding Reports are made to the MySQL Workbench database. */
public class ReportDAO {

    /** This method will return all Appointments Type per Appointments Month and total them up by
     * using a SQL query to the database.
     *
     * @return reportsObservableList Appointments Type, Month, Total
     * */
    public static ObservableList<Reports> getReportResults() throws SQLException {

        ObservableList<Reports> reportsObservableList = FXCollections.observableArrayList();

        try {
            String sql = "SELECT Type, monthname(Start) AS Month, COUNT(*) AS Total FROM client_schedule.appointments GROUP BY Type, Month;";
            PreparedStatement ps = JDBC.getConnection().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String type = rs.getString("Type");
                String month = rs.getString("Month");
                int count = rs.getInt("Total");

                Reports report = new Reports(type, month, count);

                reportsObservableList.add(report);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return reportsObservableList;
    }

}
