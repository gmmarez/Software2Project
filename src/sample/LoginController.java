package sample;

import javafx.event.ActionEvent;
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
    public TextField UsernameTextBox;
    public TextField PasswordTextBox;
    public Button LoginSubmit;
    public Button LoginClose;
    Stage stage;
    Parent scene;

    public void UsernameTextBox(ActionEvent actionEvent) {
    }

    public void PasswordTextBox(ActionEvent actionEvent) {
    }

    public void LoginSubmit(ActionEvent event) throws IOException {
        // Successful goes to Main Menu
        stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("sample.MainMenu.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();
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
