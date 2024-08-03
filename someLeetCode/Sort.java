package someLeetCode;

import java.util.Arrays;

public class Sort {

    //arr is in range [-100,100]
    public static void sort(int[] arr) {
        byte[] frequency = new byte[201];

        for (int x : arr) frequency[x + 100]++; //109. 3

        byte j = 0;
        for (int i = 0; i < 201; i++) {
            byte freq = frequency[i];
            if (freq == 0) continue;
            for (; freq > 0; freq--) {
                arr[j++] = i - 100;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {-2, 9, 7, -3, -2, 11, 11, 9, 31, 29, 69, 31, 9};
        int[] arr2 = {-1, 2, 1, -4};
        sort(arr);
        sort(arr2);
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(arr2));
    }
}
