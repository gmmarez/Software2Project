package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AddAppointmentsController implements Initializable {
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
    public TextField AddAppointmentCreateDate;

    @FXML
    public TextField AddAppointmentCreatedBy;

    @FXML
    public TextField AddAppointmentLastUpdate;

    @FXML
    public TextField AddAppointmentLastUpdatedBy;

    @FXML
    public ComboBox AddAppointmentCustomerId;

    @FXML
    public ComboBox AddAppointmentUserId;

    @FXML
    public ComboBox AddAppointmentContactId;

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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
