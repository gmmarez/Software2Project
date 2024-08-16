package Main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/** This is the Main file in which we use to run the entire application. */
public class Main extends Application {

    /** This method loads the Login screen to begin the application.
     * @param primaryStage
     **/
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("../View/Login.fxml"));
        primaryStage.setTitle("SoftwareProject2");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }


    /** This method will open and close the connection to the database when needed.
     * */
    public static void main(String[] args) {
        // Test French Location
        // Locale.setDefault(new Locale("fr"));

        JDBC.openConnection();

        // JDBC.makeConnection();
        launch(args);

        JDBC.closeConnection();
    }

}
