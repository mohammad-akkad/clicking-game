/*
 Muhammed Akkad
 13060160209
 */
package ClickingGame;

import java.awt.Shape;

/**
 *
 * @author Muhammed
 */
public class namedShape {

    private String id;
    private Shape shape;

    public namedShape(String id, Shape shape) {
        this.id = id;
        this.shape = shape;
    }

    public String getID() {
        return id;
    }

    public Shape getShape() {
        return shape;
    }
}
