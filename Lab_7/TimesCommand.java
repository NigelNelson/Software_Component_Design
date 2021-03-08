/*
 * Course:     SE 2811
 * Term:       Winter 2020-21
 * Assignment: Lab 7: Calculator Commands
 * Author: Nigel Nelson
 * Date: 2/7/21
 */
package calc;

/**
 * Class that is responsible for executing the multiplication function of a calculator,
 * but also extends the CalculatorCommand class, so that these actions can be
 * undone as well as redone.
 */
public class TimesCommand extends CalculatorCommand {
    private String previousDisplay;
    private String previousAccumulator;

    public TimesCommand(Calculator c) {
        super(c);
    }

    public void execute() {
        previousDisplay = calculator.getDisplay();
        previousAccumulator = calculator.getAccumulator();
        calculator.times();
    }

    public void unexecute() {
        calculator.setDisplay(previousDisplay);
        calculator.setAccumulator(previousAccumulator);
        calculator.setReadyForNewNumber(true);
    }
}
