package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;

public class EditCustomersController {
    @FXML
    private TextField EditCustomerCustomerId;

    @FXML
    private TextField EditCustomerName;

    @FXML
    private TextField EditCustomerAddress;

    @FXML
    private TextField EditCustomerPostalCode;

    @FXML
    private TextField EditCustomerPhone;

    @FXML
    private TextField EditCustomerDivisionId;

    @FXML
    private TextField EditCustomerCountryId;

    @FXML
    private Button EditCustomersSave;

    @FXML
    private Button EditCustomersBack;

    Stage stage;
    Parent scene;

    @FXML
    void EditCustomerCustomerId(ActionEvent event) {
    }

    @FXML
    void EditCustomerName(ActionEvent event) {
    }

    @FXML
    void EditCustomerAddress(ActionEvent event) {
    }

    @FXML
    void EditCustomerPostalCode(ActionEvent event) {
    }

    @FXML
    void EditCustomerPhone(ActionEvent event) {
    }

    @FXML
    void EditCustomerDivisionId(ActionEvent event) {
    }

    @FXML
    void EditCustomerCountryId(ActionEvent event) {
    }

    @FXML
    void AddCustomersSave(ActionEvent event) {
    }

    @FXML
    void EditCustomersBack(ActionEvent event) throws IOException {
        // Go back to Customers screen
        stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("../View/Customers.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();
    }
}
