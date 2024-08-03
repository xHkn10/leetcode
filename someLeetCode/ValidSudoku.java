package someLeetCode;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {
    public static boolean isValidSudoku(char[][] board) {
        return rowTraverser(board) && columnTraverser(board) && subBoxTraverser(board);
    }


    private static boolean rowTraverser(char[][] board) {
        for (char[] row : board) {
            for (int i = 0; i < 8; i++) {
                if (row[i] == '.') continue;
                for (int j = i + 1; j < 9; j++) {
                    if (row[i] == row[j]) return false;
                }
            }
        }
        return true;
    }

    private static boolean columnTraverser(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[j][i] == '.') continue;
                for (int k = j + 1; k < 9; k++) {
                    if (board[j][i] == board[k][i]) return false;
                }
            }
        }
        return true;
    }

    private static boolean subBoxTraverser(char[][] board) {
        for (int i = 0; i < 9; i++) {
            char[] flattened = new char[9];
            int say = 0;
            for (int addY = 0; addY < 3; addY++) {
                for (int addX = 0; addX < 3; addX++) {
                    char c = board[3 * (i / 3) + addY][3 * (i % 3) + addX];
                    flattened[say++] = c;
                }
            }
            for (int j = 0; j < 8; j++) {
                if (flattened[j] == '.') continue;
                for (int k = j + 1; k < 9; k++) {
                    if (flattened[j] == flattened[k]) return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] board = {
                {'.', '.', '4', '.', '.', '.', '6', '3', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'5', '.', '.', '.', '.', '.', '.', '9', '.'},
                {'.', '.', '.', '5', '6', '.', '.', '.', '.'},
                {'4', '.', '3', '.', '.', '.', '.', '.', '1'},
                {'.', '.', '.', '7', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '5', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'}
        };

        System.out.println(isValidSudoku(board));

    }





    //instead of traversing all kind of blocks one by one, traverse all the matrix and encode them.
    //every char is encoded 3 times (for rows, for columns, for sub-boxes)
    public boolean isValidSudoku2(char[][] board) {
        Set<String> seen = new HashSet<>();
        for (int i=0; i<9; ++i) {
            for (int j=0; j<9; ++j) {
                if (board[i][j] != '.') {
                    String b = "(" + board[i][j] + ")";
                    if (!seen.add(b + i) || !seen.add(j + b) || !seen.add(i/3 + b + j/3))
                        return false;
                }
            }
        }
        return true;
    }
}
