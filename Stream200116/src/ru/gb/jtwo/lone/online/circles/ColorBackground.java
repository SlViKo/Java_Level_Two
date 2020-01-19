/**
 * Java 2. Урок 1. Объектно-ориентированное программирование Java
 * Написать класс Бэкграунд, изменяющий цвет канвы в зависимости от времени
 *
 * @author SlViKo (Кобозев Вячеслав)
 * @version date 19/01/2010
 */
package ru.gb.jtwo.lone.online.circles;

import java.awt.*;

public class ColorBackground extends Color {

    private int rgb;
    private int counter;
    private static final int MAXTIMECOUNTER = 100;
    private static final int MAXCOLOR = 255255255;


    public ColorBackground(int rgb) {
        super(rgb);
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
