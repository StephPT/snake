package com.steph.snake;

import com.steph.snake.game.Grid;
import com.steph.snake.thread.Game;
import com.steph.snake.window.GameWindow;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        GameWindow.getInstance().create();
        GameWindow.getInstance().getFrame().add(Grid.getInstance());
        GameWindow.getInstance().getFrame().setVisible(true);

        Game game = new Game();
        game.run();
       }
}
