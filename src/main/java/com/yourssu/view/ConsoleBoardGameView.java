package com.yourssu.view;

import java.util.ArrayList;
import java.util.Scanner;

public class ConsoleBoardGameView {
    private int boardSize;
    private ArrayList<ArrayList<Character>> board;

    private static final Scanner scanner = new Scanner(System.in);

    private static final String COLUMN_LABELS = "ABCDEFGHIJKLMNO";
    public static final int POSITION_LENGTH = 2;

    public ConsoleBoardGameView(int size) {
        setBoardSize(size);
    }

    public void setBoardSize(int size) {
        if (size < 5 || size > 15) {
            throw new IllegalArgumentException("Board size must be between 5 and 15");
        }
        this.boardSize = size;
        this.board = new ArrayList<>();
        for (int i = 0; i < boardSize; i++) {
            ArrayList<Character> row = new ArrayList<>();
            for (int j = 0; j < boardSize; j++) {
                row.add('#'); // 초기화된 보드
            }
            board.add(row);
        }
    }

    public void placePiece(String position, char piece) {
        int coordinate = convertCoordinate(position);
        int col = coordinate / boardSize;
        int row = coordinate % boardSize;
        board.get(row).set(col, piece);
    }

    public int convertCoordinate(String position) {
        if (position.length() < POSITION_LENGTH) {
            throw new IllegalArgumentException("Invalid position");
        }
        int col = COLUMN_LABELS.indexOf(position.toUpperCase().charAt(0));
        int row = boardSize - Integer.parseInt(position.substring(1));
        if (row < 0 || row >= boardSize || col < 0 || col >= boardSize) {
            throw new IllegalArgumentException("Invalid position");
        }
        return col * boardSize + row;
    }

    public void printBoard() {
        System.out.print("   ");
        for (int c = 0; c < boardSize; c++) {
            System.out.print(" " + COLUMN_LABELS.charAt(c));
        }
        System.out.println();

        for (int r = 0; r < boardSize; r++) {
            System.out.printf("%2d ", boardSize - r);
            for (int c = 0; c < boardSize; c++) {
                System.out.print(" " + board.get(r).get(c));
            }
            System.out.println();
        }

        System.out.print(" O ");
        for (int c = 0; c < boardSize; c++) {
            System.out.print(" " + COLUMN_LABELS.charAt(c));
        }
        System.out.println();
    }

    public void printTurn(int turnNumber, String position, char piece) {
        System.out.println("\nTurn " + (turnNumber / 2 + 1));
        printBoard();
        System.out.println("\n" + (piece == 'X' ? "Black" : "White") + ": " + position);
    }

    public void displayInitialBoard() {
        System.out.println("\n초기 보드:");
        printBoard();
    }

    public static void promptForBoardSize() {
        System.out.print("보드 크기를 입력하세요 (5-15): ");
    }

    public void promptForMove(char currentPlayer) {
        System.out.print("\n" + (currentPlayer == 'X' ? "흑(X)" : "백(O)") + "의 차례입니다. 위치를 입력하세요 (예: A1) 또는 'q'로 종료: ");
    }

    public void displayGameOver() {
        scanner.close();
        System.out.println("게임 종료");
    }

    public static String getInput() {
        return scanner.nextLine().trim();
    }
}
