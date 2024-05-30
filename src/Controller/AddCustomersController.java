package Controller;

import DAO.CountryDAO;
import DAO.CustomerDAO;
import DAO.DivisionDAO;
import Model.Country;
import Model.Divisions;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ResourceBundle;

public class AddCustomersController implements Initializable {
    @FXML private TextField AddCustomerCustomerId;

    @FXML private TextField AddCustomerName;

    @FXML private TextField AddCustomerAddress;

    @FXML private TextField AddCustomerPostalCode;

    @FXML private TextField AddCustomerPhone;
    @FXML public TextField AddCustomerCreateDate;
    @FXML public TextField AddCustomerCreatedBy;
    @FXML public TextField AddCustomerLastUpdate;
    @FXML public TextField AddCustomerLastUpdatedBy;
    @FXML public ComboBox <Divisions> AddCustomerDivisionId;
    @FXML public ComboBox <Country>AddCustomerCountryId;

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
/*
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
            }  else if (AddCustomerDivisionId.isBlank()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setContentText("Missing Division ID");
                alert.show();
            } else {
                String customerName = AddCustomerName.getText();
                String customerAddress = AddCustomerAddress.getText();
                String customerPostalCode = AddCustomerPostalCode.getText();
                String customerPhone = AddCustomerPhone.getText();
                LocalDateTime createdDate = LocalDateTime.now();
                LocalDateTime lastUpdated = LocalDateTime.now();
                // int divisionId = AddCustomerDivisionId;

                CustomerDAO.addCustomer(customerName, customerAddress, customerPostalCode, customerPhone, createdDate, lastUpdated, divisionId);
                System.out.println("Customer Added");
            }
        } catch (SQLException exception) {System.out.println(exception);}
*/
    }


    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            AddCustomerCountryId.setItems(CountryDAO.getAllCountries());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void EnableDivisions(ActionEvent event) throws SQLException {
        ObservableList <Divisions> filterDivisions = FXCollections.observableArrayList();
        AddCustomerDivisionId.setDisable(false);
        for (Divisions div: DivisionDAO.getAllDivisions()) {
            if (div.getCountryId()==AddCustomerCountryId.getValue().getCountryId()) {
                filterDivisions.add(div);
            }
        }
        // AddCustomerDivisionId.setValue(null);
        AddCustomerDivisionId.setItems(filterDivisions);
    }
}
