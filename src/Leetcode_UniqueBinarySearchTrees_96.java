public class Leetcode_UniqueBinarySearchTrees_96 {

    public static void main(String[] args) {
        int res = numTrees(5);
        System.out.println(res);
    }

    public static int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for(int i = 2; i <= n; i++){

            int left = 0;
            int right = i - 1;

            int sum = 0;
            while(left <= i - 1){
                sum += dp[left] * dp[right];
                left++; --right;
            }

            dp[i] = sum;
        }

        return dp[n];
    }
}
