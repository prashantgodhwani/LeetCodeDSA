import java.util.Arrays;

public class Leetcode_NQueens2_52 {
    public static void main(String[] args) {
        int n = 4;
        boolean[][] board = new boolean[n][n];
        int count = nQueens2(board, 0, 0);
        System.out.println(count);
    }

    public static int nQueens2(boolean[][] board, int row, int count){
        if(board.length == row){
            count++;
            return count;
        }

        for(int i = 0; i < board.length; i++){
            if(isPositionValid(board, row, i)) {
                board[row][i] = true;
                count = nQueens2(board, row + 1, count);
                board[row][i] = false;
            }
        }

        return count;
    }

    private static void displayBoard(boolean[][] board) {
        for(boolean[] b : board){
            System.out.println(Arrays.toString(b));
        }
    }

    private static boolean isPositionValid(boolean[][] board, int row, int col) {
        //check top
        for(int i = 0; i < row; i++){
            if(board[i][col]) return false;
        }
        System.out.println("top check  = PASSED");

        //check diagonal left
        for(int r = row, c = col; r >= 0 && c >= 0; r--, c--){
            if(board[r][c]) return false;
        }
        System.out.println("LD check  = PASSED");

        //check diagonal left
        for(int r = row, c = col; r >= 0 && c < board.length; r--, c++){
            if(board[r][c]) return false;
        }

        System.out.println("RD check  = PASSED");
        return true;
    }
}
