package com.steph.snake.game;

import java.util.ArrayList;
import java.util.List;

public class Snake {

    private static Snake snake;
    
    public static int FORWARD = 0;
    
    public static int RIGHT = 1;
    
    public static int BACKWARDS = 2;
    
    public static int LEFT = 3;
    
    private int direction = 3;

    private int speed = 100;

    private final int x = 20;

    private final int y = 20;
    
    private List<Piece> pieces = new ArrayList<>();

    private Grid grid = null;

    private Apple apple = null;

    public Snake() {
        pieces.add(new Piece(20, 20));
        pieces.add(new Piece(20, 21));
        pieces.add(new Piece(20, 22));
        grid = Grid.getInstance();
        apple = Apple.getInstance();
    }

    public static Snake getInstance() {
        if(snake == null) {
            snake = new Snake();
        }
        return snake;
    }

    public void forward() {
        setDirection(FORWARD);
    }

    public void backwards() {
        setDirection(BACKWARDS);
    }

    public void left() {
        setDirection(LEFT);
    }

    public void right() {
        setDirection(RIGHT);
    }

    public int getDirection() {
        return direction;
    }

    private void setDirection(int direction) {
        this.direction = direction;
    }

    public List<Piece> getPieces() {
        return pieces;
    }

    public Piece getHead() {
        return pieces.get(0);
    }

    public void setHead(Piece updated) {
        pieces.set(0, updated);
    }

    public void increaseSpeed() {
        speed += 10;
    }

    public void decreaseSpeed() {
        speed -= 10;
    }

    public int getSpeed() {
        return speed;
    }

    public boolean tick(Piece updated) {
        boolean result = false;
        for(int i = 1; i != pieces.size(); i++) {
            if(pieces.get(i).getY() == getHead().getY() && pieces.get(i).getX() == getHead().getX()) {
                result = true;
                break;
            }
        }

        if(!result) {
            Piece next = updated;
            Piece last = pieces.get(pieces.size() - 1);
            for(int i = 0; i < pieces.size(); i++) {
                grid.updateCell(next.getX(), next.getY(), Grid.SNAKE_COLOUR);
                Piece u = new Piece();
                u.setX(next.getX());
                u.setY(next.getY());
                next = pieces.get(i);
                pieces.set(i, u);
                grid.updateCell(next.getX(), next.getY(), Grid.GRID_COLOUR);
            }

            if(getHead().getX() == apple.getX() && getHead().getY() == apple.getY()) {
                apple.update(this);
                apple.apply();
                pieces.add(last);
            }
        }
        return result;
    }

    public Piece getNewLocation(Piece head) {
        Piece result = new Piece(head.getX(), head.getY());
        if(snake.getDirection() == Snake.FORWARD) {
            result.setX(head.getX() - 1);
        }
        if(snake.getDirection() == Snake.BACKWARDS) {
            result.setX(head.getX() + 1);
        }
        if(snake.getDirection() == Snake.LEFT) {
            result.setY(head.getY() - 1);
        }
        if(snake.getDirection() == Snake.RIGHT) {
            result.setY(head.getY() + 1);
        }
        if(result.getY() == -1) {
            result.setY(39);
        }
        if(result.getY() == 40) {
            result.setY(0);
        }
        if(result.getX() == -1) {
            result.setX(39);
        }
        if(result.getX() == 40) {
            result.setX(0);
        }
        return result;
    }
}
