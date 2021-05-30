import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Leetcode_CombinationSum_39 {
    public static void main(String[] args) {
        int target = 7;
        List<List<Integer>> res = new ArrayList<>();
        combinationSum(new int[]{2,3,6,7}, target, 0, new ArrayList<>(), res, 0);
        System.out.println(res);
    }

    public static void combinationSum(int[] candidates, int target, int sof, List<Integer> nums, List<List<Integer>> res, int start) {
        if(sof == target) {
            res.add(nums);
            return;
        }

        for(int i = start; i < candidates.length; i++){
            if(sof+candidates[i] <= target) {
                nums.add(candidates[i]);
                combinationSum(candidates, target, sof + candidates[i], new ArrayList<>(nums), res, i);
                nums.remove(nums.size() - 1);
            }
        }
    }
}
