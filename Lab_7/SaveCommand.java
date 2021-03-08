/*
 * Course:     SE 2811
 * Term:       Winter 2020-21
 * Assignment: Lab 7: Calculator Commands
 * Author: Nigel Nelson
 * Date: 2/7/21
 */
package calc;

/**
 * Class that is responsible for executing the save function of a calculator,
 * but also extends the CalculatorCommand class, so that these actions can be
 * undone as well as redone.
 */
public class SaveCommand extends CalculatorCommand {
    private String previousMemory;
    private String previousAccumulator;

    public SaveCommand(Calculator c) {
        super(c);
    }

    public void execute() {
        previousMemory = calculator.getMemory();
        previousAccumulator = calculator.getAccumulator();
        calculator.saveToMemory();
    }

    public void unexecute() {
        calculator.setMemory(previousMemory);
        calculator.setAccumulator(previousAccumulator);
        calculator.setReadyForNewNumber(true);
    }
}
