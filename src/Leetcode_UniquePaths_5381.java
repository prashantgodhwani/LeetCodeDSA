public class Leetcode_UniquePaths_5381 {

    public static void main(String[] args) {
        int m = 3, n = 7;
        int[][] dp = new int[m][n];
        int res = uniquePaths(m, n, 0, 0, dp);
        System.out.println(res);
    }

    public static int uniquePaths(int m, int n, int r, int c, int[][] dp) {
        if(r == m - 1 && c == n - 1){
            return 1;
        }

        if(dp[r][c] != 0) return dp[r][c];

        int res = 0;
        if(r + 1 < m)
            res += uniquePaths(m, n, r + 1, c, dp);
        if(c + 1 < n)
            res += uniquePaths(m, n, r, c + 1, dp);

        return dp[r][c] = res;
    }
}
