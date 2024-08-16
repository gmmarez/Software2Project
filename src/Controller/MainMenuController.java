package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/** This is the controller in accordance to the application Main Menu FXML file. */
public class MainMenuController implements Initializable {
    @FXML private Button MainMenuCustomers;
    @FXML private Button MainMenuAppointments;
    @FXML private Button MainMenuReports;
    @FXML private Button MainMenuLogout;

    Stage stage;
    Parent scene;

    /** This method will direct the user to the Customers menu screen.
     * @param event Selection of the Customers button.
     * */
    @FXML
    void MainMenuCustomers(ActionEvent event) throws IOException {
        stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("../View/Customers.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();
    }

    /** This method will direct the user to the Appointments menu screen.
     * @param event Selection of the Appointments button.
     * */
    @FXML
    void MainMenuAppointments(ActionEvent event) throws IOException {
        stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("../View/Appointments.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();
    }

    /** This method will direct the user to the Reports screen.
     * @param event Selection of the Reports button.
     * */
    @FXML
    void MainMenuReports(ActionEvent event) throws IOException {
        stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("../View/Reports.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();

    }

    /** LAMBDA EXPRESSION USAGE
     * This method will log the user and send them back to the Login Screen. The lambda expression is used to prompt
     * an alert to the user about the choice they are making by selected the Logout button.
     * @param event Selection of the Logout button
     * */
    @FXML
    void MainMenuLogout(ActionEvent event) throws IOException {

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "This will log you out of the application, are you sure you want to continue?");
        alert.showAndWait().ifPresent(response -> {
            if (response == ButtonType.OK) {
                stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
                try {
                    scene = FXMLLoader.load(getClass().getResource("../View/Login.fxml"));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                stage.setScene(new Scene(scene));
                stage.show();
            }
        });
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }

}
