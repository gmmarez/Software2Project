package Controller;

import DAO.UserDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.time.ZoneId;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.Optional;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    @FXML
    private TextField UsernameTextBox;
    @FXML
    private TextField PasswordTextBox;
    @FXML
    private Button LoginSubmit;
    @FXML
    private Button LoginClose;
    @FXML
    private TextField ZoneIdTextBox;

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
            UsernameTextBox.setText(rb.getString("username"));
            PasswordTextBox.setText(rb.getString("password"));
            LoginSubmit.setText(rb.getString("submit"));
            LoginClose.setText(rb.getString("close"));

        } catch (MissingResourceException e) {
            System.out.println("Resource file missing: " + e);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @FXML
    private void LoginSubmit(ActionEvent event) throws IOException {

        try {

            // Still need to input write file for tacking logins

            String username = UsernameTextBox.getText();
            String password = PasswordTextBox.getText();
            int userId = UserDAO.validateUser(username, password);
            System.out.println(userId);
            ResourceBundle rb = ResourceBundle.getBundle("Resources/Login", Locale.getDefault());

            if (userId > 0) {
                // Successful goes to Main Menu
                stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
                scene = FXMLLoader.load(getClass().getResource("../View/MainMenu.fxml"));
                stage.setScene(new Scene(scene));
                stage.show();
                // Log successful login attempt

            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle(rb.getString("Error"));
                alert.setContentText(rb.getString("Incorrect"));
                alert.show();
                // Log incorrect login attempt
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }




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
