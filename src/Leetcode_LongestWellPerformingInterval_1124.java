import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Leetcode_LongestWellPerformingInterval_1124 {

    public static void main(String[] args) {
        int res = longestWPI(new int[]{ 6,6,9,9,9});
        System.out.println(res);
    }

    public static int longestWPI(int[] hours) {
        int[] arr = new int[hours.length];
        Map<Integer, Integer> map = new HashMap<>();
        int size = 0, sum = 0, res = 0;

        for(int i = 0; i < hours.length; i++){
            sum += (hours[i] > 8) ? 1 : -1;

            if(sum > 0){
                res = i + 1;
            }else{
                if(!map.containsKey(sum)) map.put(sum, i);

                if(map.containsKey(sum - 1)){
                    res = Math.max(res, i - map.get(sum - 1));
                }
            }
        }

        return res;
    }
}
