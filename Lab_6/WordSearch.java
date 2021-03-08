package mketour;

import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

public class WordSearch{
    private char[] wordTarget;
    private char[] currentWord;
    private boolean isWordComplete;

    public WordSearch(char[] wordTarget){
        this.wordTarget = wordTarget;
        fillCurrentWord(wordTarget);
    }

    private void addLetters(char[] plate){
        for (char c: plate){
            for (int i = 0; i<wordTarget.length; i++){
                if (wordTarget[i] == c){
                    currentWord[i] = wordTarget[i];
                }
            }
        }
    }

    private void checkWord(){
        boolean isWordFinished = true;
        for (int i = 0; i <  wordTarget.length; i++){
            if (wordTarget[i] != currentWord[i]){
                isWordFinished = false;
            }
        }
        isWordComplete = isWordFinished;
    }

    public void displayCompleteness(Pane pane){
        if (isWordComplete){
            pane.getChildren().add(new Label(new String(wordTarget) + " CHALLENGE COMPLETED"));
        }
        pane.getChildren().add(new Label(""));
    }

    public void checkPlate(char[] plate, Pane pane) {
        if (!isWordComplete) {
            addLetters(plate);
            displayChallenge(pane);
            checkWord();
            displayCompleteness(pane);
        }
    }

    private void fillCurrentWord(char[] wordTarget){
        currentWord = new char[wordTarget.length];
        for (int i = 0; i < wordTarget.length; i++){
            currentWord[i] = '*';
        }
    }

    public void displayChallenge(Pane pane){
        pane.getChildren().clear();
        pane.getChildren().add(new Label("Challenge: Find all letters in " + new String(wordTarget)));
        pane.getChildren().add(new Label("Goal: " + new String(wordTarget)));
        pane.getChildren().add(new Label("Found: " + new String(currentWord)));
    }
}

