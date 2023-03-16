package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;

public class AddAppointmentsController {

    @FXML
    private TextField AddAppointmentAppointmentId;

    @FXML
    private TextField AddAppointmentTitle;

    @FXML
    private TextField AddAppointmentDescription;

    @FXML
    private TextField AddAppointmentLocation;

    @FXML
    private TextField AddAppointmentType;

    @FXML
    private TextField AddAppointmentStartTime;

    @FXML
    private TextField AddAppointmentEndTime;

    @FXML
    private TextField AddAppointmentContactId;

    @FXML
    private TextField AddAppointmentCustomerId;

    @FXML
    private TextField AddAppointmentUserId;

    @FXML
    private Button AddAppointmentsBack;

    @FXML
    private Button AddAppointmentsAdd;

    Stage stage;
    Parent scene;

    @FXML
    void AddAppointmentsBack(ActionEvent event) throws IOException {
        // Go back to Appointments screen
        stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("../View/Appointments.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();
    }

    @FXML
    void AddAppointmentsAdd(ActionEvent event) {
        // Grab whats in text boxes and add appointment
    }

    @FXML
    void AddAppointmentAppointmentId(ActionEvent event) {
    }

    @FXML
    void AddAppointmentTitle(ActionEvent event) {
    }

    @FXML
    void AddAppointmentDescription(ActionEvent event) {
    }

    @FXML
    void AddAppointmentLocation(ActionEvent event) {
    }

    @FXML
    void AddAppointmentType(ActionEvent event) {
    }

    @FXML
    void AddAppointmentStartTime(ActionEvent event) {
    }

    @FXML
    void AddAppointmentEndTime(ActionEvent event) {
    }

    @FXML
    void AddAppointmentContactId(ActionEvent event) {
    }

    @FXML
    void AddAppointmentCustomerId(ActionEvent event) {
    }

    @FXML
    void AddAppointmentUserId(ActionEvent event) {
    }
}
