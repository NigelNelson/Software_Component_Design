/*
* Course: SE2811 - 031
* Winter 2020
* Lab 4 - Completing Lab 3
* Name: Nigel Nelson, Alan Van Dyke
* Created: 01/11/21
*/
package garden_simulator;

import javafx.scene.control.ProgressBar;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import java.awt.*;

/**
 * Abstract Class that outlines the base behavior of Bees. Such as how their energyPoints
 * change to reflect their health, as well how Bees are displayed.
 */
public abstract class Bee {

    protected int energyPoints;
    protected Point point;
    protected FlowerBed flowerBed;
    protected ImageView beeImage;
    protected Text numericalEnergy;
    protected ProgressBar energyLevel;

    public Bee(Point point, FlowerBed flowerBed) {
        this.point = point;
        this.flowerBed = flowerBed;
        energyPoints = 1000;

        numericalEnergy = new Text(energyPoints + "");
        numericalEnergy.setFill(Color.BLACK);
        numericalEnergy.setLayoutX(getPoint().getX() + 15);
        numericalEnergy.setLayoutY(getPoint().getY() + 58);

        energyLevel = new ProgressBar((float)energyPoints/1000);
        energyLevel.setLayoutX(getPoint().getX());
        energyLevel.setLayoutY(getPoint().getY() + 45);
        energyLevel.setMaxWidth(50);
    }

    public void incrementEnergy(int energy){
        energyPoints += energy;
        if (energyPoints > 1000){
            energyPoints = 1000;
        }
    }

    public abstract void move();

    public abstract void collide(int energyPoints);

    /**
     * Method that represents time passing
     */
    public void tick(){
        energyPoints += -5;
        move();
    }

    public Point getPoint() {
        return point;
    }

    public void displayBee(Pane pane){
        beeImage.setX(getPoint().getX());
        beeImage.setY(getPoint().getY());

        numericalEnergy.setText(energyPoints + "");
        numericalEnergy.setLayoutX(getPoint().getX() + 15);
        numericalEnergy.setLayoutY(getPoint().getY() + 58);

        energyLevel.setLayoutX(getPoint().getX());
        energyLevel.setLayoutY(getPoint().getY() + 45);
        energyLevel.setProgress((float)energyPoints/1000);
        pane.getChildren().addAll(beeImage, energyLevel, numericalEnergy);
    }

    public int getEnergyPoints() {
        return energyPoints;
    }
}
