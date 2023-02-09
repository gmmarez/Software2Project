package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import java.io.IOException;

public class MainMenuController implements initializable {
    @FXML
    private Button MainMenuCustomers;

    @FXML
    private Button MainMenuAppointments;

    @FXML
    private Button MainMenuRecords;

    @FXML
    private Button MainMenuLogout;

    Stage stage;
    Parent scene;

    @FXML
    void MainMenuCustomers(ActionEvent actionEvent) throws IOException {
        // Goes to Customers screen

        stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("sample.Customers.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();
    }

    @FXML
    void MainMenuAppointments(ActionEvent actionEvent) throws IOException {
        // Goes to Appointments screen

        stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("sample.Appointments.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();
    }

    @FXML
    void MainMenuRecords(ActionEvent actionEvent) throws IOException {
        // Goes to Records screen

        stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("sample.Records.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();
    }

    @FXML
    void MainMenuLogout(ActionEvent actionEvent) throws IOException {
        // Goes back to Login screen

        stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("sample.Login.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();
    }
}
