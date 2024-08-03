package someLeetCode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class SumOF3Closest {
    public static int threeSumClosest(int[] nums, int target) {
        int closest = Integer.MAX_VALUE;
        Arrays.sort(nums);
        int len = nums.length;

        for (int i = 0; i < len - 2; i++) {
            int j = i + 1;
            int k = len - 1;

            int ith = nums[i];
            while (j < k) {
                int jth = nums[j], kth = nums[k];
                int total = ith + jth + kth;

                if (target < total) {
                    if (total - target < Math.abs(closest - target)) closest = total;
                    k--;
                } else if (target > total) {
                    if (target - total < Math.abs(closest - target)) closest = total;
                    j++;
                } else return target;
            }
        }

        return closest;
    }


    public static void main(String[] args) {
        System.out.println(threeSumClosest(new int[]{-1, 2, 1, -4}, 1));
        System.out.println(threeSumClosest(new int[]{0, 0, 0}, 1));
        System.out.println(threeSumClosest(new int[]{4, 0, 5, -5, 3, 3, 0, -4, -5}, -2));
        System.out.println(threeSumClosest2(new int[]{4, 0, 5, -5, 3, 3, 0, -4, -5}, 31));
    }


    public static int threeSumClosest2(int[] nums, int target) {
        byte[] occurrences = new byte[2001];

        for (int num : nums) occurrences[num + 1000]++;

        for (int count = 0, index = 0; count < 2001; count++) {
            for (int repetitions = occurrences[count]; repetitions-- > 0; ) {
                nums[index++] = count - 1000;
            }
        }

        int low = 0, high = nums.length - 1, closestSum = Integer.MAX_VALUE;

        for (int minDiff = target - nums[high - 1] - nums[high], end = high - 2; low < end
                && nums[low + 1] <= minDiff; low++)
            ;

        for (int maxDiff = target - nums[low] - nums[low + 1], end = low + 2; high > end
                && nums[high - 1] >= maxDiff; high--)
            ;

        for (int end = high - 1; low < end; low++) {
            for (int sum, i = high, j = low + 1; j < i; ) {
                if ((sum = nums[low] + nums[i] + nums[j]) == target) {
                    return sum;
                } else if ((sum > target ? sum - target - i + i-- : target - sum - j + j++) < Math.abs(closestSum - target)) {
                    closestSum = sum;
                }
            }
        }

        return closestSum;
    }
}
