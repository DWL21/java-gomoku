package com.yourssu.controller;

import com.yourssu.view.ConsoleBoardGameView;

public class BoardGameController {
    private ConsoleBoardGameView view;
    private int turn;
    private char currentPlayer;

    public BoardGameController(ConsoleBoardGameView view) {
        this.view = view;
        this.turn = 0;
        this.currentPlayer = 'X'; // 흑이 먼저 시작
    }

    private void startGame() {
        view.displayInitialBoard();

        while (true) {
            view.promptForMove(currentPlayer);
            String input = ConsoleBoardGameView.getInput();

            if (input.equalsIgnoreCase("q")) {
                view.displayGameOver();
                break;
            }

            try {
                view.placePiece(input, currentPlayer);
                view.printTurn(turn, input.toUpperCase(), currentPlayer);
                currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
                turn += 1;
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        ConsoleBoardGameView.promptForBoardSize();
        int size = Integer.parseInt(ConsoleBoardGameView.getInput());

        ConsoleBoardGameView view = new ConsoleBoardGameView(size);
        BoardGameController controller = new BoardGameController(view);
        controller.startGame();
    }
}
