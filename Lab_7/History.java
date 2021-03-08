/*
 * Course:     SE 2811
 * Term:       Winter 2020-21
 * Assignment: Lab 7: Calculator Commands
 * Author: Dr. Hasker
 * Date: 2/7/21
 */
package calc;

import java.util.Stack;

/**
 * Class that is responsible for keeping a list of CalculatorCommands,
 * so that executed operations can be undone after being executed. In,
 * addition, this class allows executed operations to be redone as well.
 */
public class History {
    // done_cmds:   those commands that are currently executed
    // undone_cmds: commands which were undone
    protected Stack<CalculatorCommand> done_cmds = new Stack<>(), undone_cmds = new Stack<>();

    // returns null if no command to undo, the command otherwise
    public CalculatorCommand nextToUndo() {
        if (done_cmds.isEmpty())
            return null;
        else
            return done_cmds.peek();
    }

    // returns null if no command to redo, the command otherwise
    public CalculatorCommand nextToRedo() {
        if (undone_cmds.isEmpty())
            return null;
        else
            return undone_cmds.peek();
    }

    // execute command and store it on the done commands list;
    //   old undone commands are permanently deleted
    public void doCommand(CalculatorCommand new_cmd) {
        new_cmd.execute();
        undone_cmds.clear();
        done_cmds.push(new_cmd);
    }

    // undoes last executed command; precondition: at least one command to undo
    public void undo() {
        CalculatorCommand to_undo = done_cmds.pop();
        to_undo.unexecute();
        undone_cmds.push(to_undo);
    }

    // redoes last undone command; precondition: at least one command to redo
    public void redo() {
        CalculatorCommand todo = undone_cmds.pop();
        todo.execute();
        done_cmds.push(todo);
    }
}
