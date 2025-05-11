package com.yourssu.view;

import com.yourssu.model.Board;
import com.yourssu.model.Piece;

public interface OutputView {
    void printInitialBoardMessage();
    void printTurn(int turn);
    void printBoard(Board board);
    void printGameOver();
    void printCurrentPlayer(Piece currentPlayer);
}
