package com.yourssu;

import com.yourssu.controller.BoardGameController;

public class Application {
    public static void main(String[] args) {
        Runnable controller = new BoardGameController();
        controller.run();
    }
}
