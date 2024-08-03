package someLeetCode;

public class NQueens2 {
    private static int ans;

    public static int totalNQueens(int n) {
        ans = 0;
        backtrackOptimized(n, 0, new boolean[n][n], 0);
        return ans;
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

    private static void backtrackOptimized(int n, int x, boolean[][] board, int q) {
        if (q == n) {
            ans++;
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
        for (int i = 1; i <= 9; i++) System.out.println(totalNQueens(i));
    }
}
