package org.example.view;

import org.example.controller.Controller;
import org.example.model.Model;
import org.example.observer.EventManager;
import org.example.observer.EventType;
import org.example.observer.ModelListenner;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JPanel;


public class MyPanel extends JPanel {
    private final Controller controller;
    private EventManager eventManager;
    private static MyPanel myPanel;
    public static synchronized MyPanel init(){
        try {
            return myPanel;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public MyPanel(Controller controller) {
        this.controller = controller;
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent arg0) {
                controller.getPointOne(arg0.getPoint());
            }
        });
        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent arg0) {
                controller.getPointTwo(arg0.getPoint());
            }
        });
        eventManager.subscribe(EventType.MODEL_CHANGGE, Model.init());
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        controller.draw(g2);
    }

}
