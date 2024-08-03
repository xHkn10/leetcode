package someLeetCode;

import java.util.ArrayList;
import java.util.List;

import static utility.twoDprint.arrayPrint;

public class NQueens {
    private static List<List<String>> ans;

    public static List<List<String>> solveNQueens(int n) {
        ans = new ArrayList<>();
        boolean[][] board = new boolean[n][n];
        backtrackOptimized(n, 0, board, 0);
        return ans;
    }

    private static void backtrack(int n, int y, int x, boolean[][] board, int q) {

        if (q == n) {
            generateAns(board);
            //arrayPrint(board);
            return;
        }

        if (y == n) return;
        if (x == n) {
            backtrack(n, y + 1, 0, board, q);
            return;
        }

        if (canPlace(y, x, board)) {
            board[y][x] = true;
            backtrack(n, y + 1, 0, board, q + 1);
            board[y][x] = false;
        }
        backtrack(n, y, x + 1, board, q);
    }

    private static boolean canPlace(int y, int x, boolean[][] board) {
        if (board[y][x]) return false;

        for (boolean row : board[y]) if (row) return false;

        for (boolean[] column : board) if (column[x]) return false;

        int j = y, i = x;
        while (j < board.length && i < board.length) if (board[j++][i++]) return false;

        j = y;
        i = x;
        while (j < board.length && i >= 0) if (board[j++][i--]) return false;

        j = y;
        i = x;
        while (j >= 0 && i < board.length) if (board[j--][i++]) return false;

        j = y;
        i = x;
        while (j >= 0 && i >= 0) if (board[j--][i--]) return false;

        return true;
    }

    private static void generateAns(boolean[][] board) {
        StringBuilder line = new StringBuilder();
        List<String> oneAns = new ArrayList<>();
        for (boolean[] rows : board) {
            for (int j = 0; j < board.length; j++) {
                if (rows[j]) line.append("Q");
                else line.append(".");
            }
            oneAns.add(line.toString());
            line = new StringBuilder();
        }
        ans.add(oneAns);
    }

    private static void backtrackOptimized(int n, int x, boolean[][] board, int q) {
        if (q == n) {
            generateAns(board);
            return;
        }

        for (int row = 0; row < n; row++) {
            if (canPlace(row, x, board)) {
                board[row][x] = true;
                backtrackOptimized(n, x + 1, board, q + 1);
                board[row][x] = false;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(solveNQueens(4));

    }
}
