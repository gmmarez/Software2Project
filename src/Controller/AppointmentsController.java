package Controller;

import DAO.AppointmentDAO;
import Model.Appointments;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class AppointmentsController {
    @FXML private TableView <Appointments> AppointmentsTable;
    @FXML private TableColumn<?, ?> AppointmentsId;
    @FXML private TableColumn<?, ?> AppointmentsTitle;
    @FXML private TableColumn<?, ?> AppointmentsDescription;
    @FXML private TableColumn<?, ?> AppointmentsType;
    @FXML private TableColumn<?, ?> AppointmentsStartTime;
    @FXML private TableColumn<?, ?> AppointmentsEndTime;
    @FXML private TableColumn<?, ?> AppointmentsCustomerId;
    @FXML private TableColumn<?, ?> AppointmentsUserId;
    @FXML private TableColumn<?, ?> AppointmentsContactId;
    @FXML private TableColumn<?, ?> AppointmentsLocation;
    @FXML private Button AppointmentsAddAppointment;
    @FXML private Button AppointmentsEditAppointment;
    @FXML private Button AppointmentsDeleteAppointment;
    @FXML private Button AppointmentsBack;

    Stage stage;
    Parent scene;

    public void initialize() throws SQLException {

        ObservableList<Appointments> allAppointmentsList = AppointmentDAO.getAllAppointments();

        AppointmentsId.setCellValueFactory(new PropertyValueFactory<>("appointmentId"));
        AppointmentsTitle.setCellValueFactory(new PropertyValueFactory<>("appointmentTitle"));
        AppointmentsDescription.setCellValueFactory(new PropertyValueFactory<>("appointmentDescription"));
        AppointmentsLocation.setCellValueFactory(new PropertyValueFactory<>("appointmentLocation"));
        AppointmentsType.setCellValueFactory(new PropertyValueFactory<>("appointmentType"));
        AppointmentsStartTime.setCellValueFactory(new PropertyValueFactory<>("appointmentStartTime"));
        AppointmentsEndTime.setCellValueFactory(new PropertyValueFactory<>("appointmentEndTime"));
        AppointmentsCustomerId.setCellValueFactory(new PropertyValueFactory<>("customerId"));
        AppointmentsContactId.setCellValueFactory(new PropertyValueFactory<>("contactId"));
        AppointmentsUserId.setCellValueFactory(new PropertyValueFactory<>("userId"));

        AppointmentsTable.setItems(allAppointmentsList);
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
    }

    @FXML
    void AppointmentsBack(ActionEvent event) throws IOException {
        // Go back to Main Menu
        stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("../View/MainMenu.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();

    }
}
