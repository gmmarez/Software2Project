package Controller;

import DAO.*;
import Model.*;
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
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

/** This is the controller in accordance to the EditAppointments FXML file. */
public class EditAppointmentsController implements Initializable {

    @FXML private TextField EditAppointmentAppointmentId;
    @FXML private TextField EditAppointmentTitle;
    @FXML private TextField EditAppointmentDescription;
    @FXML private TextField EditAppointmentLocation;
    @FXML private TextField EditAppointmentType;
    @FXML private DatePicker EditAppointmentStartTime;
    @FXML private TextField EditAppointmentStartHour;
    @FXML private DatePicker EditAppointmentEndTime;
    @FXML private TextField EditAppointmentEndHour;
    @FXML public TextField EditAppointmentCreateDate;
    @FXML public TextField EditAppointmentCreatedBy;
    @FXML public TextField EditAppointmentLastUpdate;
    @FXML public TextField EditAppointmentLastUpdatedBy;
    @FXML public ComboBox <Customers> EditAppointmentCustomerId;
    @FXML public ComboBox <Users> EditAppointmentUserId;
    @FXML public ComboBox <Contacts> EditAppointmentContactId;
    @FXML private Button EditAppointmentsSave;
    @FXML private Button EditAppointmentsBack;

    Stage stage;
    Parent scene;

    /** This method will take the selected Appointments and save all changes that have been made.
     * @param event Selection of the Save button.
     */
    @FXML
    void AddAppointmentsSave(ActionEvent event) {

        try {

            DateTimeFormatter DTF = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

            int appointmentId = Integer.parseInt(EditAppointmentAppointmentId.getText());
            String appointmentTitle = EditAppointmentTitle.getText();
            String appointmentDescription = EditAppointmentDescription.getText();
            String appointmentLocation = EditAppointmentLocation.getText();
            String appointmentType = EditAppointmentType.getText();
            String appointmentStartHour = EditAppointmentStartHour.getText();
            String appointmentEndHour = EditAppointmentEndHour.getText();
            LocalDateTime appointmentStartTime = LocalDateTime.parse(EditAppointmentStartTime.getValue().toString()+" " + appointmentStartHour, DTF);
            LocalDateTime appointmentEndTime = LocalDateTime.parse(EditAppointmentEndTime.getValue().toString()+" " + appointmentEndHour, DTF);
            int contactId = EditAppointmentContactId.getValue().getContactId();
            int customerId = EditAppointmentCustomerId.getValue().getCustomerId();
            int userId = EditAppointmentUserId.getValue().getUserId();

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
            } else if (Appointments.withinBusinessHours(appointmentStartTime, appointmentEndTime)) {
                return;
            } else if (Appointments.overlapCheck(customerId, appointmentStartTime, appointmentEndTime)) {
                return;
            } else {

                AppointmentDAO.updateAppointment(appointmentId, appointmentTitle, appointmentDescription, appointmentLocation, appointmentType,
                        appointmentStartTime, appointmentEndTime, contactId, customerId, userId);

                System.out.println("Appointment Updated");

                // Go back to Appointments screen
                stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
                scene = FXMLLoader.load(getClass().getResource("../View/Appointments.fxml"));
                stage.setScene(new Scene(scene));
                stage.show();
            }

        } catch (SQLException | IOException exception) {System.out.println(exception);}
    }

    /** This method will direct the user back to the Appointments menu.
     * @param event Selection of the Back button. */
    @FXML
    void EditAppointmentsBack(ActionEvent event) throws IOException {
        // Go back to Appointments screen
        stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("../View/Appointments.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();
    }

    /** This method will set the selected Appointment data in their respective text boxes.
     * @param selectedAppointment Selected Appointment to be edited.
     */
    public void setAppointment(Appointments selectedAppointment) throws SQLException {
        this.EditAppointmentAppointmentId.setText(Integer.toString(selectedAppointment.getAppointmentId()));
        this.EditAppointmentTitle.setText(selectedAppointment.getAppointmentTitle());
        this.EditAppointmentDescription.setText(selectedAppointment.getAppointmentDescription());
        this.EditAppointmentLocation.setText(selectedAppointment.getAppointmentLocation());
        this.EditAppointmentType.setText(selectedAppointment.getAppointmentType());
        this.EditAppointmentStartTime.setValue(selectedAppointment.getAppointmentStartTime().toLocalDate());
        this.EditAppointmentStartHour.setText(String.valueOf(selectedAppointment.getAppointmentStartTime().toLocalTime()));
        this.EditAppointmentEndTime.setValue(selectedAppointment.getAppointmentStartTime().toLocalDate());
        this.EditAppointmentEndHour.setText(String.valueOf(selectedAppointment.getAppointmentEndTime().toLocalTime()));

        for (Contacts contact: ContactDAO.getAllContacts()) {
            if (contact.getContactId()== selectedAppointment.getContactId()) {
                this.EditAppointmentContactId.setValue(contact);

            }
        }

        for (Customers customer: CustomerDAO.getAllCustomers()) {
            if (customer.getCustomerId()== selectedAppointment.getCustomerId()) {
                this.EditAppointmentCustomerId.setValue(customer);

            }
        }

        for (Users user: UserDAO.getAllUsers()) {
            if (user.getUserId()== selectedAppointment.getUserId()) {
                this.EditAppointmentUserId.setValue(user);

            }
        }
    }

    /** This method will initialize the Edit Appointments screen. This includes setting the customers, contact,
     * and user data in their respective combo boxes.
     * @param url url
     * @param resourceBundle resourceBundle
     */
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
