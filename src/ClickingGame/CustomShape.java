/*
 Muhammed Akkad
 13060160209
 */
package ClickingGame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.geom.PathIterator;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RectangularShape;
import static java.lang.Integer.parseInt;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

/**
 *
 * @author Muhammed
 */
class CustomShape extends JPanel {

    List<namedShape> shapes = new ArrayList<>();
    private String[] objects;
    private Client server;
    private String clickedObjectID;
    private String width;
    private String length;

    /**
     *
     * @param objects
     * @param server
     * @param width
     * @param length
     */
    public CustomShape(String[] objects, Client server, String width, String length) {
        this.objects = objects;
        this.server = server;
        this.width = width;
        this.length = length;

        for (int i = 0; i < objects.length; i++) {
            String[] object = objects[i].split(" ");
            if (object[1].equals("rectangle")) {
                shapes.add(new namedShape(object[0], new Rectangle2D.Double(parseInt(object[2]), parseInt(object[3]), 50, 100)));
            } else if (object[1].equals("square")) {
                shapes.add(new namedShape(object[0], new Rectangle2D.Double(parseInt(object[2]), parseInt(object[3]), 100, 100)));
            } else {
                shapes.add(new namedShape(object[0], new Ellipse2D.Double(parseInt(object[2]), parseInt(object[3]), 75, 100)));
            }
        }

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                super.mouseClicked(me);
                for (namedShape s : shapes) {
                    if (s.getShape().contains(me.getPoint())) {
                        clickedObjectID = s.getID();
                    }
                }
                if (clickedObjectID != null) {
                    server.myOutputMessages.add("click:" + clickedObjectID + ":" + System.currentTimeMillis());
                }

            }
        });
    }

    /**
     *
     * @param grphcs
     */
    @Override
    protected void paintComponent(Graphics grphcs) {
        super.paintComponent(grphcs);
        Graphics2D g2d = (Graphics2D) grphcs;
        int i = 0;
        Color shapeColor;
        for (namedShape s : shapes) {
            String[] object = objects[i].split(" ");
            switch (object[4]) {
                case "red":
                    shapeColor = Color.red;
                    break;
                case "green":
                    shapeColor = Color.GREEN;
                    break;
                case "black":
                    shapeColor = Color.black;
                    break;
                case "white":
                    shapeColor = Color.white;
                    break;
                case "yellow":
                    shapeColor = Color.yellow;
                    break;
                case "blue":
                    shapeColor = Color.blue;
                    break;
                default:
                    shapeColor = Color.white;
            }
            g2d.setPaint(shapeColor);

            g2d.fill(s.getShape());
            i++;
        }

    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(parseInt(width), parseInt(length));
    }
}
