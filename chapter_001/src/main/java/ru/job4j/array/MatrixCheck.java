package ru.job4j.array;

public class MatrixCheck {
    public static boolean monoHorizontal(char[][] board, int row) {
        boolean result = true;
        for (int i = 0; i < board.length - 1; i++) {
            if (board[row][i] != board[row][++i]) {
                result = false;
                break;
            }
        }
        return result;
    }

    public static boolean monoVertical(char[][] board, int column) {
        boolean result = true;
        for (int i = 0; i < board.length -1; i++) {
            if (board[i][column] != board[++i][column]) {
                result = false;
                break;
            }
        }
        return result;
    }
}