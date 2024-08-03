package someLeetCode;

import java.util.ArrayList;

public class PermutationSequence {

    static int[] facts = new int[10];
    static boolean calcOnce = true;

    private static void facts() {
        facts[0] = 1;
        int fact = 1;
        for (int i = 1; i <= 9; i++) {
            fact *= i;
            facts[i] = fact;
        }
        calcOnce = false;
    }

    public static String getPermutation(int n, int k) {
        if (calcOnce) facts();
        return decode(n, k - 1);
    }

    private static String decode(int n, int k) {
        ArrayList<Integer> nums = new ArrayList<>();
        for (int i = 1; i <= n; i++) nums.add(i);
        StringBuilder ans = new StringBuilder();
        int toFact = n - 1;
        for (int i = 0; i < n; i++) {
            int multiplier = mostFact(k, toFact);
            ans.append(nums.get(multiplier));
            nums.remove(nums.get(multiplier));
            k -= multiplier * facts[toFact--];
        }
        return new String(ans);
    }

    private static int mostFact(int k, int f) {
        int multiplier = 0;
        f = facts[f];
        while (multiplier * f <= k) multiplier++;
        return --multiplier;
    }

    public static void main(String[] args) {
        System.out.println(getPermutation(9, 362800));
    }
}
