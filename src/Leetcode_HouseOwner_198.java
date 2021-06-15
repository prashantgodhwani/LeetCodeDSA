import java.util.Arrays;

public class Leetcode_HouseOwner_198 {

    public static void main(String[] args) {
        int[] houses = {104,209,137,52,158,67,213,86,141,110,151,127,238,147,169,138,240,185,246,225,147,203,83,83,131,227,54,78,165,180,214,151,111,161,233,147,124,143};
        int res = rob(houses);
        System.out.println(res);

    }

    public static int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        int[] dp = new int[nums.length + 1];
        Arrays.fill(dp, -1);
        int res = rob_util(nums, 0, dp);
        res = Math.max(res, rob_util(nums, 1, dp));
        return res;
    }

    public static int rob_util(int[] nums, int house, int[] dp) {
        if(house == nums.length){
            return 0;
        }

        if(dp[house] != -1) return dp[house];

        int max = 0;
        for(int i = 2; i < nums.length; i++){
            if(house + i <= nums.length){
                max = Math.max(max, rob_util(nums, house + i, dp));
            }
        }


        return dp[house] = max  + nums[house];
    }
}
