/*
 * Course:     SE 2811
 * Term:       Winter 2020-21
 * Assignment: Lab 7: Calculator Commands
 * Author: Nigel Nelson
 * Date: 2/7/21
 */
package calc;

/**
 * Abstract class that is responsible for outlining for outlining the behavior
 * of calculator command. This is so that an instance of the calculator can
 * be saved prior to executing the operation, so that this operation can be
 * un-executed.
 */
public abstract class CalculatorCommand {
    protected Calculator calculator;

    public CalculatorCommand(Calculator c) {
        calculator = c;
    }

    /**
     * Perform operation on calculator.
     */
    public abstract void execute();

    /**
     * Restore calculator to the state before performing this operation.
     */
    public abstract void unexecute();
}
