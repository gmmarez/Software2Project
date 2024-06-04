package Controller;

import DAO.*;
import Model.Contacts;
import Model.Customers;
import Model.Users;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDateTime;
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
    public ComboBox <Customers> AddAppointmentCustomerId;

    @FXML
    public ComboBox <Users> AddAppointmentUserId;

    @FXML
    public ComboBox <Contacts> AddAppointmentContactId;

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

        try {
            if (AddAppointmentTitle.getText().isEmpty() || AddAppointmentTitle.getText().isBlank()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setContentText("Missing Appointment Title");
                alert.show();
            } else if (AddAppointmentDescription.getText().isEmpty() || AddAppointmentDescription.getText().isBlank()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setContentText("Missing Appointment Description");
                alert.show();
            } else if (AddAppointmentLocation.getText().isEmpty() || AddAppointmentLocation.getText().isBlank()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setContentText("Missing Appointment Location");
                alert.show();
            } else if (AddAppointmentType.getText().isEmpty() || AddAppointmentType.getText().isBlank()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setContentText("Missing Appointment Type");
                alert.show();
            }  else if (AddAppointmentCustomerId.equals("Customer")) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setContentText("Missing Customer");
                alert.show();
            } else if (AddAppointmentUserId.equals("User")) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setContentText("Missing User");
                alert.show();
            } else if (AddAppointmentContactId.equals("Contact")) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setContentText("Missing Contact");
                alert.show();
            }

                String appointmentTitle = AddAppointmentTitle.getText();
                String appointmentDescription = AddAppointmentDescription.getText();
                String appointmentLocation = AddAppointmentLocation.getText();
                String appointmentType = AddAppointmentType.getText();
                LocalDateTime appointmentStartTime = LocalDateTime.now();
                LocalDateTime appointmentEndTime = LocalDateTime.now();
                LocalDateTime createdDate = LocalDateTime.now();
                LocalDateTime lastUpdated = LocalDateTime.now();
                int contactId = AddAppointmentContactId.getValue().getContactId();
                int customerId = AddAppointmentCustomerId.getValue().getCustomerId();
                int userId = AddAppointmentUserId.getValue().getUserId();


            AppointmentDAO.addAppointment(appointmentTitle, appointmentDescription, appointmentLocation, appointmentType,
                    appointmentStartTime, appointmentEndTime, createdDate, lastUpdated, contactId, customerId, userId);

            System.out.println("Appointment Added");
            // Go back to Appointments screen
            stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
            scene = FXMLLoader.load(getClass().getResource("../View/Appointments.fxml"));
            stage.setScene(new Scene(scene));
            stage.show();


        } catch (SQLException | IOException exception) {System.out.println(exception);}

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            AddAppointmentContactId.setItems(ContactDAO.getAllContacts());
            AddAppointmentCustomerId.setItems(CustomerDAO.getAllCustomers());
            AddAppointmentUserId.setItems(UserDAO.getAllUsers());

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
