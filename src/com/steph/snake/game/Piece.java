package com.steph.snake.game;

public class Piece {

    private int x;

    private int y;

    public Piece(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Piece() {

    }

    public void setX(int x) {
        this.x = x;
    }

    public int getX() {
        return x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getY() {
        return y;
    }
}
