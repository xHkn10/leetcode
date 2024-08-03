package someLeetCode;

import java.util.Arrays;

public class SearchA2dMatrix {
    public static boolean searchMatrix(int[][] matrix, int target) {

        int[] y = binarySearch(matrix, target);

        if (y[0] == 1) return true;

        if (y[1] < 0) return false;

        if (Arrays.binarySearch(matrix[y[1]], target) < 0) return false;

        return true;
    }

    private static int[] binarySearch(int[][] matrix, int target) {

        int low = 0;
        int high = matrix.length - 1;

        while (low <= high) {
            int middle = (low + high) / 2;

            if (target < matrix[middle][0]) high = middle - 1;
            else if (target > matrix[middle][0]) low = middle + 1;
            else return new int[]{1, middle};

        }
        return new int[]{0, high};
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}
        };
        System.out.println(searchMatrix(matrix, 987));
    }
}
