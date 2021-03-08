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
import java.awt.geom.Point2D;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Class that outlines the behavior of a Linear Bee, which is a subclass of the
 * Bee class. This Bee type chooses a Flower and moves towards it linearly.
 */
public class LinearBee extends Bee{
    private Flower flower;



    public LinearBee(Point point, FlowerBed flowerBed) {
        super(point, flowerBed);
        chooseFlower();
        beeImage = new ImageView(new Image("file:bee-1.jpg"));
        beeImage.setPreserveRatio(true);    // ensure ratio preserved when scaling the bee
        beeImage.setFitWidth(50.0);

    }

    @Override
    public void move() {
        Point2D flowerPoint = flower.getPoint();
        double distance = point.distance(flowerPoint);

        if (distance > 10){

            double translation = 10/distance;
            double xTranslation = (1 - translation) * point.getX() + translation * flowerPoint.getX();
            double yTranslation = (1 - translation) * point.getY() + translation * flowerPoint.getY();
            point.setLocation(xTranslation, yTranslation);
        } else {
            point.setLocation(flowerPoint);
        }
    }

    @Override
    public void collide(int energyPoints) {
        chooseFlower();
        incrementEnergy(energyPoints);
    }

    /**
     * Method that chooses a new Flower as a target to move
     * towards
     */
    public void chooseFlower(){
        List<Flower> flowers = flowerBed.getFlowers();
        int numFlowers = flowers.size();
        int randomNum = ThreadLocalRandom.current().nextInt(0, numFlowers);
        flower = flowers.get(randomNum);
    }


}
