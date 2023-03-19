package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class AppointmentsController {

    @FXML
    private Button AppointmentsAddAppointment;

    @FXML
    private Button AppointmentsEditAppointment;

    @FXML
    private Button AppointmentsDeleteAppointment;

    @FXML
    private Button AppointmentsBack;

    Stage stage;
    Parent scene;

    @FXML
    void AppointmentsAddAppointment(ActionEvent event) throws IOException {
        // Go to Add Appointment Screen
        stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("../View/AddAppointments.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();
    }

    @FXML
    void AppointmentsEditAppointment(ActionEvent event) throws IOException {
        // Go to Edit Appointment Screen
        stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("../View/EditAppointments.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();
    }

    @FXML
    void AppointmentsDeleteAppointment(ActionEvent actionEvent) {
    }

    @FXML
    void AppointmentsBack(ActionEvent event) throws IOException {
        // Go back to Main Menu
        stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("../View/MainMenu.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();

    }
}
