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
import javafx.scene.canvas.GraphicsContext;

import java.util.List;

/**
 * Class that extends Node in order to allow a node to have a reference to several other nodes so
 * that edges can be drawn between an instance of LinkedNode and its nodes. This class also overrides
 * the method drawNodeInfo from the class Node to include the drawing of these edges.
 */
public class LinkedNode extends Node{
    private List<Node> nodes;

    public LinkedNode(Point2D point, List<Node> nodes) {
        super(point);
        this.nodes = nodes;
    }

    @Override
    public void drawNodeInfo(Canvas canvas){
        super.drawNodeInfo(canvas);
        drawLinks(canvas);

    }

    /**
     * Draw an edge between two nodes.
     */
    private void drawLinks(Canvas canvas){
        for (Node node: nodes){
            GraphicsContext context = canvas.getGraphicsContext2D();
            Point2D p1 = getPoint();
            Point2D p2 = node.getPoint();
            Point2D direction = p2.subtract(p1).normalize();
            Point2D radius = direction.multiply(RADIUS);
            Point2D start = p1.add(radius);
            Point2D end = p2.subtract(radius);
            context.strokeLine(start.getX(), start.getY(), end.getX(), end.getY());
        }

    }

}
