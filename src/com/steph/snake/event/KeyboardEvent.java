package com.steph.snake.event;

import com.steph.snake.game.Snake;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyboardEvent extends KeyAdapter {

    private Snake snake;

    public KeyboardEvent() {
        snake = Snake.getInstance();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if(key == KeyEvent.VK_UP && snake.getDirection() != Snake.BACKWARDS) {
            snake.forward();
        }
        if(key == KeyEvent.VK_DOWN && snake.getDirection() != Snake.FORWARD) {
            snake.backwards();
        }
        if(key == KeyEvent.VK_LEFT && snake.getDirection() != Snake.RIGHT) {
            snake.left();
        }
        if(key == KeyEvent.VK_RIGHT && snake.getDirection() != Snake.LEFT) {
            snake.right();
        }
        if(key == KeyEvent.VK_PLUS) {
            snake.increaseSpeed();
        }
        if(key == KeyEvent.VK_MINUS) {
            snake.decreaseSpeed();
        }
    }
}
