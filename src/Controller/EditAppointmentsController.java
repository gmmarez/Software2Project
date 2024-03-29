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

public class EditAppointmentsController {
    @FXML
    private TextField EditAppointmentAppointmentId;

    @FXML
    private TextField EditAppointmentTitle;

    @FXML
    private TextField EditAppointmentDescription;

    @FXML
    private TextField EditAppointmentLocation;

    @FXML
    private TextField EditAppointmentType;

    @FXML
    private TextField EditAppointmentStartTime;

    @FXML
    private TextField EditAppointmentEndTime;

    @FXML
    private TextField EditAppointmentContactId;

    @FXML
    private TextField EditAppointmentCustomerId;

    @FXML
    private TextField EditAppointmentUserId;

    @FXML
    private Button EditAppointmentsSave;

    @FXML
    private Button EditAppointmentsBack;

    Stage stage;
    Parent scene;

    @FXML
    void EditAppointmentAppointmentId(ActionEvent event) {
    }

    @FXML
    void EditAppointmentTitle(ActionEvent event) {
    }

    @FXML
    void EditAppointmentDescription(ActionEvent event) {
    }

    @FXML
    void EditAppointmentLocation(ActionEvent event) {
    }

    @FXML
    void EditAppointmentType(ActionEvent event) {
    }

    @FXML
    void EditAppointmentStartTime(ActionEvent event) {
    }

    @FXML
    void EditAppointmentEndTime(ActionEvent event) {
    }

    @FXML
    void EditAppointmentContactId(ActionEvent event) {
    }

    @FXML
    void EditAppointmentCustomerId(ActionEvent event) {
    }

    @FXML
    void EditAppointmentUserId(ActionEvent event) {
    }

    @FXML
    void AddAppointmentsSave(ActionEvent event) {
    }

    @FXML
    void EditAppointmentsBack(ActionEvent event) throws IOException {
        // Go back to Appointments screen
        stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("../View/Appointments.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();
    }
}
