import java.util.Arrays;

public class Leetcode_CoinChange2_518 {

    public static void main(String[] args) {
        int[] coins = {1,2,5};
        int tar = 5;
//        int res = coinChange2_rec(coins, tar, 0, "", 0);
        int[][] dp = new int[coins.length][tar + 1];
        int res = coinChange2_memo(coins, tar, 0, 0, dp, 0);
        res = coinChange2_tab(coins, tar);
//        for(int[] a : dp){
//            System.out.println(Arrays.toString(a));
//        }
        System.out.println(res);
    }

    public static int coinChange2_rec(int[] coins, int tar, int curr, String asf, int idx){
        if(curr == tar){
            System.out.println(asf);
            return 1;
        }

        int res = 0;
        for(int i = idx; i < coins.length; i++){
            if(curr + coins[i] <= tar){
                res += coinChange2_rec(coins, tar, curr + coins[i], asf + coins[i] + ", ", i);
            }
        }

        return res;
    }

    public static int coinChange2_memo(int[] coins, int tar, int curr, int idx, int[][] dp, int lastCoin){
        if(curr == tar){
            return dp[lastCoin][0] = 1;
        }

        if( dp[lastCoin][tar - curr] != 0) return  dp[lastCoin][tar - curr];

        int res = 0;
        for(int i = idx; i < coins.length; i++){
            if(curr + coins[i] <= tar){
                res += coinChange2_memo(coins, tar, curr + coins[i], i, dp, i);
            }
        }

        dp[lastCoin][tar - curr] = res;
//        System.out.println(Arrays.toString(dp[lastCoin]));
        return  dp[lastCoin][tar - curr];
    }

    public static int coinChange2_tab(int[] coins, int tar){
        int[] dp = new int[tar + 1];

        dp[0] = 1;

        for(int i = 0; i < coins.length; i++){
            for(int j = 1; j <= tar; j++){
                if(j - coins[i] >= 0){
                   dp[j] += dp[j - coins[i]];
                }
            }
        }

        System.out.println(Arrays.toString(dp));
        return dp[tar];
    }
}
