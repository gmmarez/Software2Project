package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;

public class AddCustomersController {

    @FXML
    private TextField AddCustomerCustomerId;

    @FXML
    private TextField AddCustomerName;

    @FXML
    private TextField AddCustomerAddress;

    @FXML
    private TextField AddCustomerPostalCode;

    @FXML
    private TextField AddCustomerPhone;

    @FXML
    private TextField AddCustomerDivisionId;

    @FXML
    private TextField AddCustomerCountryId;

    @FXML
    private Button AddCustomersBack;

    @FXML
    private Button AddCustomersAdd;

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
        // Will grab what is in text boxes and create a new customer
    }

    @FXML
    void AddCustomerCustomerId(ActionEvent event) {
    }

    @FXML
    void AddCustomerName(ActionEvent event) {
    }

    @FXML
    void AddCustomerAddress(ActionEvent event) {
    }

    @FXML
    void AddCustomerPostalCode(ActionEvent event) {
    }

    @FXML
    void AddCustomerPhone(ActionEvent event) {
    }

    @FXML
    void AddCustomerDivisionId(ActionEvent event) {
    }

    @FXML
    void AddCustomerCountryId(ActionEvent event) {
    }
}
