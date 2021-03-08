/*
 * Course: SE2811 - 031
 * Winter 2020
 * Lab 4 - Completing Lab 3
 * Name: Nigel Nelson, Alan Van Dyke
 * Created: 01/11/21
 */
package garden_simulator;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Class that loads the bee_simulator and displays it
 */
public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("garden_simulator.fxml"));
        primaryStage.setTitle("Bee Runner 2049");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
