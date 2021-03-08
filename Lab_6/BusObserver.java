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
import mketour.actors.Bus;
import mketour.actors.Car;

/**
 * Class that extends the behavior of the CarObserver Observer class. This class
 * adds the functionality of only allowing the parent class to display the challenge
 * and its progress once a bus is encountered by the main character.
 */
public class BusObserver extends CarObserver {
    private boolean isBusSeen;
    private Pane hiddenPane;

    public BusObserver(WordSearch wordSearch, Car car, Pane pane) {
        super(wordSearch, car, new Pane());
        this.hiddenPane = pane;
        isBusSeen = false;
    }

    @Override
    public void update(Taggable taggable) {
        if (isBusSeen){
            super.update(taggable);
        } else if (taggable instanceof Bus){
            isBusSeen = true;
            super.setSubPane(hiddenPane);
            super.showCompleteChallenge();
        }
    }
}
