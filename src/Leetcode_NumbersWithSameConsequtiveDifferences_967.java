import java.util.*;

public class Leetcode_NumbersWithSameConsequtiveDifferences_967 {
    public static void main(String[] args) {
//        System.out.println(Arrays.toString(res));
        int[] res = numSameDiffUtil(9, 0);
        System.out.println(Arrays.toString(res));
//        numsSameConsecDiff(3, 1, 8, new ArrayList<>());
    }

    public static int[] numSameDiffUtil(int n, int k){
        List<Long> ints = new ArrayList<>();
        HashSet<Long> res = new HashSet<>();
        for(long i = 1; i <= 9; i++){
            numsSameConsecDiff(n, k, i, res);
        }
        ints.addAll(res);
        return ints.stream().mapToInt(Long::intValue).toArray();
    }


    public static Set<Long> numsSameConsecDiff(int n, int k, long st, Set<Long> res) {
        if(st * 10 >= Math.pow(10, n)){
            System.out.println(st);
            res.add(st);
            return res;
        }

        long lastDigit = st % 10;
        if(lastDigit + k <= 9) {
            st = st * 10 + (lastDigit + k);
            res = numsSameConsecDiff(n, k, st, res);
            st = st / 10;

        }

        if(lastDigit - k >= 0 && k > 0) {
            st = st * 10 + (lastDigit - k);
            res = numsSameConsecDiff(n, k, st, res);
        }

        return res;
    }
}
