package DAO;

import Main.JDBC;
import Model.Reports;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReportDAO {

    public static ObservableList<Reports> getReportResults() throws SQLException {

        ObservableList<Reports> reportsObservableList = FXCollections.observableArrayList();

        try {
            String sql = "SELECT Type, monthname(Start) AS Month, COUNT(*) AS Total FROM client_schedule.appointments GROUP BY Type, Month;";
            PreparedStatement ps = JDBC.getConnection().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            System.out.println(sql);
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
