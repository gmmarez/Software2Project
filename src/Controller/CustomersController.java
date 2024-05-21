package Controller;

import DAO.CustomerDAO;
import Model.Appointments;
import Model.Customers;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class CustomersController implements Initializable {
    @FXML private TableView <Customers> CustomersTable;
    @FXML private TableColumn<?, ?> CustomersIdCol;
    @FXML private TableColumn<?, ?> CustomersNameCol;
    @FXML private TableColumn<?, ?> CustomersAddressCol;
    @FXML private TableColumn<?, ?> CustomersPostalCodeCol;
    @FXML private TableColumn<?, ?> CustomersPhoneCol;
    @FXML private TableColumn<?, ?> CustomersDivisionIdCol;
    @FXML private Button CustomersAddCustomer;
    @FXML private Button CustomersEditCustomer;
    @FXML private Button CustomersDeleteCustomer;
    @FXML private Button CustomersBack;

    Stage stage;
    Parent scene;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            ObservableList<Customers> allCustomersList = CustomerDAO.getAllCustomers();

            CustomersIdCol.setCellValueFactory(new PropertyValueFactory<>("customerId"));
            CustomersNameCol.setCellValueFactory(new PropertyValueFactory<>("customerName"));
            CustomersAddressCol.setCellValueFactory(new PropertyValueFactory<>("customerAddress"));
            CustomersPostalCodeCol.setCellValueFactory(new PropertyValueFactory<>("customerPostalCode"));
            CustomersPhoneCol.setCellValueFactory(new PropertyValueFactory<>("customerPhone"));
            CustomersDivisionIdCol.setCellValueFactory(new PropertyValueFactory<>("divisionId"));

            CustomersTable.setItems(allCustomersList);
        } catch(Exception e) {
            System.out.println(e);
        }
    }

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
