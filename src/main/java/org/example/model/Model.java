package org.example.model;

import org.example.observer.EventManager;
import org.example.observer.EventType;
import org.example.observer.ModelListenner;

import java.awt.Graphics2D;
import java.awt.geom.Point2D;
import java.util.Observable;

public class Model extends ModelListenner {
    private MyShape currentShape;
    private EventManager eventManager;

    //public Model() {}

    private static Model model;

    public synchronized static Model init(){
        if (model == null) model = new Model();
        return model;
    }

    public void setMyShape(MyShape myShape) {
        this.currentShape = myShape;
        eventManager.myNotify();
    }

    public void changeShape(Point2D x, Point2D y) {
        currentShape.setFrame(x, y);
    }

    public void draw(Graphics2D g) {
        currentShape.draw(g);
    }
}
