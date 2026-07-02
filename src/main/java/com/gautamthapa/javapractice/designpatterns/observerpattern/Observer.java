package com.gautamthapa.javapractice.designpatterns.observerpattern;

public interface Observer {
    void update();

    void subscribeChannel(Channel ch);
}
