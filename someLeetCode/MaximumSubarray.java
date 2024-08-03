package someLeetCode;

class MaximumSubarraySum {
    private static int maxSubArray(int[] nums) {
        int sum = 0;
        int best = Integer.MIN_VALUE;
        for (int x : nums) {
            sum = Math.max(sum + x, x);
            if (sum > best) best = sum;
        }
        return best;
    }

    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{3, -2, -3, -3, 1, 3, 0}));
    }
}