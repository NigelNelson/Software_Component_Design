/*
 * Course:     SE 2811
 * Term:       Winter 2020-21
 * Assignment: Lab 5: Decorators
 * Author: Nigel Nelson
 * Date: 1/25/21
 */
package networks;

import javafx.geometry.Point2D;
import javafx.scene.canvas.Canvas;

import java.util.ArrayList;
import java.util.List;

/**
 * Class that acts as a concrete implementation of LayeredNetwork, which is responsible for
 * drawing a fully connected network layer.
 */
public class FullyConnectedLayer extends LayeredNetwork{
    public FullyConnectedLayer(Network subNetwork) {
        super(subNetwork);
    }

    @Override
    public void createLayer(int numNodes, Canvas canvas, double x) {
        double incrementY = (canvas.getHeight())/(numNodes+1);
        Point2D pointA = new Point2D(x,incrementY);
        List<Node> nestedLayer = new ArrayList<>();
        for (int i = 0; i<numNodes; i++){
            nestedLayer.add(new LinkedNode(pointA.add( 0, incrementY*i), subNetwork.getNodes()));
        }
        this.nodes = nestedLayer;
    }
}
