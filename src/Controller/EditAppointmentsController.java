package Controller;

import DAO.*;
import Model.Appointments;
import Model.Contacts;
import Model.Customers;
import Model.Users;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ResourceBundle;

public class EditAppointmentsController implements Initializable {
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
    private DatePicker EditAppointmentStartTime;

    @FXML
    private DatePicker EditAppointmentEndTime;

    @FXML
    public TextField EditAppointmentCreateDate;

    @FXML
    public TextField EditAppointmentCreatedBy;

    @FXML
    public TextField EditAppointmentLastUpdate;

    @FXML
    public TextField EditAppointmentLastUpdatedBy;

    @FXML
    public ComboBox EditAppointmentCustomerId;

    @FXML
    public ComboBox EditAppointmentUserId;

    @FXML
    public ComboBox EditAppointmentContactId;

    @FXML
    private Button EditAppointmentsSave;

    @FXML
    private Button EditAppointmentsBack;

    Stage stage;
    Parent scene;

    @FXML
    void AddAppointmentsSave(ActionEvent event) {
        /*
        try {
            if (EditAppointmentTitle.getText().isEmpty() || EditAppointmentTitle.getText().isBlank()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setContentText("Missing Appointment Title");
                alert.show();
            } else if (EditAppointmentDescription.getText().isEmpty() || EditAppointmentDescription.getText().isBlank()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setContentText("Missing Appointment Description");
                alert.show();
            } else if (EditAppointmentLocation.getText().isEmpty() || EditAppointmentLocation.getText().isBlank()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setContentText("Missing Appointment Location");
                alert.show();
            } else if (EditAppointmentType.getText().isEmpty() || EditAppointmentType.getText().isBlank()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setContentText("Missing Appointment Type");
                alert.show();
            }  else if (EditAppointmentCustomerId.equals("Customer")) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setContentText("Missing Customer");
                alert.show();
            } else if (EditAppointmentUserId.equals("User")) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setContentText("Missing User");
                alert.show();
            } else if (EditAppointmentContactId.equals("Contact")) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setContentText("Missing Contact");
                alert.show();
            }

            String appointmentTitle = EditAppointmentTitle.getText();
            String appointmentDescription = EditAppointmentDescription.getText();
            String appointmentLocation = EditAppointmentLocation.getText();
            String appointmentType = EditAppointmentType.getText();
            LocalDateTime appointmentStartTime = Timestamp.valueOf(String.valueOf(EditAppointmentStartTime)).toLocalDateTime();
            LocalDateTime appointmentEndTime = Timestamp.valueOf(String.valueOf(EditAppointmentEndTime)).toLocalDateTime();
            int contactId = EditAppointmentContactId.getValue().getContactId();
            int customerId = EditAppointmentCustomerId.getValue().getCustomerId();
            int userId = EditAppointmentUserId.getValue().getUserId();

            AppointmentDAO.updateAppointment(appointmentTitle, appointmentDescription, appointmentLocation, appointmentType,
                    appointmentStartTime, appointmentEndTime, contactId, customerId, userId);

            System.out.println("Appointment Updated");

            // Go back to Appointments screen
            stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
            scene = FXMLLoader.load(getClass().getResource("../View/Appointments.fxml"));
            stage.setScene(new Scene(scene));
            stage.show();

        } catch (IOException exception) {System.out.println(exception);}
*/
    }

    @FXML
    void EditAppointmentsBack(ActionEvent event) throws IOException {
        // Go back to Appointments screen
        stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("../View/Appointments.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();
    }

    // Set selected appointment information
    public void setAppointment(Appointments selectedAppointment) {
        this.EditAppointmentAppointmentId.setText(Integer.toString(selectedAppointment.getAppointmentId()));
        this.EditAppointmentTitle.setText(selectedAppointment.getAppointmentTitle());
        this.EditAppointmentDescription.setText(selectedAppointment.getAppointmentDescription());
        this.EditAppointmentLocation.setText(selectedAppointment.getAppointmentLocation());
        this.EditAppointmentType.setText(selectedAppointment.getAppointmentType());
        this.EditAppointmentStartTime.selectedAppointment.getAppointmentStartTime();
        this.EditAppointmentEndTime.setText(selectedAppointment.getAppointmentEndTime());
        this.EditAppointmentCustomerId.setValue(selectedAppointment.getCustomerId());
        this.EditAppointmentUserId.setValue(selectedAppointment.getUserId());
        this.EditAppointmentContactId.setValue(selectedAppointment.getContactId());

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            EditAppointmentCustomerId.setItems(CustomerDAO.getAllCustomers());
            EditAppointmentContactId.setItems(ContactDAO.getAllContacts());
            EditAppointmentUserId.setItems(UserDAO.getAllUsers());

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
