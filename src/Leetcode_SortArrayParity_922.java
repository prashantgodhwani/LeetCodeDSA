import java.util.Arrays;

public class Leetcode_SortArrayParity_922 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortArrayByParityInPlace(new int[]{3,2,3,4})));
    }

    //Idea is to have 2 pointers even and odd start at 0 and 1
    //check and swap incrementally if arr[even] != even and arr[odd] != odd
    public static int[] sortArrayByParityInPlace(int[] arr){
        int even = 0, odd = 1;

        while(even < arr.length && odd < arr.length){

            if(arr[even] % 2 == 0) even+=2;
            else if(arr[odd] % 2 != 0) odd+=2;

            else if(arr[even] % 2 != 0 && arr[odd] % 2 == 0) {
                int temp = arr[even];
                arr[even] = arr[odd];
                arr[odd] = temp;
                even += 2;
                odd += 2;
            }
        }
        return arr;
    }

    public static int[] sortArrayByParityII(int[] arr) {
        int i = 0, j = 0;

        while(i < arr.length){
            if(arr[i] % 2 == i % 2){
                ++i;
            }else{
                j = i+1;
                while(j < arr.length){
                    if(arr[j] % 2 != j % 2 && arr[j] % 2 == i % 2){
                        int temp = arr[i];
                        arr[i] = arr[j];
                        arr[j] = temp;
                        i++;
                        break;
                    }
                    j++;
                }
            }

            System.out.println(Arrays.toString(arr) + " i = " + i + ", j = " + j);
        }

        return arr;
    }

    public static int[] sortArrayByParityII_Optimised(int[] arr) {
        int i = 0, even = 0, odd = 1;
        int[] res = new int[arr.length];

        while(i < arr.length){
            if(arr[i] % 2 == 0){
                res[even] = arr[i];
                even+=2;
            }
            else if(arr[i] % 2 != 0) {
                res[odd] = arr[i];
                odd += 2;
            }
            ++i;
        }

        return res;
    }
}
