package com.steph.snake.thread;

public abstract class Loop {

    public static final int STOPPED = 0;

    public static final int RUNNING = 1;

    protected int status = STOPPED;

    private Thread game;

    public void run() {
        status = RUNNING;
        game = new Thread(this::process);
        game.start();
    }

    public boolean isRunning() {
        return status == RUNNING;
    }

    protected abstract void process();

}
