import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode_NumberOfSquareful_Arrays_996 {
    public static void main(String[] args) {
        int[] arr = {1,17,8};
        int res = findPermutations(0, arr, new ArrayList<>(), 0, arr.length);
        System.out.println(res);
    }

    public static int findPermutations(int size, int[] qsf, List<Integer> asf, int count, int qSize){
        if(size == qSize){
            System.out.println(asf);
            count++;
            return count;
        }

        for(int i = 0; i < qsf.length; i++){
            int el = qsf[i];
            if(i > 0 && qsf[i] == qsf[i-1]) continue;
            int[] ques = new int[qsf.length - 1];

            int k = 0;
            for(int j = 0; j < i; j++){
                ques[k] = qsf[j];
                k++;
            }

            for(int j = i + 1; j < qsf.length; j++){
                ques[k] = qsf[j];
                k++;
            }

            if(size == 0 || size  > 0 && isSquareful(asf.get(size - 1)  + el)) {
                asf.add(el);
                ++size;
                count = findPermutations(size, ques, asf, count, qSize);
                asf.remove(size - 1);
                --size;
            }
        }
        return count;
    }

    private static boolean isSquareful(List<Integer> asf) {
        for(int i = 1; i < asf.size(); i++){
            int n = asf.get(i) + asf.get(i-1);
            if (Math.ceil(Math.sqrt(n)) == Math.floor(Math.sqrt(n)))
                continue;
            else return false;
        }
        return true;
    }

    public static boolean isSquareful(int a){
        if (Math.ceil(Math.sqrt(a)) == Math.floor(Math.sqrt(a)))
            return true;
        else return false;
    }
}
