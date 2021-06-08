package June_Challenge;

import java.util.HashMap;
import java.util.Map;

public class Leetcode_LongestConsequtive_Sequence {

    public static void main(String[] args) {
        int[] arr = {100,4,200,1,3,2};
        int res = longestConsecutive(arr);
        System.out.println(res);

    }

    public static int longestConsecutive(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i], i);
            }
        }
        int max = 0;
        for(int n : map.keySet()){
            int len = 0;
            if(!map.containsKey(n - 1)){
                //starts here
                while(map.containsKey(n)){
                    n = n + 1;
                    len++;
                }
                max = Math.max(max, len);
            }
        }

        return max;
    }
}
