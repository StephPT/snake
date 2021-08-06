package com.steph.snake.window;

import com.steph.snake.event.KeyboardEvent;

import javax.swing.*;

public class GameWindow {

    private static GameWindow window = null;

    private JFrame frame = null;

    public static GameWindow getInstance() {
        if(window == null) {
            window = new GameWindow();
        }
        return window;
    }

    public void create() {
        frame = new JFrame("Snake - \uD83D\uDC0D");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.addKeyListener(new KeyboardEvent());
        frame.setResizable(false);
        frame.setSize(800, 800);
    }

    public JFrame getFrame() {
        return frame;
    }
}
