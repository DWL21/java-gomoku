package com.yourssu.model.board;

import com.yourssu.model.stone.EmptyStone;
import com.yourssu.model.stone.Stone;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private final BoardSize boardSize;
    private final List<Stone> board;

    private Board(BoardSize boardSize, List<Stone> board) {
        this.boardSize = boardSize;
        this.board = board;
    }

    public static Board of(int size) {
        BoardSize boardSize = new BoardSize(size);
        return new Board(boardSize, initializeBoard(boardSize));
    }

    private static List<Stone> initializeBoard(BoardSize boardSize) {
        List<Stone> board = new ArrayList<>();
        for (int i = 0; i < boardSize.countStones(); i++) {
            board.add(new EmptyStone());
        }
        return board;
    }

    public Board placeStone(Stone stone, Position position) {
        int index = boardSize.calculateIndex(position);
        validateEmpty(index);
        return new Board(boardSize, changeBoard(index, stone));
    }

    private void validateEmpty(int index) {
        Stone stone = board.get(index);
        stone.enforceImmovableStoneRule();
    }

    private List<Stone> changeBoard(int index, Stone newStone) {
        List<Stone> newBoard = new ArrayList<>(board);
        newBoard.set(index, newStone);
        return newBoard;
    }
}
