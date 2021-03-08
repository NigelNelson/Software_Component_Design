/*
 * Course:     SE 2811
 * Term:       Winter 2020-21
 * Assignment: Lab 7: Calculator Commands
 * Author: Nigel Nelson
 * Date: 2/7/21
 */
package calc;

/**
 * Class that is responsible for executing the subtract function of a calculator,
 * but also extends the CalculatorCommand class, so that these actions can be
 * undone as well as redone.
 */
public class MinusCommand extends CalculatorCommand {
    private String previousDisplay;
    private String previousAccumulator;

    public MinusCommand(Calculator c) {
        super(c);
    }

    public void execute() {
        previousDisplay = calculator.getDisplay();
        previousAccumulator = calculator.getAccumulator();
        calculator.minus();
    }

    public void unexecute() {
        calculator.setDisplay(previousDisplay);
        calculator.setAccumulator(previousAccumulator);
        calculator.setReadyForNewNumber(true);
    }
}
