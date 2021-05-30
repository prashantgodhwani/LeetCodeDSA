public class Leetcode_PathWithMaxGold_1219 {
    public static void main(String[] args) {
        int[][] arr = {
                {1,0,7},
                {2,0,6},
                {3,4,5},
                {0,3,0},
                {9,0,20}
        };
        goldHelper(arr);
    }

    private static void goldHelper(int[][] arr) {
        int res, maxGold = 0;
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[0].length; j++){
                if(arr[i][j] != 0){
                    res = calculateGold(arr, i, j, 0, 0);
                    System.out.println("res for ["+i + "," + j + "] is = " + res);
                    if(res > maxGold) maxGold = res;
                }
            }
        }
        System.out.println(maxGold);
    }

    private static int calculateGold(int[][] arr, int row, int col, int gold, int maxGold) {
        System.out.println("Collecting Gold at [" + row + ", " + col + "] = " + arr[row][col] + ", and gold is = " + gold);

        int tempGold = arr[row][col];
        gold += arr[row][col];
        arr[row][col] = 0;

        //top
        if(row - 1 >= 0 && arr[row - 1][col] != 0){
            maxGold = calculateGold(arr, row - 1, col, gold, maxGold);
        }

        //left
        if(col - 1 >= 0 && arr[row][col - 1] != 0){
            maxGold = calculateGold(arr, row, col - 1, gold, maxGold);
        }

        //down
        if(row + 1 < arr.length && arr[row + 1][col] != 0){
            maxGold = calculateGold(arr, row + 1, col, gold, maxGold);
        }

        //right
        if(col + 1 < arr[0].length && arr[row][col + 1] != 0){
            maxGold = calculateGold(arr, row, col + 1, gold, maxGold);
        }

        System.out.println("checking " + gold + " and " + maxGold);
        if(gold > maxGold){
            maxGold = gold;
        }
        arr[row][col] = tempGold;
        return maxGold;
    }
}
