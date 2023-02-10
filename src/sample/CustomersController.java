package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class CustomersController {
    public Button CustomersAddCustomer;
    public Button CustomersEditCustomer;
    public Button CustomersDeleteCustomer;
    public Button CustomersBack;
    Stage stage;
    Parent scene;

    public void CustomersAddCustomer(ActionEvent actionEvent) {
    }

    public void CustomersEditCustomer(ActionEvent actionEvent) {
    }

    public void CustomersDeleteCustomer(ActionEvent actionEvent) {
    }

    public void CustomersBack(ActionEvent event) throws IOException {
        // Go back to Main Menu

        stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("sample.MainMenu.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();
    }
}
