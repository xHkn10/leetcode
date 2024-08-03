package someLeetCode;

import java.util.Arrays;
import static utility.twoDprint.arrayPrint;

public class DistinctSubsequences {
    public static int numDistinct(String s, String t) {
        int[][] mem = new int[s.length() + 1][t.length() + 1];
        for (int[] row : mem) {
            Arrays.fill(row, -1);
        }
        int ans = numDistinct(s, t, 0, 0, mem);
        arrayPrint(mem);
        return ans;
    }

    private static int numDistinct(String s, String t, int sC, int tC, int[][] mem) {
        if (mem[sC][tC] != -1) return mem[sC][tC];
        if (tC == t.length()) return 1;
        if (sC == s.length()) return 0;
        if (s.length() - sC < t.length() - tC) return 0;

        int ans = 0;
        for (int i = sC; i < s.length(); i++) {
            if (s.charAt(i) == t.charAt(tC)) {
                int sub = numDistinct(s, t, i + 1, tC + 1, mem);
                mem[i + 1][tC + 1] = sub;
                ans += sub;
            }
        }

        mem[sC][tC] = ans;
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(numDistinct("rabbbit", "rabbit"));
        System.out.println(numDistinct("babgbag", "bag"));
        System.out.println(numDistinct("arabamaarab", "arab"));
    }
}
