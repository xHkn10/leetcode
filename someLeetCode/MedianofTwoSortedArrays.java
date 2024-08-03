package someLeetCode;

import java.util.Arrays;

public class MedianofTwoSortedArrays {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int m = nums1.length;
        int n = nums2.length;

        if (m == 0) {
            if (n % 2 == 1) return nums2[n / 2];
            return (double) (nums2[n / 2 - 1] + nums2[n / 2]) / 2;
        }
        if (n == 0) {
            if (m % 2 == 1) return nums1[m / 2];
            return (double) (nums1[m / 2 - 1] + nums1[m / 2]) / 2;
        }

        int[] all = new int[m + n];
        int i = 0;
        int j = 0;

        while (i != m && j != n) {

            if (nums1[i] < nums2[j]) {
                all[i + j] = nums1[i];
                i++;
            } else {
                all[i + j] = nums2[j];
                j++;
            }
        }
        while (i != m) {
            all[i + j] = nums1[i];
            i++;
        }
        while (j != n) {
            all[i + j] = nums2[j];
            j++;
        }

        if ((m + n) % 2 == 1) return all[(m + n) / 2];
        return (double) (all[(m + n) / 2 - 1] + all[(m + n) / 2]) / 2;
    }

    public static void main(String[] args) {
        System.out.println(findMedianSortedArrays(new int[]{0, 1, 5, 7, 11}, new int[]{1, 2, 3, 6, 9}));
        System.out.println(findMedianSortedArrays(new int[0], new int[]{1}));
        System.out.println(findMedianSortedArrays(new int[]{3}, new int[]{-2, -1}));
        System.out.println(findMedianSortedArrays(new int[]{1, 2}, new int[]{0, 3, 4, 5, 6, 7}));
        System.out.println(findMedianSortedArrays(new int[]{1, 2}, new int[]{-1, 3}));
    }
}




