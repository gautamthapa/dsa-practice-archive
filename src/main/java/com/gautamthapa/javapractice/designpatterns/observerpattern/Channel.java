package com.gautamthapa.javapractice.designpatterns.observerpattern;

import java.util.ArrayList;
import java.util.List;

public class Channel implements Subject {

    private List<Subscriber> subscribers = new ArrayList<>();
     String title;

    @Override
    public void subscribe(Subscriber subscriber) {
        subscribers.add(subscriber);
    }

    @Override
    public void unSubscribe(Subscriber subscriber) {
        subscribers.remove(subscriber);
    }

    @Override
    public void notifySubscriber() {
        for (Subscriber subscriber : subscribers) {
            subscriber.update();
        }
    }

    @Override
    public void upload(String title) {
        this.title = title;
        notifySubscriber();
    }
}
