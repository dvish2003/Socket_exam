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
 * Time: 10:15 AM
 * Description:
 */
public class Launcher_1 extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage stage) throws Exception {
        try {
            Scene scene2 = new Scene(FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/view/Client.fxml"))));
            stage.setScene(scene2);
            stage.setTitle("Client Page");
            stage.centerOnScreen();
            stage.show();
        } catch (IOException e) {
            System.err.println("Error loading FXML: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
