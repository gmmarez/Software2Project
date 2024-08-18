package Controller;

import DAO.CountryDAO;
import DAO.CustomerDAO;
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

/** This is the controller in accordance to the EditCustomers FXML file. */
public class EditCustomersController implements Initializable {
    @FXML private TextField EditCustomerCustomerId;
    @FXML private TextField EditCustomerName;
    @FXML private TextField EditCustomerAddress;
    @FXML private TextField EditCustomerPostalCode;
    @FXML private TextField EditCustomerPhone;
    @FXML public ComboBox<Divisions> EditCustomerDivisionId;
    @FXML public ComboBox<Country> EditCustomerCountryId;

    Stage stage;
    Parent scene;

    /** This method is used when saving the edited Customer information. It will then save this new information
     * in the database.
     * @param event Save button
     * */
    @FXML
    void AddCustomersSave(ActionEvent event) {

        try {
            if (EditCustomerName.getText().isEmpty() || EditCustomerName.getText().isBlank()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setContentText("Missing Customer Name");
                alert.show();
            } else if (EditCustomerAddress.getText().isEmpty() || EditCustomerAddress.getText().isBlank()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setContentText("Missing Customer Address");
                alert.show();
            } else if (EditCustomerPostalCode.getText().isEmpty() || EditCustomerPostalCode.getText().isBlank()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setContentText("Missing Customer Postal Code");
                alert.show();
            } else if (EditCustomerPhone.getText().isEmpty() || EditCustomerPhone.getText().isBlank()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setContentText("Missing Customer Phone");
                alert.show();
            } else if (EditCustomerDivisionId.equals("Division")) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setContentText("Missing Division ID");
                alert.show();
            } else {

                int customerId = Integer.parseInt(EditCustomerCustomerId.getText());
                String customerName = EditCustomerName.getText();
                String customerAddress = EditCustomerAddress.getText();
                String customerPostalCode = EditCustomerPostalCode.getText();
                String customerPhone = EditCustomerPhone.getText();
                LocalDateTime createdDate = LocalDateTime.now();
                LocalDateTime lastUpdated = LocalDateTime.now();
                int divisionId = EditCustomerDivisionId.getValue().getDivisionId();

                CustomerDAO.updateCustomer(customerId, customerName, customerAddress, customerPostalCode, customerPhone, createdDate, lastUpdated, divisionId);
                System.out.println("Customer Updated");

                // Go back to Customers screen
                stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
                scene = FXMLLoader.load(getClass().getResource("../View/Customers.fxml"));
                stage.setScene(new Scene(scene));
                stage.show();

            }
        } catch (IOException e) {System.out.println(e);}
    }

    /** This method will direct the user back to the menu when used.
     * @param event Selection of the Back button
     * */
    @FXML
    private void EditCustomersBack(ActionEvent event) throws IOException {
        stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("../View/Customers.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();

    }

    /** This method will set the selected Customer information to be edited in their respective text fields.
     * @param selectedCustomer Selected Customer to edit.
     * */
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

    /** This is the method that will set the Divisions when the appropriate Country is selected from the
     * combo box.
     * @param event Selection of a Country from the respective combo box.
     * */
    public void EnableCustomersEditDivisions(ActionEvent event) throws SQLException {

        ObservableList<Divisions> filterEditDivisions = FXCollections.observableArrayList();
        EditCustomerDivisionId.setDisable(false);
        for (Divisions divisions: DivisionDAO.getAllDivisions()) {
            if (divisions.getCountryId()==EditCustomerCountryId.getValue().getCountryId()) {
                filterEditDivisions.add(divisions);
            }
        }

        EditCustomerDivisionId.setItems(filterEditDivisions);

    }

    /** This is the initialize method used for the Edit Customers screen. It also sets the Countries in the
     * combo box.
     * @param resourceBundle resourceBundle
     * @param url url
     * */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            EditCustomerCountryId.setItems(CountryDAO.getAllCountries());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
