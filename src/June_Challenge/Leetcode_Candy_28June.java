package June_Challenge;

import java.util.Arrays;

public class Leetcode_Candy_28June {

    public static void main(String[] args) {
        int[] ratings = {1,0,2};
        int res = candy(ratings);
        System.out.println(res);
    }

    public static int candy(int[] ratings) {
        int[] res = new int[ratings.length];

        Arrays.fill(res, 1);

        for(int i = 1; i < res.length; i++){
            if(ratings[i] > ratings[i-1]){
                res[i] = res[i-1] + 1;
            }
        }

        for(int i = res.length - 1; i > 0; i--){
            if(ratings[i] < ratings[i-1]){
                res[i - 1] = Math.max( res[i - 1], res[i] + 1);
            }
        }

        return Arrays.stream(res).sum();
    }
}
