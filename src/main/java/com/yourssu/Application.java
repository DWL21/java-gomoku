package com.yourssu;

import com.yourssu.controller.BoardGameControllerExample;

public class Application {
    public static void main(String[] args) {
        Runnable controller = new BoardGameControllerExample();
        controller.run();
    }
}
