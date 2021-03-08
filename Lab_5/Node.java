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

/**
 * Class that is responsible for representing a neural network node. It contains a point
 * and draws an oval on a canvas to represent that stored point.
 */
public class Node {
    private Point2D point;

    public static final double RADIUS = 25;

    public Node(Point2D point) {
        this.point = point;
        System.out.println(point.getX() + " " + point.getY());
    }

    /**
     * Draw a node centered on the given location.
     * @param canvas canvas on which to draw this.
     */
    public void drawNodeInfo(Canvas canvas){
        canvas.getGraphicsContext2D().strokeOval(point.getX()-RADIUS, point.getY()-RADIUS,2*RADIUS,2*RADIUS);
    }

    public Point2D getPoint() {
        return point;
    }
}
