package Controller;

import DAO.CustomerDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class AddCustomersController {
    @FXML private TextField AddCustomerCustomerId;

    @FXML private TextField AddCustomerName;

    @FXML private TextField AddCustomerAddress;

    @FXML private TextField AddCustomerPostalCode;

    @FXML private TextField AddCustomerPhone;
    @FXML public TextField AddCustomerCreateDate;
    @FXML public TextField AddCustomerCreatedBy;
    @FXML public TextField AddCustomerLastUpdate;
    @FXML public TextField AddCustomerLastUpdatedBy;
    @FXML public ComboBox AddCustomerDivisionId;
    @FXML public ComboBox AddCustomerCountryId;

    @FXML private Button AddCustomersBack;

    @FXML private Button AddCustomersAdd;

    Stage stage;
    Parent scene;

    @FXML
    void AddCustomersBack(ActionEvent event) throws IOException {
        // Go back to Customers screen
        stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("../View/Customers.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();
    }

    @FXML
    void AddCustomersAdd(ActionEvent event) {
        try {
            if (AddCustomerName.getText().isEmpty() || AddCustomerName.getText().isBlank()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setContentText("Missing Customer Name");
                alert.show();
            } else if (AddCustomerAddress.getText().isEmpty() || AddCustomerAddress.getText().isBlank()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setContentText("Missing Customer Address");
                alert.show();
            } else if (AddCustomerPostalCode.getText().isEmpty() || AddCustomerPostalCode.getText().isBlank()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setContentText("Missing Customer Postal Code");
                alert.show();
            } else if (AddCustomerPhone.getText().isEmpty() || AddCustomerPhone.getText().isBlank()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setContentText("Missing Customer Phone");
                alert.show();
            }  else {
                else {
                    String customerName = AddCustomerName.getText();
                    String customerAddress = AddCustomerAddress.getText();
                    String customerPostalCode = AddCustomerPostalCode.getText();
                    String customerPhone = AddCustomerPhone.getText();

                    LocalDateTime createdDate = LocalDateTime.now();
                    LocalDateTime lastUpdated = LocalDateTime.now();
                    int divisionId = divId.getDivisionID();
                    CustomerDAO.addCustomer(customerName, customerAddress, customerPostalCode, customerPhone, createdDate, lastUpdated, divisionId);
                    System.out.println("Customer Added");
                    backToCustomers(actionEvent);
                }
            }

        } catch (SQLException exception) {
            System.out.println(exception);
        }
    }
}
