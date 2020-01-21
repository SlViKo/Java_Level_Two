package ru.gb.jtwo.lone.online.circles;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainCircles extends JFrame {
    private static final int POS_X = 400;
    private static final int POS_Y = 200;
    private static final int WINDOW_WIDTH = 800;
    private static final int WINDOW_HEIGHT = 600;

    private Mashin[] mashins = new Mashin[1];
    private int mashinCounter;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainCircles();
            }
        });
    }

    private MainCircles() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(POS_X, POS_Y, WINDOW_WIDTH, WINDOW_HEIGHT);
        initApplication();
        GameCanvas canvas = new GameCanvas(this);
        canvas.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                if(e.getButton() == MouseEvent.BUTTON1) {
                    addMashin(new Ball(e.getX(), e.getY()));
                }
                if(e.getButton() == MouseEvent.BUTTON3) {
                    deleteMashin();
                }

            }
        });
        add(canvas, BorderLayout.CENTER);
        setTitle("Circles");
        setVisible(true);
    }

    private void initApplication() {
        addMashin(new Background());
        addMashin(new Ball());
    }

    public void onDrawFrame(GameCanvas canvas, Graphics g, float deltaTime) {
        update(canvas, deltaTime); // obnovlenie // S = v * t
        render(canvas, g); // otrisovka

    }

    private void update(GameCanvas canvas, float deltaTime) {
        for (int i = 0; i < mashinCounter; i++) {
            mashins[i].update(canvas, deltaTime);
        }
    }

    private void render(GameCanvas canvas, Graphics g) {
        for (int i = 0; i < mashinCounter; i++) {
            mashins[i].render(canvas, g);
        }
    }


    private void addMashin(Mashin sprite) {
        if (mashinCounter == mashins.length) {
            Mashin[] newGameObjects = new Mashin[mashins.length * 2];
            System.arraycopy(mashins, 0, newGameObjects, 0, mashins.length);
            mashins = newGameObjects;
        }
        mashins[mashinCounter++] = sprite;
    }


    private void deleteMashin() {
            if(!(mashins[mashinCounter-1] instanceof Background)) {
                mashinCounter--;
            }
        }




}
