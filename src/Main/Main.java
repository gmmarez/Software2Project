package Main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/** This is the Main file in which we use to run the entire application. */
public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("../View/Login.fxml"));
        primaryStage.setTitle("SoftwareProject2");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }


    public static void main(String[] args) {
        // Test French Location
        // Locale.setDefault(new Locale("fr"));

        JDBC.openConnection();

        // JDBC.makeConnection();
        launch(args);

        JDBC.closeConnection();
    }
}
