package Controller;

import DAO.AppointmentDAO;
import DAO.CustomerDAO;
import Main.JDBC;
import Model.Appointments;
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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
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

    // Go to the Add Customer.
    @FXML
    void CustomersAddCustomer(ActionEvent event) throws IOException {
        // Go to Add Customer screen
        stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("../View/AddCustomers.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();
    }

    // Grab current Customer information load it into Edit Customers.
    @FXML
    void CustomersEditCustomer(ActionEvent event) throws IOException, SQLException {

         Stage stage;
         Parent root;
         stage = (Stage) CustomersEditCustomer.getScene().getWindow();
         FXMLLoader loader = new FXMLLoader(getClass().getResource("../View/EditCustomers.fxml"));

         root = loader.load();
         EditCustomersController controller = loader.getController();
         Customers selectedCustomer = CustomersTable.getSelectionModel().getSelectedItem();

         if (selectedCustomer != null) {
         controller.setCustomer(selectedCustomer);

         Scene scene = new Scene(root);
         stage.setScene(scene);
         stage.show();

         } else {

             Alert alert = new Alert(Alert.AlertType.ERROR, "Please select a customer to edit.");
             alert.showAndWait();

         }
    }

    // Delete selected customer, delete any appointments that the customer may had.
    @FXML
    void CustomersDeleteCustomer(ActionEvent actionEvent) throws SQLException {
        try {
            int deleteCustomerId = CustomersTable.getSelectionModel().getSelectedItem().getCustomerId();
            String deleteCustomerName = CustomersTable.getSelectionModel().getSelectedItem().getCustomerName();

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure you want to delete Customer ID: " + deleteCustomerId + "  " + deleteCustomerName);
            Optional<ButtonType> confirm = alert.showAndWait();

            if (confirm.isPresent() && confirm.get() == ButtonType.OK) {

                AppointmentDAO.deleteCustomerAppointment(deleteCustomerId);
                CustomerDAO.deleteCustomer(deleteCustomerId);

                ObservableList<Customers> allCustomersList = CustomerDAO.getAllCustomers();
                CustomersTable.setItems(allCustomersList);

                Alert alert1 = new Alert(Alert.AlertType.INFORMATION, "Customer and all associated appointments deleted.");
                alert1.showAndWait();

                }
        } catch (Exception e) {e.printStackTrace();}
    }

    // Go to Main Menu
    @FXML
    void CustomersBack(ActionEvent event) throws IOException {
        // Go back to Main Menu
        stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("../View/MainMenu.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();

    }

}
