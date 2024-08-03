package someLeetCode;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public static List<Integer> spiralOrder(int[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;

        List<Integer> ans = new ArrayList<>();

        int curY = 0;
        int curX = 0;

        int leftBound = 0;
        int rightBound = n - 1;
        int upperBound = 0;
        int lowerBound = m - 1;

        while (true) {
            if (curX > rightBound) break;
            while (curX <= rightBound) {
                ans.add(matrix[curY][curX++]);
                System.out.println(ans);
            }
            curX--;
            curY++;
            upperBound++;

            if (curY > lowerBound) break;
            while (curY <= lowerBound) {
                ans.add(matrix[curY++][curX]);
                System.out.println(ans);
            }
            curY--;
            curX--;
            rightBound--;


            if (curX < leftBound) break;
            while (curX >= leftBound) {
                ans.add(matrix[curY][curX--]);
                System.out.println(ans);
            }
            curX++;
            curY--;
            lowerBound--;


            if (curY < upperBound) break;
            while (curY >= upperBound) {
                ans.add(matrix[curY--][curX]);
                System.out.println(ans);
            }
            curY++;
            curX++;
            leftBound++;

        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] matrix1 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        System.out.println(spiralOrder(matrix1));
    }
}
