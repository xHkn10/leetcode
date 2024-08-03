package someLeetCode;

public class JumpGame {
    private static boolean canJump(int[] nums) {
        return canJump(nums, 0, new byte[nums.length]);
    }

    private static boolean canJump(int[] nums, int i, byte[] mem) {
        if (i >= nums.length - 1) return true;
        if (mem[i] != 0) return mem[i] == 1;

        for (int j = 1; j <= nums[i]; j++) {
            if (canJump(nums, i + j, mem)) {
                mem[i] = 1;
                return true;
            }
        }
        mem[i] = -1;
        return false;
    }

    


    public static void main(String[] args) {
        System.out.println(canJump(new int[]{3, 2, 1, 0, 4}));
        System.out.println(canJump(new int[]{2, 3, 1, 1, 4}));
        System.out.println(canJump(new int[]{0}));
    }
}
