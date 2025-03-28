package com.yourssu.model.board;

public record Position(int row, int column) {
    private static final int MINIMUM_INDEX = 0;

    public Position {
        validatePosition(row, column);
    }

    private static void validatePosition(int row, int column) {
        if (row < MINIMUM_INDEX || column < MINIMUM_INDEX) {
            throw new IllegalArgumentException();
        }
    }
}
