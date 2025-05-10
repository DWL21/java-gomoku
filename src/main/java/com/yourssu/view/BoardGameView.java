package com.yourssu.view;

import com.yourssu.model.Board;
import com.yourssu.model.Piece;
import com.yourssu.utils.Pair;

public interface BoardGameView {
    void printInitialBoardMessage();
    void printTurn(int turn);
    void printBoard(Board board);
    void printGameOver();
    void printCurrentPlayer(Piece currentPlayer);
    Pair<Integer, Integer> getInputForCoordinate();
}
