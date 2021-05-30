import java.util.ArrayList;
import java.util.List;

public class Leetcode_Combinations_77 {

    private static List<List<Integer>> finalRes = null;

    public static void main(String[] args) {
        int n = 1, k = 1;
        finalRes = new ArrayList<>();
        combine(n, k, 0, new ArrayList<>(), 0);
        System.out.println(finalRes);
    }

    public static void combine(int n, int k, int idx, List<Integer> asf, int size) {
        if(idx == n){
            if(size == k){
                finalRes.add(new ArrayList<>(asf));
            }
            return;
        }

        asf.add(++idx);
        size++;
        combine(n, k, idx, asf, size);
        asf.remove(--size);
        combine(n, k, idx, asf, size);
    }
}
