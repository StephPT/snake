package com.steph.snake.game;

import java.util.Random;

public class Apple {

    private static Apple apple;

    private int x;

    private int y;

    private Grid grid;

    public Apple() {
        grid = Grid.getInstance();
    }

    private Random ran = new Random();

    public static Apple getInstance() {
        if(apple == null) {
            apple = new Apple();
        }
        return apple;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void update(Snake snake) {
        this.x = ran.nextInt(39);
        this.y = ran.nextInt(39);
        for(int i = 1; i != snake.getPieces().size(); i++) {
            if(snake.getPieces().get(i).getY() == y && snake.getPieces().get(i).getX() == x) {
                update(snake);
            }
        }
    }

    public void apply() {
        grid.updateCell(x, y, Grid.APPLE_COLOUR);
    }
}
