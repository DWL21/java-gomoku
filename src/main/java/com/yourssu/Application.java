package com.yourssu;

import com.yourssu.controller.implement.BoardGameControllerExample;
import com.yourssu.controller.Controller;

public class Application {
    public static void main(String[] args) {
        Controller controller = new BoardGameControllerExample();
        controller.run();
    }
}
