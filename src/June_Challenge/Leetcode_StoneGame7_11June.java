package June_Challenge;

import java.util.ArrayDeque;
import java.util.Queue;

public class Leetcode_StoneGame7_11June {

    public static void main(String[] args) {
        int[] stones = {5,3,1,4,2};
        int score = 0;
        for(int i : stones){
            score += i;
        }
        int[][] dp = new int[stones.length + 1][stones.length + 1];
        int res = stoneGameVII(stones, 0, stones.length - 1, score, dp);
        System.out.println(res);
    }

    public static int stoneGameVII(int[] stones, int left, int right, int score, int[][] dp) {
        if(left >= right){
            return 0;
        }

        if(dp[left][right] != 0) return dp[left][right];

        int leftScore = (score - stones[left]) - stoneGameVII(stones, left + 1, right, score - stones[left], dp);
        int rightScore = (score - stones[right]) - stoneGameVII(stones, left, right - 1, score - stones[right], dp);
        int finalScore = Math.max(leftScore, rightScore);
        return dp[left][right] = finalScore;
    }
}
