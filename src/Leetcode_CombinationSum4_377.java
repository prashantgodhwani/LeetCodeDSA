import java.util.Arrays;

public class Leetcode_CombinationSum4_377 {

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        int[] dp = new int[4 + 1];
        Arrays.fill(dp, -1);
        int res = combinationSum4(nums, 4, dp);
        System.out.println(res);
    }

    public static int combinationSum4(int[] nums, int target, int[] dp) {

        if(target == 0){
            return 1;
        }

        if(dp[target] != -1) return dp[target];

        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            if(target - nums[i] >= 0)
                sum += combinationSum4(nums, target - nums[i], dp);
        }

        return dp[target] = sum;
    }
}
