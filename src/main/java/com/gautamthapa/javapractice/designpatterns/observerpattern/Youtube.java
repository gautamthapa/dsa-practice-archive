package com.gautamthapa.javapractice.designpatterns.observerpattern;

public class Youtube {
    public static void main(String[] args) {
        Channel channel=new Channel();
        Subscriber s1=new Subscriber("Akshay");
        Subscriber s2=new Subscriber("Sonam");
        Subscriber s3=new Subscriber("Hari");
        Subscriber s4=new Subscriber("Gopi");
        Subscriber s5=new Subscriber("Praveen");

        channel.subscribe(s1);
        channel.subscribe(s2);
        channel.subscribe(s3);
        channel.subscribe(s4);
        channel.subscribe(s5);

        channel.unSubscribe(s1);

        s1.subscribeChannel(channel);
        s2.subscribeChannel(channel);
        s3.subscribeChannel(channel);
        s4.subscribeChannel(channel);
        s5.subscribeChannel(channel);

        channel.upload("Java Tutorial 1");
    }
}
