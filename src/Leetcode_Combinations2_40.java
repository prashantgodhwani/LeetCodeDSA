import java.util.*;

public class Leetcode_Combinations2_40 {

    private static List<List<Integer>> finalRes = new ArrayList<>();

    public static void main(String[] args) {
        int[] arr = new int[]{10,1,2,7,6,1,5};
        Arrays.sort(arr);
        combinationSum_optimized(8, arr, 0, new LinkedList<>());
        System.out.println(finalRes);
    }

    public static void combinationSum2(int n, int[] qsf, int target, int idx, List<Integer> asf) {
        if(n == 0){
            System.out.println(asf);
            finalRes.add(new ArrayList<>(asf));
            return;
        }

        if(n < 0 || idx >= qsf.length) return;

        asf.add(qsf[idx]);
        combinationSum2(n - qsf[idx], qsf, target, idx+1, asf);
        asf.remove(asf.size() - 1);
        combinationSum2(n, qsf, target, idx+1, asf);
    }

    public static void combinationSum_optimized(int n, int[] qsf, int idx, LinkedList<Integer> asf) {
        if(n == 0){
            finalRes.add(new LinkedList<>(asf));
            return;
        }

        if(n < 0) return;

        for(int i = idx; i < qsf.length; i++) {
            if(i > 0 && qsf[i] == qsf[i-1] && i-1 >= idx) continue;
            asf.add(qsf[i]);
            combinationSum_optimized(n - qsf[i], qsf, i + 1, asf);
            asf.removeLast();
        }
    }
}


