package June_Challenge;

import java.util.Arrays;

public class Leetcode_MinimumCostClimbingStairs_07June {

    public static void main(String[] args) {
        int[] cost = {10,15,20};
        int[] dp = new int[cost.length + 1];
        Arrays.fill(dp, -1);
        int res = minCostClimbingStairs(cost, 0, dp);
        res = Math.min(res, minCostClimbingStairs(cost, 1, dp));
        System.out.println(res);
    }

    public static int minCostClimbingStairs(int[] cost, int idx, int[] dp) {
        if(idx == cost.length){
            return 0;
        }

        if(dp[idx] != -1) return dp[idx];

        int minCost = 0;
        if(idx + 1 <= cost.length)
            minCost = minCostClimbingStairs(cost, idx + 1, dp) + cost[idx];
        if(idx + 2 <= cost.length)
             minCost = Math.min(minCost, minCostClimbingStairs(cost, idx + 2, dp) + cost[idx]);

        return dp[idx] = minCost;
    }
}
