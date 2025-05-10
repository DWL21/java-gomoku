package com.yourssu.view;

import com.yourssu.model.Board;
import com.yourssu.model.Piece;
import com.yourssu.utils.Pair;

import java.util.Scanner;

public class ConsoleBoardGameView implements BoardGameView {
    private static final String COLUMN_LABELS = "ABCDEFGHIJKLMNO";
    private static final int POSITION_LENGTH = 2;
    private static final int INITIAL_POSITION = 0;
    private static final int BOARD_SIZE = 15;

    private static final Scanner scanner = new Scanner(System.in);

    public void printInitialBoardMessage() {
        System.out.println("\n초기 보드:");
    }

    public void printTurn(int turn) {
        System.out.println("\nTurn " + turn);
    }

    public void printBoard(Board board) {
        printColumnLabels();
        printRow(board);
        printColumnLabels();
    }

    private void printColumnLabels() {
        System.out.print(" O ");
        for (int c = INITIAL_POSITION; c < BOARD_SIZE; c++) {
            System.out.print(" " + COLUMN_LABELS.charAt(c));
        }
        System.out.println();
    }

    private void printRow(Board board) {
        for (int row = 0; row < BOARD_SIZE; row++) {
            System.out.printf("%2d ", BOARD_SIZE - row);
            for (int column = 0; column < BOARD_SIZE; column++) {
                System.out.print(" " + Symbol.of(board.getPiece(row, column)));
            }
            System.out.println();
        }
    }

    public void printCurrentPlayer(Piece currentPlayer) {
        if (currentPlayer == Piece.BLACK) {
            System.out.print("\n흑(X)의 차례입니다. 위치를 입력하세요 (예: A1) 또는 'q'로 종료: ");
        }
        if (currentPlayer == Piece.WHITE) {
            System.out.print("\n백(O)의 차례입니다. 위치를 입력하세요 (예: A1) 또는 'q'로 종료: ");
        }
        if (currentPlayer == Piece.BLANK) {
            throw new IllegalArgumentException();
        }
    }

    public void printGameOver() {
        System.out.println("게임 종료");
    }

    public String getInput() {
        return scanner.nextLine().trim();
    }

    public Pair<Integer, Integer> getInputForCoordinate() {
        return convertCoordinate(getInput());
    }

    private Pair<Integer, Integer> convertCoordinate(String position) {
        if (position.length() != POSITION_LENGTH) {
            throw new IllegalArgumentException();
        }
        int row = BOARD_SIZE - Integer.parseInt(position.substring(POSITION_LENGTH - 1));
        int col = COLUMN_LABELS.indexOf(position.toUpperCase().charAt(0));
        validate(row, col);
        return new Pair<>(row, col);
    }

    private void validate(int row, int col) {
        if (row < INITIAL_POSITION || row >= BOARD_SIZE || col < INITIAL_POSITION) {
            throw new IllegalArgumentException();
        }
    }
}
