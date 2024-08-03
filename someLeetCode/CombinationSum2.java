package someLeetCode;

import java.util.*;

public class CombinationSum2 {

    static List<List<Integer>> ans;

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        ans = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(candidates, target, 0, new ArrayList<>());
        return ans;
    }

    static void backtrack(int[] candidates, int target, int idx, List<Integer> comb) {
        if (target == 0) {
            ans.add(new ArrayList<>(comb));
            return;
        }
        if (target < 0) return;

        for (int i = idx; i < candidates.length; i++) {
            int add = candidates[i];
            if (i > idx && add == candidates[i - 1]) continue;
            if (add > target) break;

            comb.add(add);
            backtrack(candidates, target - add, i + 1, comb);
            comb.removeLast();
        }
    }

    public static void main(String[] args) {
        System.out.println(combinationSum2(new int[]{2, 3, 4, 5}, 8));
        System.out.println(combinationSum2(new int[]{1, 1, 2, 5, 6, 7, 10}, 8));
    }
}
