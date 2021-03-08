/*
 * Course:     SE 2811
 * Term:       Winter 2020-21
 * Assignment: Lab 5: Decorators
 * Author: Dr. Yoder and Nigel Nelson
 * Date: 1/25/21
 */
package networks;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("simpleCanvas.fxml"));
        primaryStage.setTitle("Neural Network Visualizer");
        primaryStage.setScene(new Scene(root, 850, 650));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
