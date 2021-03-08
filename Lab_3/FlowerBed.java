/*
 * Course: SE2811 - 031
 * Winter 2020
 * Lab 4 - Completing Lab 3
 * Name: Nigel Nelson, Alan Van Dyke
 * Created: 01/11/21
 */
package garden_simulator;

import javafx.scene.layout.Pane;
import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

/**
 * Class that outlines the behavior of a FlowerBed. Specifies functionality such as incrementing time,
 * populating the UI with Flowers and Bees, updating the UI, and checking for collisions between Flowers
 * and Bees.
 */
public class FlowerBed {
    private static final int START_NUM_LINE_BEES = 3;
    private static final int START_NUM_RAND_BEES = 3;
    private static final int START_NUM_FLOWERS = 8;


    private List<Bee> bees;
    private List<Flower> flowers;

    public FlowerBed(List<Bee> bees, List<Flower> flowers) {
        this.bees = bees;
        this.flowers = flowers;
    }

    public List<Flower> getFlowers(){
        return flowers;
    }
    public List<Bee> getBees(){
        return bees;
    }

    public void incrementTime(){
        for(Bee bee: bees){
            bee.tick();
        }
    }

    /**
     * Method that checks for collisions between Bees and Bees,
     * as well as Bees and Flowers
     */
    public void checkCollisions(){

        HashMap<Point, Flower> flowerHashMap = new HashMap<>();
        for (Flower flower: flowers){
            flowerHashMap.put(flower.getPoint(), flower);
        }

        HashMap<Point, Bee> beeHashMap = new HashMap<>();

        for(Bee bee: bees){
            if (beeHashMap.containsKey(bee.point)){
                bee.incrementEnergy(-100);
                beeHashMap.get(bee.point).incrementEnergy(-100);
            }
            else {
                beeHashMap.put(bee.point, bee);
            }
            if (flowerHashMap.containsKey(bee.point)){
                bee.collide(flowerHashMap.get(bee.point).exchangeEnergy());
                flowerHashMap.get(bee.point).toggleIsDraining();
            }
        }
    }

    /**
     * Method that creates random locations of Bees and Flowers and adds them to their
     * respective lists.
     */
    public void populate(){
        for(int i = 0; i<START_NUM_FLOWERS; ++i){
            Random rand = new Random();
            int startX = rand.nextInt(575);
            int startY = rand.nextInt(575);
            Point startingPoint = new Point(startX, startY);
            boolean startingState = rand.nextBoolean();

            Flower currentFlower = new Flower(startingPoint, startingState);
            flowers.add(currentFlower);
        }
        for(int i = 0; i<START_NUM_LINE_BEES; ++i){
            Random rand = new Random();
            int startX = rand.nextInt(575);
            int startY = rand.nextInt(575);
            Point startingPoint = new Point(startX, startY);

            Bee currentBee = new LinearBee(startingPoint, this);
            bees.add(currentBee);
        }
        for(int i = 0; i<START_NUM_RAND_BEES; ++i){
            Random rand = new Random();
            int startX = rand.nextInt(575);
            int startY = rand.nextInt(575);
            Point startingPoint = new Point(startX, startY);

            Bee currentBee = new RandomBee(startingPoint, this);
            bees.add(currentBee);
        }
    }

    /**
     * Method that updates where Bees and Flowers are displayed.
     * @param pane The pane that is being displayed to the user
     */
    public void updateGarden(Pane pane){
        pane.getChildren().clear();
        for (Flower flower: flowers){
            flower.displayFlower(pane);
        }
        List<Bee> updatedBees = new ArrayList<>();
        for (Bee bee: bees){
            if (bee.getEnergyPoints() > 0){
                updatedBees.add(bee);
                bee.displayBee(pane);
            }
        }
        bees = updatedBees;
    }
}
