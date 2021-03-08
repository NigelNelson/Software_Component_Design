/*
 * Course:     SE 2811
 * Term:       Winter 2020-21
 * Assignment: Lab 7: Calculator Commands
 * Author: Nigel Nelson
 * Date: 2/7/21
 */
package calc;

/**
 * Class that is responsible for appending digits to an instance of calculator,
 * but also extends the CalculatorCommand class, so that these actions can be
 * undone.
 */
public class AppendDigitCommand extends CalculatorCommand {
    private char aChar;
    private boolean previousNewNumber;
    private String previousDisplay;

    public AppendDigitCommand(Calculator c, char aChar) {
        super(c);
        this.aChar = aChar;
    }

    public void execute() {
        previousDisplay = calculator.getDisplay();
        previousNewNumber = calculator.getNewNumber();
        calculator.appendDigit(aChar);
    }

    public void unexecute() {
        calculator.setDisplay(previousDisplay);
        calculator.setReadyForNewNumber(previousNewNumber);
    }
}
