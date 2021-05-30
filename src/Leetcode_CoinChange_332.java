import java.util.Arrays;

public class Leetcode_CoinChange_332 {

    public static void main(String[] args) {
        int[] coins = {186, 419, 83, 408};
        int tar = 6249;
        long[] dp = new long[tar + 1];
        long res = coinChange_rec(coins, tar, 0, dp);
        System.out.println(((int) res) < 0 ? -1 : (int) res);

        int r = coinChange_tab(coins, tar);
        System.out.println(r);
    }

    private static long coinChange_rec(int[] coins, int tar, int idx, long[] dp) {
        if (idx == tar) {
            return dp[idx] = 0;
        }

        if (dp[idx] != 0) return dp[idx];

        long count = Long.MAX_VALUE - Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            if (idx + coins[i] <= tar && idx + coins[i] > Integer.MIN_VALUE) {
                count = Math.min(count, coinChange_rec(coins, tar, idx + coins[i], dp));
            }
        }
        return dp[idx] = count + 1;
    }

    private static int coinChange_tab(int[] coins, int tar) {
        int[] dp = new int[tar + 1];

        dp[0] = 0;

        for (int c = 0; c < coins.length; c++) {

            int coin = coins[c];

            for (int i = coin; i <= tar; i++) {
                if (i - coin == 0 || dp[i - coin] >= 1) {
                    if (dp[i] != 0) dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                    else dp[i] = dp[i - coin] + 1;
                }
            }

            System.out.println(Arrays.toString(dp));
        }

        System.out.println(dp[tar]);
        return dp[tar];
    }
}
