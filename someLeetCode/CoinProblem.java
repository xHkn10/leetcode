package someLeetCode;

import java.net.Inet4Address;
import java.util.Arrays;

public class CoinProblem {

    //recursive
    private static int minCoins(int[] coins, int target) {
        return minCoins(coins, target, new int[target + 1]);
    }

    private static int minCoins(int[] coins, int target, int[] memo) {
        if (target < 0) return Integer.MAX_VALUE;
        if (target == 0) return 0;
        if (memo[target] != 0) return memo[target];

        int best = Integer.MAX_VALUE;

        for (int coin : coins) {
            if (target - coin < 0) continue;
            best = Math.min(best, minCoins(coins, target - coin, memo) + 1);
        }
        memo[target] = best;
        return best;
    }


    private static int minCoinsI(int[] coins, int target) {
        int[] dp = new int[target + 1];
        int[] sol = new int[target + 1];

        for (int i = 0; i <= target; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int coin : coins) {
                if (i - coin >= 0 && dp[i - coin] + 1 < dp[i]) {
                    dp[i] = dp[i - coin] + 1;
                    sol[i] = coin;
                }
            }
            if (dp[i] == Integer.MAX_VALUE) dp[i] = 0;
        }
        for (int n = sol.length - 1; n > 0; n -= sol[n]) {
            System.out.print(sol[n] + " ");
        }

        return dp[target];
    }

    public static void main(String[] args) {
        minCoinsI(new int[]{1, 3, 4}, 14);
        System.out.println();
        minCoinsI(new int[]{1, 19}, 19);
    }
}
