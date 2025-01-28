package lk.ijse;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

/**
 * Author: vishmee
 * Date: 1/28/25
 * Time: 9:53 AM
 * Description:
 */
public class Launcher extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        try {
            Scene scene1 = new Scene(FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/view/Server.fxml"))));
            stage.setScene(scene1);
            stage.setTitle("Server Page");
            stage.centerOnScreen();
            stage.show();
        } catch (IOException e) {
            System.err.println("Error loading FXML: " + e.getMessage());
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        launch(args);

    }
}
