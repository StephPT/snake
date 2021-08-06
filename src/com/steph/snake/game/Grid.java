package com.steph.snake.game;

import sun.print.ProxyGraphics2D;

import javax.swing.*;
import java.awt.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Grid extends JPanel {

    private static final Logger log = Logger.getLogger(Grid.class.getName());

    private static Grid grid;

    public static final Color GRID_COLOUR = Color.black;

    public static final Color SNAKE_COLOUR = Color.green;

    public static final Color APPLE_COLOUR = Color.red;

    private final JPanel[][] board = new JPanel[40][40];

    public static Grid getInstance() {
        if(grid == null) {
            grid = new Grid();
        }
        return grid;
    }

    public Grid() {
        JPanel grid = new JPanel(new FlowLayout ( FlowLayout.CENTER, 0, 0 ));
        grid.setPreferredSize(new Dimension(800, 800));
        grid.setBackground(Color.blue);
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                board[i][j] = cell(i, j);
                grid.add(board[i][j]);
            }
        }
        add(grid);
    }

    private JPanel cell(int x, int y) {
        JPanel result = new JPanel(new FlowLayout ( FlowLayout.CENTER, 0, 0 ));
        result.setBackground(GRID_COLOUR);
        result.setPreferredSize(new Dimension(20, 20));
        result.setLocation(x * 40, y * 40);
        return result;
    }

    public void updateCell(int x, int y, Color colour) {
        JPanel cell = board[x][y];
        cell.setBackground(colour);
        cell.repaint();
    }

    public void move(Piece current, Piece old) {

    }

}