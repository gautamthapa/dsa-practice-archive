package com.gautamthapa.javapractice.designpatterns.observerpattern;

public interface Subject {
    void subscribe(Subscriber subscriber);

    void unSubscribe(Subscriber subscriber);

    void notifySubscriber();

    void upload(String title);
}
