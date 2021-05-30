import java.util.HashSet;
import java.util.Set;

public class Leetcode_SetMatrixZeroes_73 {

    public static void main(String[] args) {
        setZeroesInPlace(new int[][]{
                {1,1,1},
                {0,1,1},
                {1,1,1}

        });
    }

    //Using first ele in row and col as determining condition
    public static void setZeroesInPlace(int[][] matrix){
        int firstRowZero = 1;
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(matrix[i][j] == 0){
                    //mark top col = 0
                    matrix[0][j] = 0;
                    //mark top row = 0
                    if(i > 0)
                        matrix[i][0] = 0;
                    else
                        //used to mark first row as 0 (if)
                        firstRowZero = 0;
                }
            }
        }
        printArray(matrix);

        for(int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[0][j] == 0 || matrix[i][0] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        printArray(matrix);

        //if [0][0] == 0, then the entire column needs to be zero
        if(matrix[0][0] == 0){
            for(int j = 1; j < matrix.length; j++){
                matrix[j][0] = 0;
            }
        }

        //if ZeroZero == 0, then the entire first row needs to be zero
        if(firstRowZero == 0){
            for(int j = 0; j < matrix[0].length; j++){
                matrix[0][j] = 0;
            }
        }

        printArray(matrix);

    }

    public static void setZeroes(int[][] matrix) {
        Set<Integer> is = new HashSet<>();
        Set<Integer> js = new HashSet<>();
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
               if(matrix[i][j] == 0){
                   is.add(i);
                   js.add(j);
               }
            }
        }
        for(int i = 0; i < matrix.length; i++){
            if(is.contains(i)){
                for(int j = 0; j < matrix[0].length; j++){
                    matrix[i][j] = 0;
                }
            }
            for(int j = 0; j < matrix[0].length; j++){
               if(js.contains(j)) matrix[i][j] = 0;
            }
        }

        printArray(matrix);

    }

    public static void printArray(int[][] matrix){
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                System.out.print(matrix[i][j] + ", ");
            }
            System.out.println("");
        }
        System.out.println("-------------------------------");
    }
}
