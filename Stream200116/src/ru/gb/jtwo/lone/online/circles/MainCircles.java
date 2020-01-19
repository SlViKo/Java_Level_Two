package ru.gb.jtwo.lone.online.circles;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MainCircles extends JFrame implements MouseListener {
    private static final int POS_X = 400;
    private static final int POS_Y = 200;
    private static final int WINDOW_WIDTH = 800;
    private static final int WINDOW_HEIGHT = 600;

    Sprite[] sprites = new Sprite[10];

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
        canvas.addMouseListener(this);
        add(canvas, BorderLayout.CENTER);
        setTitle("Circles");
        setVisible(true);
    }

    private void initApplication() {
        for (int i = 0; i < sprites.length; i++) {
            sprites[i] = new Ball();
        }
    }

    public void onDrawFrame(GameCanvas canvas, Graphics g, float deltaTime) {
        update(canvas, deltaTime); // obnovlenie // S = v * t
        render(canvas, g); // otrisovka

    }

    private void update(GameCanvas canvas, float deltaTime) {
        for (int i = 0; i < sprites.length; i++) {
            sprites[i].update(canvas, deltaTime);
        }
    }

    private void render(GameCanvas canvas, Graphics g) {
        for (int i = 0; i < sprites.length; i++) {
            sprites[i].render(canvas, g);
        }
    }

    /**
     * Метод добавления шарика в массив по клику левой кнопки мыши
     * @param sprites
     */
    private void addBall(Sprite[] sprites) {
        Sprite[] sprite = new Sprite[sprites.length + 1];
        for (int i = 0; i < sprite.length; i++) {
            if (i == sprite.length - 1) {
                sprite[sprite.length - 1] = new Ball();
                break;
            }
            sprite[i] = sprites[i];
        }
        this.sprites = sprite;
    }

    /**
     * Метод удаления шарика из массива по клику правой кнопки мыши
     * @param sprites
     */
    private void deleteBall(Sprite[] sprites) {
        if (sprites.length > 0) {
            Sprite[] sprite = new Sprite[sprites.length - 1];
            for (int i = 0; i < sprite.length; i++) {
                sprite[i] = sprites[i];
            }
            this.sprites = sprite;
        }
    }


    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1) {
            addBall(sprites);
        }
        if (e.getButton() == MouseEvent.BUTTON3) {
            deleteBall(sprites);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

}
