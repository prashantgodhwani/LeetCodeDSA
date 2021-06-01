package June_Challenge;

import java.util.Arrays;

public class Leetcode_MaxAreaOfIsland_01June {

    public static void main(String[] args) {
        int[][] grid = {
                {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}
        };

        int res = maxAreaOfIsland(grid);
        System.out.println(res);
    }


    public static int maxAreaOfIsland(int[][] grid) {
        int res = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] != 0) {
                    res = Math.max(res, recur(grid, i, j) + 1);
                }
            }
        }
        return res;
    }

    public static int recur(int[][] grid, int row, int col){

        int maxArea = 0;
        grid[row][col] = 0;

        //top
        if(row - 1 >= 0 && grid[row - 1][col] == 1){
            maxArea += recur(grid, row - 1, col) + 1;
        }
        //left
        if(col - 1 >= 0 && grid[row][col - 1] == 1){
            maxArea += recur(grid, row, col - 1) + 1;
        }
        //down
        if(row + 1 < grid.length && grid[row + 1][col] == 1){
            maxArea += recur(grid, row + 1, col) + 1;
        }
        //right
        if(col + 1 < grid[0].length && grid[row][col + 1] == 1){
            maxArea += recur(grid, row, col + 1) + 1;
        }

        return maxArea;
    }
}
