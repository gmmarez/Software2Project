package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainMenuController implements Initializable {
    @FXML
    private Button MainMenuCustomers;

    @FXML
    private Button MainMenuAppointments;

    @FXML
    private Button MainMenuReports;

    @FXML
    private Button MainMenuLogout;

    Stage stage;
    Parent scene;

    @FXML
    void MainMenuCustomers(ActionEvent event) throws IOException {
        // Goes to Customers screen
        stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("../View/Customers.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();
    }

    @FXML
    void MainMenuAppointments(ActionEvent event) throws IOException {
        // Goes to Appointments screen
        stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("../View/Appointments.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();
    }

    @FXML
    void MainMenuReports(ActionEvent event) throws IOException {
        // Goes to Reports screen
        stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("../View/Reports.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();

    }

    @FXML
    void MainMenuLogout(ActionEvent event) throws IOException {
        // Goes back to Login screen
        stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("../View/Login.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
