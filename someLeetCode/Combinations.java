package someLeetCode;

import java.util.ArrayList;
import java.util.List;

public class Combinations {

    static List<List<Integer>> ans;
    public static List<List<Integer>> combine(int n, int k) {
        ans = new ArrayList<>();
        helper(1, n, k, new ArrayList<>());
        return ans;
    }

    static void helper(int s, int n, int k, ArrayList<Integer> comb) {
        if (k == 0) {
            ans.add(new ArrayList<>(comb));
            return;
        }

        for (int i = s; i <= n; i++) {
            comb.add(i);
            helper(i + 1, n, k - 1, comb);
            comb.removeLast();
        }
    }

    public static void main(String[] args) {
        System.out.println(combine(4, 2));
        System.out.println(combine(5, 3));
    }
}
