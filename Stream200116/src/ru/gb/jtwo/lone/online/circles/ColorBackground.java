package ru.gb.jtwo.lone.online.circles;

import java.awt.*;

public class ColorBackground extends Color {

    private int rgb;
    private int counter;
    private final int MAXTIMECOUNTER = 50;
    private final int MAXCOLOR = 255255255;


    public ColorBackground(int RGB) {
        super(RGB);
    }

    public void changeColorBackground(long currentTime, GameCanvas GameCanvas) {
        if (counter == MAXTIMECOUNTER) {
            this.rgb = (int) (MAXCOLOR * Math.abs(Math.sin(currentTime)));
            change(GameCanvas);
            counter = 0;
        } else {
            counter++;
        }
    }

    private void change(GameCanvas gameCanvas) {
        gameCanvas.setBackground(new Color(rgb));
    }


}
