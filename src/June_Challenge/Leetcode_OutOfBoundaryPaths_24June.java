package June_Challenge;

public class Leetcode_OutOfBoundaryPaths_24June {

    public static void main(String[] args) {
        int m = 1, n = 3, maxMove = 3;
        int[][][] dp = new int[m + 1][n + 1][maxMove + 1];
        int res = findPaths(m, n, maxMove, 0,1, dp);
        System.out.println(res);
    }

    public static int findPaths(int m, int n, int maxMove, int r, int c, int[][][] dp) {
        if(r < 0 || r >= m || c < 0 || c >= n){
            return 1;
        }

        if(maxMove <= 0){
            return 0;
        }

        if(dp[r][c][maxMove] != 0){
            return dp[r][c][maxMove];
        }

        int count = 0;
        //top
        count += findPaths(m, n, maxMove - 1, r - 1, c, dp);
        //left
        count += findPaths(m, n, maxMove - 1, r, c - 1, dp);
        //down
        count += findPaths(m, n, maxMove - 1, r + 1, c, dp);
        //right
        count += findPaths(m, n, maxMove - 1, r, c + 1, dp);

        return dp[r][c][maxMove] = count;
    }
}
