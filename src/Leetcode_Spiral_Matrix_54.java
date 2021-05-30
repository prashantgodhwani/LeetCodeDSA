import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode_Spiral_Matrix_54 {
    public static void main(String[] args) {
        System.out.println(spiralOrder(new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}}));
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int row = 0, col = 0, top = 0, left = 0, right = matrix[0].length, bottom = matrix.length, limit = matrix.length * matrix[0].length, i = 0;

        while(i < limit){
            //fill horizontal (L -> R)
            while(col < right && i < limit){
                res.add(matrix[row][col]);
                ++i;
                ++col;
            }

            ++top;
            row += 1;
            --col;

            //fill vertical down (T -> B)
            while(row < bottom && i < limit){
                res.add(matrix[row][col]);
                ++i;
                ++row;
            }
            --right;
            row--;
            col--;

            //fill horizontal (R -> L)
            while(col >= left && i < limit){
                res.add(matrix[row][col]);
                ++i;
                --col;
            }
            --bottom;
            row--;
            col++;

            //fill horizontal (R -> L)
            while(row >= top && i < limit){
                res.add(matrix[row][col]);
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
