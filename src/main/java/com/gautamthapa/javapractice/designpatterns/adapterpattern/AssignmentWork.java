package com.gautamthapa.javapractice.designpatterns.adapterpattern;

public class AssignmentWork {
    private Pen pen;

    public Pen getPen() {
        return pen;
    }

    public void setPen(Pen pen) {
        this.pen = pen;
    }

    public void writeAssignment(String str) {
        pen.write(str);
    }
}
