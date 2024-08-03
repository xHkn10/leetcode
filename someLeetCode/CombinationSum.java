package someLeetCode;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    static List<List<Integer>> ans;

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        ans = new ArrayList<>();
        backtrack(candidates, target, 0, new ArrayList<>(), 0);
        return ans;
    }

    public static void backtrack(int[] candidates, int target, int idx, List<Integer> comb, int sum) {
        if (idx >= candidates.length) return;
        if (sum == target) {
            ans.add(new ArrayList<>(comb));
            return;
        }

        int add = candidates[idx];
        if (add + sum <= target) {
            comb.add(add);
            backtrack(candidates, target, idx, comb, sum + add);
            comb.removeLast();
        }
        backtrack(candidates, target, idx + 1, comb, sum);
    }

    public static void main(String[] args) {
        System.out.println(combinationSum(new int[]{2, 3, 4}, 8));
    }
}
