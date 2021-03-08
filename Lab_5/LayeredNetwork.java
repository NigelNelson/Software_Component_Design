package networks;


/*
 * Course:     SE 2811
 * Term:       Winter 2020-21
 * Assignment: Lab 5: Decorators
 * Author: Nigel Nelson
 * Date: 1/25/21
 */
import javafx.scene.canvas.Canvas;

/**
 * Abstract class that acts as the decorator class for the Network class. Has the abstract method createLayer
 * which overrides the network class's implementation. The core of the decoration pattern is displayed in the use of
 * drawLayer(), which acts no different than the Network class's implementation and ensures each wrapped object is
 * called on to draw its Layer of Nodes.
 */
public abstract class LayeredNetwork extends Network {
    protected Network subNetwork;

    public LayeredNetwork(Network subNetwork) {
        this.subNetwork = subNetwork;
    }

    @Override
    public void drawLayer(Canvas canvas){
        super.drawLayer(canvas);
        subNetwork.drawLayer(canvas);
    }

    @Override
    public abstract void createLayer(int numNodes, Canvas canvas, double x);
}