package someLeetCode;

import java.util.HashSet;

public class SudokuSolver {

    public static void solveSudoku(char[][] board) {
        HashSet[] rows = new HashSet[9];
        HashSet[] columns = new HashSet[9];

        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet<Integer>();
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') rows[i].add(board[i][j]);
            }
        }
        for (int i = 0; i < 9; i++) {
            columns[i] = new HashSet<Integer>();
            for (int j = 0; j < 9; j++) {
                if (board[j][i] != '.') columns[i].add(board[j][i]);
            }
        }

        backtrack(board, rows, columns, 0, 0);
    }

    private static void backtrack(char[][] board, HashSet[] rows, HashSet[] columns, int y, int x) {

        for (int i = y; i < 9; i++) {
            for (int j = x; j < 9; j++) {

            }
        }
    }

    public static void main(String[] args) {
        solveSudoku(new char[][]{{1,2}, {1,2}});
    }
}
