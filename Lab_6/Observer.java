/*
 * Course:     SE 2811
 * Term:       Winter 2020-21
 * Assignment: Lab 5: Tourists
 * Author:     Nigel Nelson
 */
package mketour.observerpattern;

import mketour.Taggable;

/**
 * Interface that is responsible for outlining the one method that
 * all Observers must implement, update().
 */
public interface Observer {
    public void update(Taggable taggable);
}
