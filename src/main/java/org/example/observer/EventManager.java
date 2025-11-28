package org.example.observer;

import java.util.ArrayList;

public class EventManager {
    private static EventManager eventManager;
    private ArrayList<EventListenner> listenners = new ArrayList<EventListenner>();


    public EventManager() {}

    public synchronized static EventManager init(){
        if (eventManager == null) eventManager = new EventManager();
        return eventManager;
    }

    public void subscribe(EventType eventType, EventListenner listenner){
        listenners.add(listenner);
    }
    public void unsubscribe(EventType eventType, EventListenner listenner){
        if (listenners.contains(listenner)) listenners.remove(listenner);
    }

    public void myNotify(){
        for (EventListenner listenner : listenners) { listenner.update(); }
    }
}
