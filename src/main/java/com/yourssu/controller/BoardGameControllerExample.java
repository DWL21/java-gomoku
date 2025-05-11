package com.yourssu.controller;

import com.yourssu.model.Board;
import com.yourssu.model.Piece;
import com.yourssu.model.implement.BoardExample;
import com.yourssu.utils.Pair;
import com.yourssu.view.InputView;
import com.yourssu.view.OutputView;
import com.yourssu.view.implement.ConsoleInputView;
import com.yourssu.view.implement.ConsoleOutputView;
import com.yourssu.view.implement.Symbol;

public class BoardGameControllerExample implements Runnable {
    private final InputView inputView;
    private final OutputView outputView;
    private final Board board;
    private Piece currentPlayer;
    private boolean gameOver;
    private int turnCount;

    public BoardGameControllerExample() {
        this.inputView = new ConsoleInputView();
        this.outputView = new ConsoleOutputView();
        this.board = new BoardExample();
        this.currentPlayer = Piece.BLACK;
        this.gameOver = false;
        this.turnCount = 0;
    }

    @Override
    public void run() {
        while (!gameOver) {
            outputView.printTurn(turnCount / 2 + 1);
            outputView.printBoard(board);
            outputView.printCurrentPlayer(currentPlayer);

            Pair<Integer, Integer> coordinates = inputView.getInputForCoordinate();
            if (coordinates == null) {
                gameOver = true;
                break;
            }

            int row = coordinates.first();
            int col = coordinates.second();
            board.placePiece(row, col, currentPlayer);
            currentPlayer = switchPlayer();
            turnCount++;
        }
//        if (gameOver) {
//            outputView.printGameOverMessage();
//            return;
//        }
        outputView.printWinner(board, Symbol.BLACK);
    }

    private Piece switchPlayer() {
        if (currentPlayer == Piece.WHITE) {
            return Piece.BLACK;
        }
        return Piece.WHITE;
    }
}
