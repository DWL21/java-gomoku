package com.yourssu.controller;

import com.yourssu.view.ConsoleBoardGameView;

public class BoardGameController {
    public static void main(String[] args) {
        ConsoleBoardGameView view = new ConsoleBoardGameView();
        view.printInitialBoardMessage();
        view.printTurn(1);
        // Assuming you have a Board object to pass
        // view.printBoard(board);
        // view.printCurrentPlayer(Piece.BLACK);
        // view.getInputForCoordinate();
        // view.printGameOver();
    }
}
