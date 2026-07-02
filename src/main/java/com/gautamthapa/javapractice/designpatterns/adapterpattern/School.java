package com.gautamthapa.javapractice.designpatterns.adapterpattern;

public class School {
    public static void main(String[] args) {
        Pen p = new PenAdapter();
        AssignmentWork assignmentWork = new AssignmentWork();
        assignmentWork.setPen(p);
        assignmentWork.writeAssignment("I'm bit tired to write an Assignment");
    }
}
