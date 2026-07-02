package com.gautamthapa.javapractice.designpatterns.adapterpattern;

import com.gautamthapa.javapractice.designpatterns.adapterpattern.friend.PilotPen;

public class PenAdapter implements Pen {

    private PilotPen pen = new PilotPen();

    @Override
    public void write(String str) {
        pen.mark(str);
    }
}
