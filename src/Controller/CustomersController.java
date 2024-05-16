package Controller;

import DAO.AppointmentDAO;
import Model.Appointments;
import Model.Customers;
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

public class CustomersController {
    @FXML private TableView <Customers> CustomersTable;
    @FXML private TableColumn<?, ?> CustomersId;
    @FXML private TableColumn<?, ?> CustomersName;
    @FXML private TableColumn<?, ?> CustomersAddress;
    @FXML private TableColumn<?, ?> CustomersZip;
    @FXML private TableColumn<?, ?> CustomersPhone;
    @FXML private TableColumn<?, ?> CustomersDivisionId;
    @FXML private Button CustomersAddCustomer;
    @FXML private Button CustomersEditCustomer;
    @FXML private Button CustomersDeleteCustomer;
    @FXML private Button CustomersBack;

    Stage stage;
    Parent scene;
/*
    public void initialize() throws SQLException {

        ObservableList<Appointments> allCustomersList = CustomerDAO.getAllCustomers();

        CustomersId.setCellValueFactory(new PropertyValueFactory<>("customerId"));
        CustomersName.setCellValueFactory(new PropertyValueFactory<>("customerName"));
        CustomersAddress.setCellValueFactory(new PropertyValueFactory<>("customerAddress"));
        CustomersZip.setCellValueFactory(new PropertyValueFactory<>("customerZip"));
        CustomersPhone.setCellValueFactory(new PropertyValueFactory<>("customerPhone"));
        CustomersDivisionId.setCellValueFactory(new PropertyValueFactory<>("customerDivisionId"));

        CustomersTable.setItems(allAppointmentsList);
    }
    */
    @FXML
    void CustomersAddCustomer(ActionEvent event) throws IOException {
        // Go to Add Customer screen
        stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("../View/AddCustomers.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();
    }

    @FXML
    void CustomersEditCustomer(ActionEvent event) throws IOException {
        // Go to Edit Customer Screen
        stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("../View/EditCustomers.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();

    }

    @FXML
    void CustomersDeleteCustomer(ActionEvent actionEvent) {
    }

    @FXML
    void CustomersBack(ActionEvent event) throws IOException {
        // Go back to Main Menu
        stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("../View/MainMenu.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();

    }
}
