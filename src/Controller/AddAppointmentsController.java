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
import java.sql.SQLOutput;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

/** This is the controller in accordance to the AddAppointments FXML file. */
public class AddAppointmentsController implements Initializable {

    @FXML private Button AddAppointmentsClear;
    @FXML private TextField AddAppointmentAppointmentId;
    @FXML private TextField AddAppointmentTitle;
    @FXML private TextField AddAppointmentDescription;
    @FXML private TextField AddAppointmentLocation;
    @FXML private TextField AddAppointmentType;
    @FXML private DatePicker AddAppointmentStartTime;
    @FXML private TextField AddAppointmentStartHour;
    @FXML private DatePicker AddAppointmentEndTime;
    @FXML private TextField AddAppointmentEndHour;
    @FXML public TextField AddAppointmentCreateDate;
    @FXML public TextField AddAppointmentCreatedBy;
    @FXML public TextField AddAppointmentLastUpdate;
    @FXML public TextField AddAppointmentLastUpdatedBy;
    @FXML public ComboBox <Customers> AddAppointmentCustomerId;
    @FXML public ComboBox <Users> AddAppointmentUserId;
    @FXML public ComboBox <Contacts> AddAppointmentContactId;
    @FXML private Button AddAppointmentsBack;
    @FXML private Button AddAppointmentsAdd;

    Stage stage;
    Parent scene;

    /** This is the method used to navigate back to the Appointments menu.
     * @param event Add Appointment Back button     */
    @FXML
    void AddAppointmentsBack(ActionEvent event) throws IOException {
        // Go back to Appointments screen
        stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("../View/Appointments.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();
    }

    /** This is the method used to add Customer Appointments.
     * @param event Add Appointment button */
    @FXML
    void AddAppointmentsAdd(ActionEvent event) {

        try {

            DateTimeFormatter DTF = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

            String appointmentTitle = AddAppointmentTitle.getText();
            String appointmentDescription = AddAppointmentDescription.getText();
            String appointmentLocation = AddAppointmentLocation.getText();
            String appointmentType = AddAppointmentType.getText();
            String appointmentStartHour = AddAppointmentStartHour.getText();
            String appointmentEndHour = AddAppointmentEndHour.getText();
            LocalDateTime appointmentStartTime = LocalDateTime.parse(AddAppointmentStartTime.getValue().toString()+" " + appointmentStartHour, DTF);
            LocalDateTime appointmentEndTime = LocalDateTime.parse(AddAppointmentEndTime.getValue().toString()+" " + appointmentEndHour, DTF);
            LocalDateTime createdDate = LocalDateTime.now();
            LocalDateTime lastUpdated = LocalDateTime.now();
            int contactId = AddAppointmentContactId.getValue().getContactId();
            int customerId = AddAppointmentCustomerId.getValue().getCustomerId();
            int userId = AddAppointmentUserId.getValue().getUserId();

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

            } else if (AddAppointmentStartTime == null) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setContentText("Missing Appointment Start");
                alert.show();

            } else if (AddAppointmentEndTime == null) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setContentText("Missing Appointment End");
                alert.show();

            } else if (AddAppointmentContactId.equals("Contact")) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setContentText("Missing Contact");
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
            } else if (appointmentStartTime.isAfter(appointmentEndTime)) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setContentText("Appointment Start Time cannot be behind Appointment End Time.");
                alert.show();
            } else if (Appointments.withinBusinessHours(appointmentStartTime, appointmentEndTime)) {
                return;
            } else if (Appointments.overlapCheck(customerId, appointmentStartTime, appointmentEndTime)) {
                return;
            } else {

                AppointmentDAO.addAppointment(appointmentTitle, appointmentDescription, appointmentLocation, appointmentType,
                        appointmentStartTime, appointmentEndTime, createdDate, lastUpdated, contactId, customerId, userId);

                System.out.println("Appointment Added");

                // Go back to Appointments screen
                stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
                scene = FXMLLoader.load(getClass().getResource("../View/Appointments.fxml"));
                stage.setScene(new Scene(scene));
                stage.show();
            }


        } catch (SQLException | IOException exception) {System.out.println(exception);}

    }

    /** This is the methods used to initialize the AddAppointments screen.
     * @param url url
     * @param resourceBundle resourceBundle
     */
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

    /** This is the method used to clear text fields in the Add Appointments screen.
     * @param event Selection of the Clear button on the Add Appointments screen.
     */
    @FXML
    void AddAppointmentsClear(ActionEvent event) throws SQLException {
        AddAppointmentTitle.clear();
        AddAppointmentDescription.clear();
        AddAppointmentLocation.clear();
        AddAppointmentType.clear();
        AddAppointmentStartTime.setValue(LocalDate.of(2000,1,1));
        AddAppointmentEndTime.setValue(LocalDate.of(2000,1,1));
        AddAppointmentStartHour.clear();
        AddAppointmentEndHour.clear();
    }
}
