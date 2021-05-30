import java.util.Arrays;

public class Leetcode_TargetSum_494 {

    public static void main(String[] args) {
        int[] arr = {1000};
        int tar = -1000;

        int res = targetSum_tab(arr, tar);
        System.out.println("===>" + res);

    }

    private static int targetSum_tab(int[] arr, int tar){
        int[][] dp = new int[arr.length + 1][2001];
        dp[0][1000] = 1;

        for(int i = 1; i <= arr.length; i++){
            for(int j = 0; j < dp[0].length; j++){
                if(j - arr[i-1] >= 0 ) {
                    dp[i][j] += dp[i - 1][j - arr[i - 1]];
                }
                if(j + arr[i - 1] < dp[0].length){
                    dp[i][j] += dp[i - 1][j + arr[i - 1]];
                }
            }
        }

        return dp[arr.length][1000 + tar];

    }

    private static int targetSum_rec(int[] arr, int tar, int sum, int idx, String asf) {
//        System.out.println("tar = " + tar + ", sum = " + sum + ", idx = " + idx + ", asf = " + asf);
        if(idx == arr.length){
            if(sum == tar) {
                System.out.println(asf);
                return 1;
            }
            return 0;
        }

        int count = 0;
        count += targetSum_rec(arr, tar, sum + arr[idx], idx + 1, (asf + "+"+arr[idx]));

        count += targetSum_rec(arr, tar, sum - arr[idx], idx + 1, (asf + "-"+arr[idx]));


        return count;
    }

    private static int targetSum_mem(int[] arr, int tar, int sum, int idx, int[][] dp, int min) {
//        System.out.println("tar = " + tar + ", sum = " + sum + ", idx = " + idx + ", asf = " + asf);
        if(idx == arr.length){
            if(sum == tar) {
                System.out.println(idx + ", " + (sum + tar));
                dp[idx][sum + min] = 1;
                return 1;
            }
            return 0;
        }

        if(dp[idx][sum + min] > 0) return dp[idx][sum + min];

        int count = 0;

        count += targetSum_mem(arr, tar, sum + arr[idx], idx + 1, dp, min);

        count += targetSum_mem(arr, tar, sum - arr[idx], idx + 1, dp, min);

        dp[idx][sum + min] = count;

        return count;
    }

    private static int targetSum_mem_optimized(int[] arr, int tar, int sum, int idx, int[][] dp) {
        if(idx == arr.length){
            if(sum == tar) {
                return dp[idx][sum + 1000] = 1;
            }
            return dp[idx][sum + 1000] = 0;
        }


        if(dp[idx][sum + 1000] > Integer.MIN_VALUE) return dp[idx][sum + 1000];

        int count = 0;

        count += targetSum_mem_optimized(arr, tar, sum + arr[idx], idx + 1, dp);

        count += targetSum_mem_optimized(arr, tar, sum - arr[idx], idx + 1, dp);

        dp[idx][sum + 1000] = count;

        return count;
    }

    public static void targetSumSubset_printall(int[] arr, int tar, String asf, int idx){
        if(tar == 0){
            System.out.println(asf);
            return;
        }

        for(int i = idx; i < arr.length; i++){
            if(tar - arr[i] >= 0) {
                targetSumSubset_printall(arr, tar - arr[i], asf + arr[i] + ", ", i + 1);
            }
        }
    }

    public static boolean targetSumSubset_isPresent_rec(int[] arr, int tar, int idx){
        if(tar == 0){
            return true;
        }

        boolean res = false;
        for(int i = idx; i < arr.length; i++){
            if(tar - arr[i] >= 0) {
                res = res || targetSumSubset_isPresent_rec(arr, tar - arr[i], i + 1);
            }
        }

        return res;
    }

    public static boolean targetSumSubset_isPresent_mem(int[] arr, int tar, int idx, boolean[] dp){

        if(tar == 0){
            return dp[tar] = true;
        }

        if(dp[tar]) return dp[tar];

        boolean res = false;
        for(int i = idx; i < arr.length; i++){
            if(tar - arr[i] >= 0) {
                res = res || targetSumSubset_isPresent_mem(arr, tar - arr[i], i + 1, dp);
            }
        }

        dp[tar] = res;
        return res;
    }

    public static boolean targetSumSubset_isPresent_mem_2d(int[] arr, int tar, int idx, boolean[][] dp){

        if(tar == 0){
            System.out.println("---"+idx);
            return dp[idx][tar] = true;
        }

        if(dp[idx][tar]) return dp[idx][tar];

        boolean res = false;
        for(int i = idx; i < arr.length; i++){
            if(tar - arr[i] >= 0) {
                res = res || targetSumSubset_isPresent_mem_2d(arr, tar - arr[i], i + 1, dp);
            }
        }

        dp[idx][tar] = res;
        return res;
    }

    public static int targetSumSubset_noOfWays_mem_2d(int[] arr, int tar, int idx, int[][] dp){

        if(tar == 0){
            return dp[idx][tar] = 1;
        }

        if(dp[idx][tar] > 0) return dp[idx][tar];

        int count = 0;
        for(int i = idx; i < arr.length; i++){
            if(tar - arr[i] >= 0) {
                count += targetSumSubset_noOfWays_mem_2d(arr, tar - arr[i], i + 1, dp);
            }
        }

        dp[idx][tar] = count;
        return count;
    }

    public static boolean targetSumSubset_isPossible_tab_2d(int[] arr, int tar){
        boolean[][] dp = new boolean[arr.length + 1][tar +  1];

        for(int i = 0; i < dp.length; i++){
            for(int j = 0; j < dp[0].length; j++){

                if(i == 0 && j == 0) dp[i][j] = true;

                else if(i == 0) dp[i][j] = false;

                else if(j == 0) dp[i][j] = true;

                else{
                    if(j - arr[i - 1] >= 0)
                        dp[i][j] = dp[i-1][j] || dp[i-1][j-arr[i - 1]];

                    //if element value is higher than target, copy above value
                    else
                        dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[arr.length][tar];
    }

    public static int targetSumSubset_noOfWays_tab_2d(int[] arr, int tar){
        int[][] dp = new int[arr.length + 1][tar +  1];

        for(int i = 0; i < dp.length; i++){
            for(int j = 0; j < dp[0].length; j++){

                if(i == 0 && j == 0) dp[i][j] = 1;

                else if(i == 0) dp[i][j] = 0;

                else if(j == 0) dp[i][j] = 1;

                else{
                    if(j - arr[i - 1] >= 0)
                        dp[i][j] = dp[i-1][j] + dp[i-1][j-arr[i - 1]];

                        //if element value is higher than target, copy above value
                    else
                        dp[i][j] = dp[i-1][j];
                }
            }
        }

                for(int[] a : dp){
            System.out.println(Arrays.toString(a));
        }
        return dp[arr.length][tar];
    }

}
