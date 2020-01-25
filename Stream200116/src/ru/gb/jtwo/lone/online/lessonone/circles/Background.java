/**
 * Java 2. Урок 1. Объектно-ориентированное программирование Java
 * Написать класс Бэкграунд, изменяющий цвет канвы в зависимости от времени
 *
 * @author SlViKo (Кобозев Вячеслав)
 * @version date 19/01/2010
 */
package ru.gb.jtwo.lone.online.lessonone.circles;

import java.awt.*;

public class Background implements Mashin {

    private float time;
    private static final float AMPLITUDE = 255F/2F;
    private Color color;

    @Override
    public void update(GameCanvas gameCanvas, float deltaTime) {
        time += deltaTime;
        int red = Math.round(AMPLITUDE+AMPLITUDE*(float) Math.sin(time));
        int green = Math.round(AMPLITUDE+AMPLITUDE*(float) Math.sin(2*time));
        int blue = Math.round(AMPLITUDE+AMPLITUDE*(float) Math.sin(3*time));
        color = new Color(red, green, blue);
    }

    @Override
    public void render(GameCanvas gameCanvas, Graphics g) {
        gameCanvas.setBackground(color);
    }
}
