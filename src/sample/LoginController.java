package sample;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

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
    }


    // Time Zone
    // ZoneId.getAvailableZoneIds().stream().sorted().forEach(System.out::println);
}
