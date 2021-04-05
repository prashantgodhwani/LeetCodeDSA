import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode_Permutations_46 {
    public static void main(String[] args) {
        System.out.println(permute(new int[]{1,2,3}));
    }

    public static List<List<Integer>> permute(int[] nums) {
        return calculatePermutations(nums, new ArrayList<>(), new ArrayList<>());
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
