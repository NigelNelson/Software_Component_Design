/*
 * Course:     SE 2811
 * Term:       Winter 2020-21
 * Assignment: Lab 5: Tourists
 * Author:     Nigel Nelson
 */
package mketour.observerpattern;

import mketour.Taggable;
import java.util.ArrayList;
import java.util.List;

/**
 * Abstract class that outlines the behavior of a subject class,
 * which maintains a list of Observers by attaching and detaching
 * observers, and also notifies each of those Observers by calling
 * .notify on each one of them.
 */
public abstract class Subject {

    private List<Observer> observers;
    public Subject() {
        observers = new ArrayList<>();
    }
    public void attach(Observer observer){
        observers.add(observer);
    }
    public void dettach(Observer observer){
        observers.remove(observer);
    }
    public void notifyObservers(Taggable taggable){
        for (Observer observer: observers){
            observer.update(taggable);
        }
    }

}
