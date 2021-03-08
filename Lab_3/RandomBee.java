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
import java.awt.*;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Class that outlines the behavior of a RandomBee, which is a subclass of Bee. This Bee
 * type moves about the garden in a completely random fashion.
 */
public class RandomBee extends Bee{

    public RandomBee(Point point, FlowerBed flowerBed) {
        super(point, flowerBed);
        beeImage = new ImageView(new Image("file:bee-3.jpg"));
        beeImage.setPreserveRatio(true);    // ensure ratio preserved when scaling the bee
        beeImage.setFitWidth(50.0);
    }

    @Override
    public void move() {
        int randomX;
        int randomY;
        boolean xIsOutOfBounds = true;
        boolean yIsOutOfBounds = true;
        do {
            randomX = ThreadLocalRandom.current().nextInt(-20, 20);
            if (randomX + point.getX() > 550 || randomX + point.getX() < 0){
                xIsOutOfBounds = true;
            } else {
                xIsOutOfBounds = false;
            }
        } while (xIsOutOfBounds);

        do {
            randomY = ThreadLocalRandom.current().nextInt(-20, 20);
            if (randomY + point.getY() > 550 || randomY + point.getY() < 0){
                yIsOutOfBounds = true;
            } else {
                yIsOutOfBounds = false;
            }
        } while (yIsOutOfBounds);

        point.translate(randomX, randomY);

    }

    @Override
    public void collide(int energyPoints) {
        incrementEnergy(energyPoints);
    }

}
