/*
 * Course:     SE 2811
 * Term:       Winter 2020-21
 * Assignment: Lab 5: Tourists
 * Author:     Nigel Nelson
 */
package mketour.observerpattern;

import javafx.scene.layout.Pane;
import mketour.Taggable;
import mketour.WordSearch;
import mketour.actors.Car;

/**
 * Class that is responsible for implementing the Observer behavior. Specifically,
 * this class observes a specific car that it is assigned to. In addition,
 * it holds an instance to a WordSearch class, and when update() is called,
 * it responds by passing the license plate of the car that it holds a reference to,
 * into the WordSearch method checkPlate().
 */
public class CarObserver implements Observer {

    private Pane pane;
    private WordSearch wordSearch;
    private Car car;

    public CarObserver(WordSearch wordSearch, Car car, Pane pane){
        this.car = car;
        this.pane = pane;
        this.wordSearch = wordSearch;
        showCompleteChallenge();
    }

    public void showCompleteChallenge(){
        wordSearch.displayChallenge(pane);
        wordSearch.displayCompleteness(pane);
    }

    @Override
    public void update(Taggable taggable) {
        if (taggable instanceof Car) {
            wordSearch.checkPlate(car.getPlate().toCharArray(), pane);
        }
    }

    protected void setSubPane(Pane subPane) {
        this.pane = subPane;
    }
}
