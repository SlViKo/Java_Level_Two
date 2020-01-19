package ru.gb.jtwo.lone.online.circles;

import javax.swing.*;
import java.awt.*;

public class GameCanvas extends JPanel {

    MainCircles gameController;
    long lastFrameTime;
    ColorBackground colorBackground;
    int rgbWhite = 255255255;

    GameCanvas(MainCircles gameController) {
        this.gameController = gameController;
        lastFrameTime = System.nanoTime();
        this.colorBackground = new ColorBackground(rgbWhite);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        //60fps
        long currentTime = System.nanoTime();
        float deltaTime = (currentTime - lastFrameTime) * 0.000000001f;
        updateColorBackground(currentTime);
        gameController.onDrawFrame(this, g, deltaTime);
        lastFrameTime = currentTime;
        try {
            Thread.sleep(16);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        repaint();
    }

    private void updateColorBackground(long currentTime) {
        colorBackground.changeColorBackground(currentTime, this);
    }

    public int getLeft() {
        return 0;
    }

    public int getRight() {
        return getWidth() - 1;
    }

    public int getTop() {
        return 0;
    }

    public int getBottom() {
        return getHeight() - 1;
    }

}
