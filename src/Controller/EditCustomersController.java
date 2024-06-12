package Controller;

import DAO.CountryDAO;
import DAO.DivisionDAO;
import Model.Customers;
import Model.Divisions;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class EditCustomersController implements Initializable {
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
    public ComboBox EditCustomerDivisionId;
    @FXML
    public ComboBox EditCustomerCountryId;

    @FXML
    private Button EditCustomersSave;

    @FXML
    private Button EditCustomersBack;

    Stage stage;
    Parent scene;

    @FXML
    void AddCustomersSave(ActionEvent event) {
    }

    @FXML
    private void EditCustomersBack(ActionEvent event) throws IOException {
        // Go back to Customers screen
        stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("../View/Customers.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();

    }

    public void setCustomer(Customers selectedCustomer) {

        this.EditCustomerCustomerId.setText(Integer.toString(selectedCustomer.getCustomerId()));
        this.EditCustomerName.setText(selectedCustomer.getCustomerName());
        this.EditCustomerAddress.setText(selectedCustomer.getCustomerAddress());
        this.EditCustomerPostalCode.setText(selectedCustomer.getCustomerPostalCode());
        this.EditCustomerPhone.setText(selectedCustomer.getCustomerPhone());
        // this.EditCustomerDivisionId.setItems(Customers.getFilteredDivisions(selectedCustomer.getCountry()));
        // this.EditCustomerCountryId.setItems(getCountryId(getDivisionId));

    }

    public void EnableCustomersEditDivisions(ActionEvent event) throws SQLException {
        ObservableList<Divisions> filterDivisions = FXCollections.observableArrayList();
        EditCustomerDivisionId.setDisable(false);
        for (Divisions div: DivisionDAO.getAllDivisions()) {
            if (div==EditCustomerCountryId.getValue()) {
                filterDivisions.add(div);
            }
        }
        // AddCustomerDivisionId.setValue(null);
        EditCustomerDivisionId.setItems(filterDivisions);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            EditCustomerCountryId.setItems(CountryDAO.getAllCountries());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
