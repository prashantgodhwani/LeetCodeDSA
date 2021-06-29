package June_Challenge;

public class Leetcode_MaximumConsequtiveOnes_29June {

    public static void main(String[] args) {
        int[] arr = {0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
        int res = longestOnes(arr, 3);
        System.out.println(res);
    }

    public static int longestOnes(int[] arr, int k) {
        int left = 0, right = 0, maxLength = Integer.MIN_VALUE;

        while(right != arr.length){

            if(arr[right] == 1){
                right++;
            }

            else if(arr[right] == 0 && k > 0){
                k--;
                right++;
            }

            else if(arr[right] == 0 && k == 0){
                maxLength = Math.max(maxLength, right - left);
                if(arr[left] == 0){
                    k++;
                    left++;
                }else left++;
            }
        }

        return Math.max(maxLength, right - left);
    }
}
