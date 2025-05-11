package com.yourssu.model.implement;

import com.yourssu.model.Board;
import com.yourssu.model.Piece;

import java.util.Arrays;

public class BoardExample implements Board {
    private static final int BOARD_SIZE = 15;

    private final Piece[][] grid;

    public BoardExample() {
        this.grid = new Piece[BOARD_SIZE][BOARD_SIZE];
        for (Piece[] row : grid) {
            Arrays.fill(row, Piece.BLANK);
        }
    }

    @Override
    public Piece getPiece(int row, int column) {
        if (isValidCoordinate(row, column)) {
            return grid[row][column];
        }
        throw new IndexOutOfBoundsException();
    }

    @Override
    public void placePiece(int row, int column, Piece piece) {
        if (!isValidCoordinate(row, column) || grid[row][column] != Piece.BLANK) {
            throw new IllegalArgumentException();
        }
        grid[row][column] = piece;
    }

    private boolean isValidCoordinate(int row, int column) {
        return row >= 0 && row < BOARD_SIZE && column >= 0 && column < BOARD_SIZE;
    }
}
