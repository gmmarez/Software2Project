package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.Optional;

public class LoginController {
    @FXML
    private TextField UsernameTextBox;

    @FXML
    private TextField PasswordTextBox;

    @FXML
    private Button LoginSubmit;

    @FXML
    private Button LoginClose;

    Stage stage;
    Parent scene;

    @FXML
    void UsernameTextBox(ActionEvent event) {
    }

    @FXML
    void PasswordTextBox(ActionEvent event) {
    }

    @FXML
    void LoginSubmit(ActionEvent event) throws IOException {
        // Successful goes to Main Menu
        stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("../View/MainMenu.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();
    }

    @FXML
    void LoginClose(ActionEvent event) {
        // Closes entire application
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "This will close the entire program, are you sure you want to continue?");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {

            System.exit(0);
        }
    }

    // Time Zone
    // ZoneId.getAvailableZoneIds().stream().sorted().forEach(System.out::println);
}
