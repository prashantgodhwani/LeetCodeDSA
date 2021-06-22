import java.util.Arrays;

public class Leetcode_LongestIncreasingSubsequence_300 {

    public static void main(String[] args) {
        int[] arr = {10,9,2,5,3,7,101,18};
        int[][] dp = new int[arr.length + 1][arr.length + 1];
//        Arrays.fill(dp, -1);
        int res = lengthOfLIS(arr, 0, "", -1, dp);
        System.out.println(res);
    }

    public static int lengthOfLIS(int[] nums, int idx, String asf, int lastDigitIdx, int[][] dp) {
        if(idx == nums.length){
            return 0;
        }

        if(lastDigitIdx > 0 && dp[idx][lastDigitIdx] != 0) return dp[idx][lastDigitIdx];

        int max = Integer.MIN_VALUE;
        if(idx + 1 <= nums.length) {
            if(lastDigitIdx == -1 || nums[lastDigitIdx] < nums[idx])
                max = Math.max(max, lengthOfLIS(nums, idx + 1, asf + nums[idx]+"_", idx, dp)) + 1;
            max = Math.max(max, lengthOfLIS(nums, idx + 1, asf, lastDigitIdx, dp));

        }
        System.out.println("idx = " + idx + ", max = " + max + ", lastDigit = " + lastDigitIdx);
        if(lastDigitIdx > -1){
            dp[idx][lastDigitIdx] = max;
        }
        return max;
    }
}
