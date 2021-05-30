import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Leetcode_CombinationsSum3_216 {
    public static void main(String[] args) {
        int n = 7;
        int k = 3;
        int[] arr = new int[9];
        for(int i = 1; i <= 9; i++){
            arr[i-1] = i;
        }
        List<List<Integer>> finalRes = new ArrayList<>();
        combinationSum3(n, 0, arr, new LinkedList<>(), finalRes, k);

    }

    public static void combinationSum3(int target, int idx, int[] qsf, LinkedList<Integer> asf, List<List<Integer>> finalRes, int k) {
        if(target == 0){
            if(asf.size() == k) {
                System.out.println(asf);
                finalRes.add(new LinkedList<>(asf));
            }
            return;
        }

        for(int i = idx; i < qsf.length; i++){
            asf.add(qsf[i]);
            combinationSum3(target - qsf[i], i + 1, qsf, asf, finalRes, k);
            asf.removeLast();
        }
    }
}
