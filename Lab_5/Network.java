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
 * This class is responsible for outlining the base behavior of a network. It is responsible for
 * creating an identity layer of nodes and drawing the nodes contained in that layer.
 */
public class Network {
    protected List<Node> nodes;

    public void drawLayer(Canvas canvas){
        for (Node node: nodes){
            node.drawNodeInfo(canvas);
        }
     }

    public void createLayer(int numNodes, Canvas canvas, double x){
        double incrementY = (canvas.getHeight())/(numNodes+1);
        Point2D pointA = new Point2D(x,incrementY);
        List<Node> identityLayer = new ArrayList<>();
        for (int i = 0; i<numNodes; i++){
            identityLayer.add(new Node(pointA.add(0, incrementY*i)));
        }
        this.nodes = identityLayer;
    }

    public List<Node> getNodes() {
        return nodes;
    }
}
