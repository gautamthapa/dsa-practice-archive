package com.gautamthapa.javapractice.designpatterns.copositepattern;

public class CompositeTest {
    public static void main(String[] args) {
        Component hd = new Leaf(4000, "HDD");
        Component mouse = new Leaf(400, "Mouse");
        Component monitor = new Leaf(5000, "Monitor");
        Component ram = new Leaf(2000, "RAM");
        Component cpu = new Leaf(5500, "CPU");

        Composite ph = new Composite("Peri");
        Composite cabinet = new Composite("Cabinet");
        Composite mb = new Composite("MB");
        Composite computer = new Composite("Computer");

        mb.addComponent(cpu);
        mb.addComponent(ram);

        ph.addComponent(mouse);
        ph.addComponent(monitor);
        cabinet.addComponent(hd);
        cabinet.addComponent(mb);

        computer.addComponent(ph);
        computer.addComponent(cabinet);

        computer.showPrice();
    }
}
