package someLeetCode;

public class JumpGame2 {

    public static int jump(int[] nums) {
        int[] dp = new int[nums.length];

        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] + i >= nums.length - 1) {
                dp[i] = 1;
                continue;
            }
            int min = Integer.MAX_VALUE - 1;
            for (int j = nums[i]; j >= 1; j--) {
                if (dp[i + j] < min) min = dp[i + j];
            }
            dp[i] = min + 1;
        }
        return dp[0];
    }

    public static void main(String[] args) {
        System.out.println(jump(new int[]{2,3,1,1,4}));
        System.out.println(jump(new int[]{2,3,0,1,4}));
        System.out.println(jump(new int[]{1, 2}));
        System.out.println(jump(new int[]{5,6,4,4,6,9,4,4,7,4,4,8,2,6,8,1,5,9,6,5,2,7,9,7,9,6,9,4,1,6,8,8,4,4,2,0,3,8,5}));
    }
}
