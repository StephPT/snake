package com.steph.snake.thread;

import com.steph.snake.exception.GameOverException;
import com.steph.snake.game.Apple;
import com.steph.snake.game.Grid;
import com.steph.snake.game.Piece;
import com.steph.snake.game.Snake;

public class Game extends Loop {

    private Snake snake;

    private Grid grid;

    private Apple apple;

    public Game() {
        snake = Snake.getInstance();
        grid = Grid.getInstance();
        apple = Apple.getInstance();
    }

    @Override
    protected void process() {
        grid.updateCell(snake.getHead().getX(), snake.getHead().getY(), Grid.SNAKE_COLOUR);
        apple.update(snake);
        apple.apply();
        while(isRunning()) {
            try {
                Piece old = snake.getHead();
                Piece updated = snake.getNewLocation(old);
                if(snake.tick(updated)) {
                    throw new GameOverException();
                }
                Thread.sleep(25);
            } catch (Exception e) {
                e.printStackTrace();
                System.exit(-1);
            }
        }
    }
}
