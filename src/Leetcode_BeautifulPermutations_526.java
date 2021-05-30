import java.util.ArrayList;
import java.util.List;

public class Leetcode_BeautifulPermutations_526 {

    public static void main(String[] args) {
        int[] qsf = new int[2];
        for(int i = 0; i < 2; i++){
            qsf[i] = i+1;
        }
        System.out.println(countArrangement(1, 0, qsf, 0, 0));
    }

    public static int countArrangement(int n, int cur, int[] qsf, int asfSize, int count) {
        if(cur == n){
            return ++count;
        }

        for(int i = 0; i < qsf.length; i++){
            int[] q = new int[qsf.length - 1];
            int k = 0;
            for(int j = 0; j < i; j++){
                q[k] = qsf[j];
                k++;
            }

            for(int j = i + 1; j < qsf.length; j++){
                q[k] = qsf[j];
                k++;
            }
            int size = asfSize+1;
            if(qsf[i] % size == 0  || size % qsf[i] == 0) {
                asfSize = asfSize+1;
                count = countArrangement(n, cur + 1, q, asfSize, count);
                asfSize = asfSize-1;
            }
        }
        return count;
    }
}
