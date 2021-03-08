/*
 * Course:     SE 2811
 * Term:       Winter 2020-21
 * Assignment: Lab 7: Calculator Commands
 * Author: Nigel Nelson
 * Date: 2/7/21
 */
package calc;

/**
 * Class that is responsible for clearing an instance of a calculator,
 * but also extends the CalculatorCommand class, so that these actions can be
 * undone.
 */
public class ClearCommand extends CalculatorCommand {
    private String previousDisplay;
    private String previousAccumulator;
    private String previousMemory;

    public ClearCommand(Calculator c) {
        super(c);
    }

    public void execute() {
        previousDisplay = calculator.getDisplay();
        previousAccumulator = calculator.getAccumulator();
        previousMemory = calculator.getMemory();
        calculator.clear();
    }

    public void unexecute() {
        calculator.setDisplay(previousDisplay);
        calculator.setAccumulator(previousAccumulator);
        calculator.setMemory(previousMemory);
        calculator.setReadyForNewNumber(true);
    }
}
