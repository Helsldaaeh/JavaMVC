package org.example.observer;

import org.example.model.Model;
import org.example.view.MyPanel;

public class ModelListenner implements EventListenner {
    public void update(){
        MyPanel.init().repaint();
    }
}
