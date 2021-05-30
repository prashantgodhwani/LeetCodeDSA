import java.util.Arrays;

public class Leetcode_SpiralMatrix2_59 {
    public static void main(String[] args) {
        int n = 1;
        int[][] res = generateMatrix(n);
        printMatrix(res);
    }

    public static int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int i = 1, limit = n*n;
        int row = 0, col = 0, top = 0, left = 0, right = n, bottom = n;

        while(i <= limit){
            //fill horizontal (L -> R)
            while(col < right){
                res[row][col] = i;
                ++i;
                ++col;
            }

            ++top;
            row += 1;
            --col;

            //fill vertical down (T -> B)
            while(row < bottom){
                res[row][col] = i;
                ++i;
                ++row;
            }
            --right;
            row--;
            col--;

            //fill horizontal (R -> L)
            while(col >= left){
                res[row][col] = i;
                ++i;
                --col;
            }
            --bottom;
            row--;
            col++;

            //fill horizontal (R -> L)
            while(row >= top){
                res[row][col] = i;
                ++i;
                --row;
            }

            ++left;
            ++row;
            col = left;
        }

        return res;
    }

    private static void printMatrix(int[][] res) {
        for(int[] i : res){
            System.out.println(Arrays.toString(i));
        }
    }
}
