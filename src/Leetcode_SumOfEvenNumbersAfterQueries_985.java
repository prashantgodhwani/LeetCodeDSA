import java.util.Arrays;

public class Leetcode_SumOfEvenNumbersAfterQueries_985 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(sumEvenAfterQueries(new int[]{3,2}, new int[][]{{4,0}, {3,0}})));
    }

    public static int[] sumEvenAfterQueries(int[] A, int[][] queries) {
        int evenCount = 0, i = 0;
        int[] res = new int[A.length];
        for(int el : A){
            if(el % 2 == 0) evenCount+=el;
        }
        for(int[] query : queries){
            int sum = A[query[1]] + query[0];
            if(sum % 2 == 0){
                if(A[query[1]] % 2 != 0){
                    evenCount+=sum;
                }else{
                    evenCount+=query[0];
                }
                res[i] = evenCount;
            }else{
                if(A[query[1]] % 2 == 0){
                    evenCount-=A[query[1]];
                    res[i] = evenCount;
                }else{
                    res[i] = evenCount;
                }
            }
            A[query[1]] = sum;
            ++i;
        }
        return res;
    }
}
