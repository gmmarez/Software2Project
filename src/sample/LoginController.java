package sample;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;

import java.util.Optional;

public class LoginController {
    public TextField UsernameTextBox;
    public TextField PasswordTextBox;
    public Button LoginSubmit;
    public Button LoginClose;

    public void UsernameTextBox(ActionEvent actionEvent) {
    }

    public void PasswordTextBox(ActionEvent actionEvent) {
    }

    public void LoginSubmit(ActionEvent actionEvent) {
        // Successful goes to Main Menu
        // Fail goes to Error Message
    }

    public void LoginClose(ActionEvent actionEvent) {
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
