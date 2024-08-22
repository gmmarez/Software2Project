package Controller;

import DAO.*;
import Model.*;
import javafx.beans.value.ObservableValue;
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

/** This is the controller in accordance to the Reports FXML file. */
public class ReportsController implements Initializable {

    // Reports Type Table
    @FXML private TableView ReportsTable;
    @FXML private TableColumn<Reports, String> reportsType;
    @FXML private TableColumn<Reports, String> reportsMonth;
    @FXML private TableColumn<Reports, Integer> reportsTotal;
    ObservableList<Reports> allReports = ReportDAO.getReportResults();

    // Appointments by Customer
    @FXML private ComboBox<Customers> customerTableComboBox;
    @FXML private TableView CustomerTable;
    @FXML private TableColumn<Appointments, Integer> customerAppointmentId;
    @FXML private TableColumn<Appointments, String> customerAppointmentTitle;
    @FXML private TableColumn<Appointments, String> customerAppointmentDescription;
    @FXML private TableColumn<Appointments, Integer> customerAppointmentContact;
    @FXML private TableColumn<Appointments, Timestamp> customerAppointmentStart;
    @FXML private TableColumn<Appointments, Timestamp> customerAppointmentEnd;
    @FXML private TableColumn<Appointments, String> customerAppointmentType;
    @FXML private TableColumn<Appointments, Integer> customerAppointmentCustomerId;
    @FXML private TableColumn<Appointments, Integer> customerAppointmentUserId;
    ObservableList<Customers> allCustomers = CustomerDAO.getAllCustomers();

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

    /** This method will direct the user to the Main Menu screen.
     * @param event Selection of the Back button.
     * */
    @FXML
    void ReportsBack(ActionEvent event) throws IOException {
        stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("../View/MainMenu.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();
        }

    /** LAMBDA EXPRESSION USAGE
     * This method will initialize reports in the Reports screen. This includes the combo boxes for each of the tables
     * and the tables themselves. This also includes the use of a lambda expression to set the Appointments by Customer
     * table. This improves the code by efficiently setting the combo boxes and setting the Appointments by
     * Customers table.
     * @param url url
     * @param resourceBundle resourceBundle
     * */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        // Setting the Appointments by Customer table
        customerTableComboBox.setItems(allCustomers);
        CustomerTable.setPlaceholder(new Label("Select a Customer to view appointments."));
        customerTableComboBox.setOnAction((event) -> {
            String chosenCustomerName = String.valueOf(customerTableComboBox.getValue());
            int chosenCustomerId = 0;
            try {
                chosenCustomerId = CustomerDAO.getCustomerId(chosenCustomerName);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            if (AppointmentDAO.getCustomerAppointment(chosenCustomerId).isEmpty()) {
                CustomerTable.setPlaceholder(new Label(chosenCustomerName + " has no appointments."));
                CustomerTable.refresh();

                for (int i =0; i < CustomerTable.getItems().size(); i++) {
                    CustomerTable.getItems().clear();
                    CustomerTable.setPlaceholder(new Label(chosenCustomerName + " has no appointments."));
                }
            } else {
                CustomerTable.setItems(AppointmentDAO.getCustomerAppointment(chosenCustomerId));
            }

                }

        );
        customerAppointmentId.setCellValueFactory(new PropertyValueFactory<>("appointmentId"));
        customerAppointmentTitle.setCellValueFactory(new PropertyValueFactory<>("appointmentTitle"));
        customerAppointmentDescription.setCellValueFactory(new PropertyValueFactory<>("appointmentDescription"));
        customerAppointmentContact.setCellValueFactory(new PropertyValueFactory<>("contactId"));
        customerAppointmentStart.setCellValueFactory(new PropertyValueFactory<>("appointmentStartTime"));
        customerAppointmentEnd.setCellValueFactory(new PropertyValueFactory<>("appointmentEndTime"));
        customerAppointmentType.setCellValueFactory(new PropertyValueFactory<>("appointmentType"));
        customerAppointmentCustomerId.setCellValueFactory(new PropertyValueFactory<>("customerId"));
        customerAppointmentUserId.setCellValueFactory(new PropertyValueFactory<>("userId"));

        CustomerTable.refresh();

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

        // Reports Type Table
        reportsType.setCellValueFactory(new PropertyValueFactory<>("type"));
        reportsMonth.setCellValueFactory(new PropertyValueFactory<>("month"));
        reportsTotal.setCellValueFactory(new PropertyValueFactory<>("total"));

        ReportsTable.refresh();
        ReportsTable.setItems(allReports);

    }

    /** This method controls the Contact table combo box. This includes setting the table for which
     * Contact has been chosen.
     * @param event Selection of a Contact in the combo box.
     * */
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

}
