package Controller;

import DAO.CountryDAO;
import DAO.DivisionDAO;
import Model.Country;
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
    public ComboBox<Divisions> EditCustomerDivisionId;
    @FXML
    public ComboBox<Country> EditCustomerCountryId;

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

    public void setCustomer(Customers selectedCustomer) throws SQLException {

        this.EditCustomerCustomerId.setText(Integer.toString(selectedCustomer.getCustomerId()));
        this.EditCustomerName.setText(selectedCustomer.getCustomerName());
        this.EditCustomerAddress.setText(selectedCustomer.getCustomerAddress());
        this.EditCustomerPostalCode.setText(selectedCustomer.getCustomerPostalCode());
        this.EditCustomerPhone.setText(selectedCustomer.getCustomerPhone());

        for (Divisions division: DivisionDAO.getAllDivisions()) {
            if (division.getDivisionId()== selectedCustomer.getDivisionId()) {
                this.EditCustomerDivisionId.setValue(division);

            }
        }

        for (Country country: CountryDAO.getAllCountries()) {
            if (country.getCountryId()== this.EditCustomerDivisionId.getValue().getCountryId()) {
                this.EditCustomerCountryId.setValue(country);

            }
        }

        // this.EditCustomerCountryId.setValue(getCountryId(getDivisionId));

    }

    public void EnableCustomersEditDivisions(ActionEvent event) throws SQLException {

        ObservableList<Divisions> filterEditDivisions = FXCollections.observableArrayList();
        EditCustomerDivisionId.setDisable(false);
        for (Divisions divisions: DivisionDAO.getAllDivisions()) {
            if (divisions.getCountryId()==EditCustomerCountryId.getValue().getCountryId()) {
                filterEditDivisions.add(divisions);
            }
        }
        // AddCustomerDivisionId.setValue(null);
        EditCustomerDivisionId.setItems(filterEditDivisions);

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
