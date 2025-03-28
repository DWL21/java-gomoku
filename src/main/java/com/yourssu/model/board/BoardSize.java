package com.yourssu.model.board;

public class BoardSize {
    private static final int MIN_SIZE = 5;
    private static final int MAX_SIZE = 15;

    private final int size;

    public BoardSize(int size) {
        validateBoardSize(size);
        this.size = size;
    }

    private static void validateBoardSize(int size) {
        if (size < BoardSize.MIN_SIZE || BoardSize.MAX_SIZE < size) {
            throw new IllegalArgumentException();
        }
    }

    public int countStones() {
        return size * size;
    }

    public int calculateIndex(Position position) {
        validatePosition(position);
        return position.row() * size + position.column();
    }

    private void validatePosition(Position position) {
        if (position.row() >= size || position.column() >= size) {
            throw new IllegalArgumentException();
        }
    }
}
