import java.util.Arrays;

public class Leetcode_PerfectSquares_279 {

    public static void main(String[] args) {
        int n = 13;
        int s = (int)Math.ceil(Math.sqrt(n));
        int[][] dp = new int[n + 1][s + 1];
        int count = numSquares_tab(n);
        System.out.println(count);
    }

    public static int numSquares_mem(int n, String asf, int idx, int[][] dp) {
        if(n == 0){
            System.out.println(asf);
            return 0;
        }

        if(dp[n][idx] != 0) return dp[n][idx];

        int count = Integer.MAX_VALUE - 10000;
        for(int i = idx; i * i <= n; i++){
            int sq = i * i;
            count = Math.min(count, numSquares_mem(n - sq, asf + sq + "_", i, dp));
        }

        return dp[n][idx] = count + 1;
    }

    public static int numSquares_tab(int n) {
        int[] dp = new int[n + 1];
        int i = 2;

        for(int j = 0; j <= n; j++){
            dp[j] = j;
        }

        while(i * i <= n){
            int sq = i * i;
            for(int j = sq; j <= n; j++){
                if(j - sq >= 0){
                    System.out.println("comparing " + dp[j] + "and " + dp[j - sq]);
                    dp[j] = Math.min(dp[j], dp[j - sq] + 1);
                }
            }
            System.out.println(Arrays.toString(dp));
            i++;
        }

        return dp[n];
    }
}
