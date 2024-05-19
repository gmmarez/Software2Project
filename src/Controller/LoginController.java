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
import java.time.ZoneId;
import java.util.Locale;
import java.util.Optional;
import java.util.ResourceBundle;

public class LoginController {

    @FXML
    public TextField ZoneIdTextBox;
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

    public void initialize(URL url, ResourceBundle rb) {
        try {
            Locale locale = Locale.getDefault();
            Locale.setDefault(locale);

            ZoneId zone = ZoneId.systemDefault();

            ZoneIdTextBox.setText(String.valueOf(zone));

            rb = ResourceBundle.getBundle("Languages.login", Locale.getDefault());
            UsernameTextBox.setText(rb.getString(""));
        }
    }
    @FXML
    private void LoginSubmit(ActionEvent event) throws IOException {

        // String username = UsernameTextBox.getText();
        //String password = PasswordTextBox.getText();
        //ResourceBundle rb = ResourceBundle.getBundle("Resources/Login", Locale.getDefault());

        //if (username.equals("") || password.equals("")) {
        //Alert alert = new Alert(Alert.AlertType.ERROR, "Either Username/Password is empty, please correct.");
        //alert.showAndWait();
           // return;
        //}


        // Successful goes to Main Menu
        stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("../View/MainMenu.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();
    }

    // Closes entire application
    @FXML
    private void LoginClose(ActionEvent event) {
        // Closes entire application
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "This will close the entire program, are you sure you want to continue?");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {

            System.exit(0);
        }
    }
}
