/*
 * Course: SE2811 - 031
 * Winter 2020
 * Lab 4 - Completing Lab 3
 * Name: Nigel Nelson, Alan Van Dyke
 * Created: 01/11/21
 */
package garden_simulator;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import java.awt.*;

/**
 * Class that outlines the behavior of a Flower. Specifies functionality such as how states
 * are changed, how energy is exchanged, and how FLowers are displayed.
 */
public class Flower {
    private boolean isDraining;
    private Point point;
    private ImageView flowerImage = new ImageView(new Image("file:aster.jpg"));

    public Flower(Point point, boolean isDraining) {
        this.isDraining = isDraining;
        this.point = point;
    }

    /**
     * Method that either gives out energy or takes in energy
     * @return the amount of energy given/taken
     */
    protected int exchangeEnergy(){
        int points;
        if (isDraining){
            points = -50;
        } else{
            points = 100;
        }
        return points;
    }

    /**
     * Changing whether or not a Flower gives or takes energy,
     * which changes each time a Bee visits.
     */
    protected void toggleIsDraining(){
        if (isDraining){
            isDraining = false;
            flowerImage.setImage(new Image("file:aster.jpg"));
        } else {
            isDraining = true;
            flowerImage.setImage(new Image("file:wilting-flower.png"));
        }
    }

    public void displayFlower(Pane pane){
        flowerImage.setPreserveRatio(true);    // ensure ratio preserved when scaling the bee
        flowerImage.setFitWidth(50.0);
        flowerImage.setX(getPoint().getX());
        flowerImage.setY(getPoint().getY());
        pane.getChildren().add(flowerImage);
    }

    public Point getPoint() {
        return point;
    }
}