/*
 * Course:     SE 2811
 * Term:       Winter 2020-21
 * Assignment: Lab 7: Calculator Commands
 * Author: Nigel Nelson
 * Date: 2/7/21
 */
package calc;

/**
 * Class that is responsible for executing the enter function of a calculator,
 * but also extends the CalculatorCommand class, so that these actions can be
 * undone.
 */
public class EnterCommand extends CalculatorCommand {
    private String previousAccumulator;

    public EnterCommand(Calculator c) {
        super(c);
    }

    public void execute() {
        previousAccumulator = calculator.getAccumulator();
        calculator.enter();
    }

    public void unexecute() {
        calculator.setAccumulator(previousAccumulator);
        calculator.setReadyForNewNumber(true);
    }
}
