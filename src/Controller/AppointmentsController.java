package Controller;

import DAO.AppointmentDAO;
import Model.Appointments;
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
import java.security.spec.ECField;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.ResourceBundle;

public class AppointmentsController  implements Initializable {
    public RadioButton allAppointmentsTB;
    public RadioButton monthlyAppointmentsTB;
    public RadioButton weeklyAppointmentsTB;
    @FXML private TableView <Appointments> AppointmentsTable;
    @FXML private TableColumn<Appointments, Integer> AppointmentsIdCol;
    @FXML private TableColumn<Appointments, String> AppointmentsTitleCol;
    @FXML private TableColumn<Appointments, String> AppointmentsDescriptionCol;
    @FXML private TableColumn<Appointments, String> AppointmentsTypeCol;
    @FXML private TableColumn<Appointments, LocalDateTime> AppointmentsStartTimeCol;
    @FXML private TableColumn<Appointments, LocalDateTime> AppointmentsEndTimeCol;
    @FXML private TableColumn<Appointments, Integer> AppointmentsCustomerIdCol;
    @FXML private TableColumn<Appointments, Integer> AppointmentsUserIdCol;
    @FXML private TableColumn<Appointments, Integer> AppointmentsContactIdCol;
    @FXML private TableColumn<Appointments, String> AppointmentsLocationCol;
    @FXML private Button AppointmentsAddAppointment;
    @FXML private Button AppointmentsEditAppointment;
    @FXML private Button AppointmentsDeleteAppointment;
    @FXML private Button AppointmentsBack;

    Stage stage;
    Parent scene;

    public void initialize(URL url, ResourceBundle resourceBundle) {
try {

        AppointmentsTable.setItems(AppointmentDAO.getAllAppointments());

        AppointmentsIdCol.setCellValueFactory(new PropertyValueFactory<>("appointmentId"));
        AppointmentsTitleCol.setCellValueFactory(new PropertyValueFactory<>("appointmentTitle"));
        AppointmentsDescriptionCol.setCellValueFactory(new PropertyValueFactory<>("appointmentDescription"));
        AppointmentsLocationCol.setCellValueFactory(new PropertyValueFactory<>("appointmentLocation"));
        AppointmentsTypeCol.setCellValueFactory(new PropertyValueFactory<>("appointmentType"));
        AppointmentsStartTimeCol.setCellValueFactory(new PropertyValueFactory<>("appointmentStartTime"));
        AppointmentsEndTimeCol.setCellValueFactory(new PropertyValueFactory<>("appointmentEndTime"));
        AppointmentsCustomerIdCol.setCellValueFactory(new PropertyValueFactory<>("customerId"));
        AppointmentsContactIdCol.setCellValueFactory(new PropertyValueFactory<>("contactId"));
        AppointmentsUserIdCol.setCellValueFactory(new PropertyValueFactory<>("userId"));

    } catch(Exception e){
    System.out.println(e);
    }

        }

    @FXML
    void AppointmentsAddAppointment(ActionEvent event) throws IOException {
        // Go to Add Appointment Screen
        stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("../View/AddAppointments.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();
    }

    @FXML
    void AppointmentsEditAppointment(ActionEvent event) throws IOException {
        // Go to Edit Appointment Screen
        stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("../View/EditAppointments.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();
    }

    @FXML
    void AppointmentsDeleteAppointment(ActionEvent actionEvent) {
        try {

            int deleteAppointmentId = AppointmentsTable.getSelectionModel().getSelectedItem().getAppointmentId();
            String deleteAppointmentType = AppointmentsTable.getSelectionModel().getSelectedItem().getAppointmentType();
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure you want to delete Appointment ID: " + deleteAppointmentId + " with Appointment Type: " + deleteAppointmentType);
            Optional<ButtonType> confirmation = alert.showAndWait();
            if (confirmation.isPresent() && confirmation.get() == ButtonType.OK) {
                AppointmentDAO.deleteAppointment(deleteAppointmentId);

                ObservableList<Appointments> allAppointmentsList = AppointmentDAO.getAllAppointments();
                AppointmentsTable.setItems(allAppointmentsList);
            }
        } catch (Exception e) {e.printStackTrace();}
    }

    @FXML
    void AppointmentsBack(ActionEvent event) throws IOException {
        // Go back to Main Menu
        stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("../View/MainMenu.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();

    }

    public void allAppointmentsTB(ActionEvent event) throws SQLException {
        AppointmentsTable.setItems(AppointmentDAO.getAllAppointments());
    }

    public void monthlyAppointmentsTB(ActionEvent event) throws SQLException {
        AppointmentsTable.setItems(AppointmentDAO.getMonthlyAppointments());
    }

    public void weeklyAppointmentsTB(ActionEvent event) {
        AppointmentsTable.setItems(AppointmentDAO.getWeeklyAppointments());
    }
}
