package Test.BiWeekly53;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.*;

public class XORSum {

    public static void main(String[] args) throws FileNotFoundException {
        int[] a = new int[]{1, 0, 3, 1, 34};
        int[] b = new int[]{5, 3, 4, 10, 12};

        Map<String, Integer> dp = new HashMap<>();
        int res = showPermutations(a, new int[b.length], b, 0, dp);
        System.out.println(dp);
        System.out.println(res);
    }

    private static int xor(int[] a, int[] b) {
        int sum = 0, k = 0;
        for(int i : a){
          sum += (i ^ b[k]);
          k++;
        }
        return sum;
    }


    public static int showPermutations(int[] a, int[] asf, int[] qsf, int idx, Map<String, Integer> dp){
        if(qsf.length == 0){
            System.out.println(Arrays.toString(asf));
            return 0;
        }

        String key = Arrays.toString(qsf);
        if(dp.containsKey(key)) return dp.get(key);

        int res = Integer.MAX_VALUE;

        for(int i = 0; i < qsf.length; i++){
            asf[idx] = qsf[i];

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
            res = Math.min(res, (asf[idx] ^ a[idx]) + showPermutations(a, asf, q, idx + 1, dp));
        }

        dp.put(key, res);
        return res;
    }


    public static List<List<Integer>> calculatePermutations(int[] nums, List<Integer> asf, List<List<Integer>> finalRes){
        if(nums.length == 0){
            finalRes.add(asf);
            return finalRes;
        }

        for(int i = 0; i < nums.length; i++) {
            int fnum = nums[i];
            asf.add(fnum);
            int[] newNums = new int[nums.length - 1];
            int k = 0;
            for(int j = 0; j < i; j++, k++){
                newNums[k] = nums[j];
            }

            if(i + 1 <= nums.length - 1) {
                for (int j = i+1; j < nums.length; j++, k++) {
                    newNums[k] = nums[j];
                }
            }

            finalRes = calculatePermutations(newNums, new ArrayList<>(asf), finalRes);
            asf.remove(asf.size() - 1);
        }

        return finalRes;
    }
}
