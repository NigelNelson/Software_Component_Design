/*
 * Course:     SE 2811
 * Term:       Winter 2020-21
 * Assignment: Lab 5: Tourists
 * Author:     Nigel Nelson
 */
package mketour.observerpattern;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import mketour.CityMap;
import mketour.Taggable;

/**
 * Class that implements the Observer behavior. This particular observer is responsible
 * for observing museums. Due to the fact that the current implementation has each Museum
 * coming with its own implementation of the taggedBy() method, and the fact that these observers
 * are only attached to Museums, this observer displays an art piece as soon as update() is
 * called.
 */
public class ArtObserver implements Observer{
    private static Image art = new Image(CityMap.class.getResource("img/wood-gatherer.png").toString());
    private Pane pane;
    private boolean isDisplayed;

    public ArtObserver(Pane pane){
        this.pane = pane;
        isDisplayed = false;
        displayChallenge();
    }

    @Override
    public void update(Taggable taggable) {
        displayArt();
        isDisplayed = true;
    }

    private void displayArt(){
        if (!isDisplayed) {
            isDisplayed = true;
            displayChallenge();
            addArt();
            addSpace();
        }
    }

    private void addArt(){
        ImageView imageView = new ImageView(art);
        imageView.setFitHeight(art.getHeight() / 3);
        imageView.setFitWidth(art.getWidth() / 3);
        pane.getChildren().add(imageView);
    }

    private void displayChallenge(){
        pane.getChildren().clear();
        pane.getChildren().add(new Label("Challenge: Find art"));
        if (isDisplayed){
            pane.getChildren().add(new Label("Artistic works found:"));
        } else{
            addSpace();
        }
    }

    private void addSpace(){
        pane.getChildren().add(new Label(""));
    }
}
