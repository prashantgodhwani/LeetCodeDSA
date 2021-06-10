package June_Challenge;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Leetcode_JumpGame6_June9 {

    public static void main(String[] args) {
        //-5582,-5317,6711
        int[] stairs = {-5582,-5317,6711,-639,1001,1845 };
        int k = 3;
        Map<Integer, Integer> dp = new HashMap<>();
        int res = maxResult_pq(stairs, k);
        System.out.println(res);
        System.out.println(dp);
    }

    public static int maxResult_util(int[] nums, int k, int idx, Map<Integer, Integer> dp, int sum, String asf) {
        if(idx == nums.length - 1){
            dp.put(idx, nums[idx]);
            return nums[idx];
        }

        if(dp.containsKey(idx)) return dp.get(idx);

        long score  = Long.MIN_VALUE;
        for(int i = idx; i < idx + k; i++){
            if(i + 1 < nums.length) {
                int n = maxResult_util(nums, k, i + 1, dp, sum + nums[i], asf + nums[i] + "...");
                score = Math.max(score, n);
            }
        }

        dp.put(idx, (int)score + nums[idx]);
        return (int)score + nums[idx];
    }

    public static int maxResult_pq(int[] nums, int k){
        PriorityQueue<int[]> pq  = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        pq.add(new int[]{nums[0], 0});

        for(int i = 1; i < nums.length; i++){
            while(!pq.isEmpty() && i - pq.peek()[1] > k) {
                pq.poll();
            }
            int[] toq = pq.peek();
            int newScore = toq[0] + nums[i];
            pq.add(new int[]{newScore, i});
        }

        pq.stream().forEach(a -> System.out.println(Arrays.toString(a)));
        return pq.peek()[0];
    }
}
