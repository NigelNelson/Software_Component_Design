/*
 * Course: SE2811 - 031
 * Winter 2020
 * Lab 4 - Completing Lab 3
 * Name: Nigel Nelson, Alan Van Dyke
 * Created: 01/11/21
 */
package garden_simulator;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import java.util.ArrayList;

/**
 * Class that acts as a controller for the bee_simulator. Responsible for initializing the displayed garden,
 * as well as handling user input.
 */
public class GardenController {

    private FlowerBed flowerBed;

    @FXML
    private ImageView randomBeeKey;
    @FXML
    private ImageView linearBeeKey;
    @FXML
    private ImageView flowerKey;
    @FXML
    private ImageView drainingKey;

    @FXML
    private Label randomBeeLabel;
    private static final String RANDOM_BEE_DESC = "This bee moves in a random direction each tick with no target";
    @FXML
    private Label linearBeeLabel;
    private static final String LINEAR_BEE_DESC = "This bee chooses a target flower and moves towards it," +
            " choosing again after it reaches its goal";
    @FXML
    private Label flowerLabel;
    private static final String FLOWER_DESC = "This flower gives energy when colliding with a bee";
    @FXML
    private Label drainingLabel;
    private static final String DRAINING_DESC = "This flower drains energy when colliding with a bee";
    //private ImageView flowerKey;

    @FXML
    private Pane theGarden;                 // capture the pane we are drawing on from JavaFX

    /**
     * Method that initializes a FlowerBed for the UI that is displayed, as well as
     * display Keys for the images displayed.
     */
    @FXML
    public void initialize() {              // executed after scene is loaded but before any methods
        flowerBed = new FlowerBed(new ArrayList<>(), new ArrayList<>());
        // note the label has a Z index of 2 so it is drawn above the panel, otherwise it may be displayed "under" the panel and not be visible
        theGarden.setStyle("-fx-background-color: forestgreen;");
        randomBeeKey.setImage(new Image("file:bee-3.jpg"));
        linearBeeKey.setImage(new Image("file:bee-1.jpg"));
        flowerKey.setImage(new Image("file:aster.jpg"));
        drainingKey.setImage(new Image("file:wilting-flower.png"));
        randomBeeLabel.setText(RANDOM_BEE_DESC);
        linearBeeLabel.setText(LINEAR_BEE_DESC);
        flowerLabel.setText(FLOWER_DESC);
        drainingLabel.setText(DRAINING_DESC);
        theGarden.setFocusTraversable(true); // ensure garden pane will receive keypresses

        flowerBed.populate();  //Generates bees and flowers and loads them into lists within FlowerBed. Draw after this
        flowerBed.updateGarden(theGarden);
    }


    @FXML
    public void onKeyPressed(KeyEvent keyEvent) {
        if (flowerBed.getBees().size() <= 0) {
            errorNoBees();
        } else if (keyEvent.getCode() == KeyCode.RIGHT) {
            flowerBed.incrementTime();
            flowerBed.checkCollisions();
            if (flowerBed.getBees().size() > 0) {
                flowerBed.updateGarden(theGarden);
            }
        } else if (keyEvent.getCode() == KeyCode.UP) {
            flowerBed.incrementTime();
            flowerBed.checkCollisions();
            if (flowerBed.getBees().size() > 0) {
                flowerBed.updateGarden(theGarden);
            }
        }
    }

    /**
     * Error encountered due to all bees being dead
     */
    private void errorNoBees() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("All the bees have perished, the simulation can no longer be ran.");
        alert.showAndWait();
    }
}
