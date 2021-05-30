import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode_NQueens_51 {
    public static void main(String[] args) {
        solveNQueens(4);
    }

    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        nQueens(n, "", new boolean[n][n], 0, res, new ArrayList<>());
        System.out.println(res);
        return res;
    }

    public static void nQueens(int n, String asf, boolean[][] board, int r, List<List<String>> res, List<String> ires) {

        if (n == 0) {
            res.add(new ArrayList<>(ires));
            return;
        }

        for (int j = 0; j < board.length; j++) {
            if (isValidPlace(board, r, j)) {
                asf = fillAsf(asf, j, board.length);
                board[r][j] = true;
                ires.add(asf);
                nQueens(n - 1, "", board, r + 1, res, ires);
                board[r][j] = false;
                ires.remove(ires.size() - 1);
                asf = "";
            }
        }
    }

    private static String fillAsf(String asf, int j, int n) {
        int i = 0;
        StringBuilder sbans = new StringBuilder(asf);
        while(i < n){
            if(i != j) sbans.append(".");
            else sbans.append("Q");
            ++i;
        }

        return sbans.toString();
    }

    public static boolean isValidPlace(boolean[][] board, int r, int c) {
        //top
        for (int i = 0; i < r; i++) {
            if (board[i][c]) return false;
        }
        //diagonal left
        for (int i = r, j = c; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j]) return false;
        }
        //diagonal right
        for (int i = r, j = c; i < board.length && i >= 0 && j < board.length; i--, j++) {
            if (board[i][j]) return false;
        }

        return true;
    }

    private static void printArray(boolean[][] board) {
        for (int i = 0; i < board.length; i++) {
            System.out.println(Arrays.toString(board[i]));
        }
        System.out.println("__________________________________");
    }
}
