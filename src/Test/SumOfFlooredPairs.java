package Test;

import java.util.Arrays;

public class SumOfFlooredPairs {

    public static void main(String[] args) {
        int[] arr = {7,7,7,7,7,7,7};
        int res = sumOfFlooredPairs(arr, 0, 0, "", 0, 0);
        System.out.println(res);
    }

    private static int sumOfFlooredPairs(int[] arr, int idx, int sum, String asf, int l, int finalRes){
        if(l == 2){
            String[] r = asf.split("_");
            int res = 0;
            if(r[0].equals(r[1])){
                 res = (int) Math.floor(arr[Integer.parseInt(r[0])] / arr[Integer.parseInt(r[1])]);
            }else{
                res += (int) Math.floor(arr[Integer.parseInt(r[1])] / arr[Integer.parseInt(r[0])]);
                res += (int) Math.floor(arr[Integer.parseInt(r[0])] / arr[Integer.parseInt(r[1])]);
            }
            System.out.println("asf  = " + asf +", res = " + res);
            return finalRes + res;
        }

        for(int i = idx; i < arr.length; i++){
            finalRes = sumOfFlooredPairs(arr, i, sum, asf + i+"_", l + 1, finalRes);
        }

        return finalRes;
    }
}
