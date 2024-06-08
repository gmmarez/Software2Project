package Controller;

import DAO.AppointmentDAO;
import DAO.ContactDAO;
import DAO.CountryDAO;
import Model.Appointments;
import Model.Contacts;
import Model.Country;
import Model.Customers;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ResourceBundle;

public class ReportsController implements Initializable {

// Customers by Country
    @FXML private ComboBox<Country> countryTableComboBox;
    @FXML private TableView CountryTable;
    @FXML private TableColumn<Customers, Integer> countryCustomerId;
    @FXML private TableColumn<Customers, String> countryCustomerName;
    @FXML private TableColumn<Customers, String> countryCustomerAddress;
    @FXML private TableColumn<Customers, String> countryCustomerPostalCode;
    @FXML private TableColumn<Customers, String> countryCustomerPhone;
    @FXML private TableColumn<Customers, Integer> countryCustomerDivisionId;
    ObservableList<Country> allCountries = CountryDAO.getAllCountries();

 // Appointments by Contact
    @FXML private TableView ContactTable;
    @FXML private ComboBox<Contacts> contactTableComboBox;
    @FXML private TableColumn<Appointments, Integer> contactAppointmentId;
    @FXML private TableColumn<Appointments, String> contactAppointmentTitle;
    @FXML private TableColumn<Appointments, String> contactAppointmentDescription;
    @FXML private TableColumn<Appointments, Integer> contactAppointmentContact;
    @FXML private TableColumn<Appointments, Timestamp> contactAppointmentStart;
    @FXML private TableColumn<Appointments, Timestamp> contactAppointmentEnd;
    @FXML private TableColumn<Appointments, String> contactAppointmentType;
    @FXML private TableColumn<Appointments, Integer> contactAppointmentCustomerId;
    @FXML private TableColumn<Appointments, Integer> contactAppointmentUserId;
    ObservableList<Contacts> allContacts = ContactDAO.getAllContacts();

    @FXML public Button ReportsBack;
    Stage stage;
    Parent scene;

    public ReportsController() throws SQLException {
    }

    @FXML
    void ReportsBack(ActionEvent event) throws IOException {
        // Goes back to Main Menu
        stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("../View/MainMenu.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();
        }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Setting the Appointments by Contact table.
        contactTableComboBox.setItems(allContacts);
        ContactTable.setPlaceholder(new Label("Select a contact to view appointments."));

        contactAppointmentId.setCellValueFactory(new PropertyValueFactory<>("appointmentId"));
        contactAppointmentTitle.setCellValueFactory(new PropertyValueFactory<>("appointmentTitle"));
        contactAppointmentDescription.setCellValueFactory(new PropertyValueFactory<>("appointmentDescription"));
        contactAppointmentContact.setCellValueFactory(new PropertyValueFactory<>("contactId"));
        contactAppointmentStart.setCellValueFactory(new PropertyValueFactory<>("appointmentStartTime"));
        contactAppointmentEnd.setCellValueFactory(new PropertyValueFactory<>("appointmentEndTime"));
        contactAppointmentType.setCellValueFactory(new PropertyValueFactory<>("appointmentType"));
        contactAppointmentCustomerId.setCellValueFactory(new PropertyValueFactory<>("customerId"));
        contactAppointmentUserId.setCellValueFactory(new PropertyValueFactory<>("userId"));

        ContactTable.refresh();

        // Setting the Customers by Country table.
        countryTableComboBox.setItems(allCountries);


    }

    public void contactTableComboBox(ActionEvent event) throws SQLException {
        String chosenContactName = String.valueOf(contactTableComboBox.getValue());
        int chosenContactId = ContactDAO.getContactId(chosenContactName);

        if (AppointmentDAO.getContactAppointment(chosenContactId).isEmpty()) {
            ContactTable.setPlaceholder(new Label(chosenContactName + " has no appointments."));
            ContactTable.refresh();
                for (int i =0; i < ContactTable.getItems().size(); i++) {
                    ContactTable.getItems().clear();
                    ContactTable.setPlaceholder(new Label(chosenContactName + " has no appointments."));
                }
        } else {
            ContactTable.setItems(AppointmentDAO.getContactAppointment(chosenContactId));
        }

    }


    public void countryTableComboBox(ActionEvent event) {
    }
}
