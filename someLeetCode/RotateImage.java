package someLeetCode;

import static utility.twoDprint.arrayPrint;

public class RotateImage {
    public static void rotate(int[][] matrix) {
        int[] location = {0, 0};
        int n = matrix.length;
        if (n == 1) return;
        int temp = matrix[0][0];
        int[] initial = {0, 0};
        int[] initialMost = {0, 0};
        for (int i = 0; i < (n + 1) / 2; i++) {
            for (int j = 0; j < n - 1 - 2 * i; j++) {
                initial[0] = location[0];
                initial[1] = location[1];
                while (true) {
                    int carry = temp;
                    location = transformer(n, location);
                    temp = matrix[location[0]][location[1]];
                    matrix[location[0]][location[1]] = carry;
                    if (location[0] == initial[0] && location[1] == initial[1]) break;
                }
                location[1] = location[1] + 1;
                temp = matrix[location[0]][location[1]];
            }
            initialMost[0] += 1;
            initialMost[1] += 1;
            location[0] = initialMost[0];
            location[1] = initialMost[1];
            temp = matrix[location[0]][location[1]];
        }
    }

    private static int[] transformer(int n, int[] place) {
        int newY = place[1];
        int newX = n - place[0] - 1;
        return new int[]{newY, newX};
    }

    public static void main(String[] args) {
        int[][] rotate = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        int[][] rotate2 = {
                {5, 1, 9, 11},
                {2, 4, 8, 10},
                {13, 3, 6, 7},
                {15, 14, 12, 16}
        };
        int[][] rotate3 = {
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20},
                {21, 22, 23, 24, 25}
        };
        rotate(rotate3);
        rotate(rotate2);
        rotate(rotate);
        arrayPrint(rotate);
    }
}
