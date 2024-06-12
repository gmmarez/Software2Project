package Controller;

import DAO.ContactDAO;
import DAO.CountryDAO;
import DAO.CustomerDAO;
import DAO.UserDAO;
import Model.Appointments;
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
    private TextField EditAppointmentStartTime;

    @FXML
    private TextField EditAppointmentEndTime;

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
    }

    @FXML
    void EditAppointmentsBack(ActionEvent event) throws IOException {
        // Go back to Appointments screen
        stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("../View/Appointments.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();
    }

    public void setAppointment(Appointments selectedAppointment) {
        this.EditAppointmentAppointmentId.setText(Integer.toString(selectedAppointment.getAppointmentId()));
        this.EditAppointmentTitle.setText(selectedAppointment.getAppointmentTitle());
        this.EditAppointmentDescription.setText(selectedAppointment.getAppointmentDescription());
        this.EditAppointmentLocation.setText(selectedAppointment.getAppointmentLocation());
        this.EditAppointmentType.setText(selectedAppointment.getAppointmentType());
        this.EditAppointmentStartTime.setText(selectedAppointment.getAppointmentStartTime().toString());
        this.EditAppointmentEndTime.setText(selectedAppointment.getAppointmentEndTime().toString());
        this.EditAppointmentCustomerId.setValue(selectedAppointment.getCustomerId());
        this.EditAppointmentUserId.setValue(selectedAppointment.getUserId());
        this.EditAppointmentContactId.setValue(selectedAppointment.getContactId());

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            EditAppointmentCustomerId.setItems(CustomerDAO.getAllCustomers());
            EditAppointmentContactId.setValue(ContactDAO.getAllContacts());
            EditAppointmentUserId.setValue(UserDAO.getAllUsers());

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
