package someLeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations2 {

    static List<List<Integer>> ans;

    public static List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        ans = new ArrayList<>();
        backtracker(nums, new ArrayList<>(), new boolean[nums.length]);
        return ans;
    }

    private static void backtracker(int[] nums, List<Integer> curr, boolean[] used) {
        if (curr.size() == nums.length) {
            ans.add(new ArrayList<>(curr));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (i != 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;
            if (!used[i]) {
                curr.add(nums[i]);
                used[i] = true;
                backtracker(nums, curr, used);
                curr.removeLast();
                used[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(permuteUnique(new int[]{1, 2, 3}));
        System.out.println(permuteUnique(new int[]{1, 1, 2}));
    }
}
