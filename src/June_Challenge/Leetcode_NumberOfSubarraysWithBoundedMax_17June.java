package June_Challenge;

public class Leetcode_NumberOfSubarraysWithBoundedMax_17June {

    static int finalCount = 0;

    public static void main(String[] args) {
        int[] nums = {2,1,4,3};
        int left = 2, right = 3;
        int res = numSubarrayBoundedMax2(nums, left, right);
        System.out.println(finalCount + res);
    }

    public static int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            int max = nums[i];
            if (max >= left && max <= right) count++;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] > max) {
                    max = nums[j];
                }
                System.out.println(max);
                if (max >= left && max <= right) {
                    count++;
                    continue;
                }
            }

            System.out.println("i = " + i + ", count = " + count);
        }

        return count;

    }

    public static int numSubarrayBoundedMax2(int[] nums, int left, int right) {
       int si = 0, ei = 0;
       int res = 0, prevc = 0;

       while(ei < nums.length){
            if(nums[ei] >= left && nums[ei] <= right){
                prevc = ei - si + 1;
                res += prevc;
            }
            else if(nums[ei] < left){
                res += prevc;
            }
            else{
                si = ei + 1;
            }

            ei++;
       }

       return res;
    }
}
