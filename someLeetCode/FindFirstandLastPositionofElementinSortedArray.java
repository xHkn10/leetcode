package someLeetCode;

import java.util.Arrays;

public class FindFirstandLastPositionofElementinSortedArray {

    public static int[] searchRange(int[] nums, int target) {
        int i = binarySearch(nums, target);

        if (i == -1) return new int[]{-1, -1};

        int left = i;
        do {
            left--;
            if (left == -1) break;
        } while (nums[left] == target);
        left++;

        int right = i;
        do {
            right++;
            if (right == nums.length) break;
        } while (nums[right] == target);

        right--;

        return new int[]{left, right};
    }

    private static int binarySearch(int[] nums, int target) {
        if (nums.length == 0) return -1;
        int left = 0;
        int right = nums.length - 1;
        int middle = (left + right) / 2;

        while (left <= right) {
            if (nums[middle] < target) left = middle + 1;
            else if (nums[middle] > target) right = middle - 1;
            else return middle;
            middle = (left + right) / 2;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {2, 5, 7, 10, 10, 10, 10, 11, 12, 19, 20};
        System.out.println(Arrays.toString(searchRange(nums, 10)));
        System.out.println(binarySearch(new int[]{1}, -1));
        System.out.println(Arrays.toString(searchRange(new int[0], 1)));
        System.out.println(Arrays.toString(searchRange(new int[]{1}, 1)));
        System.out.println(Arrays.toString(searchRange(new int[]{2, 2}, 1)));
    }


    //you need to be more comfortable with index arithmetic
}
