package Test;

import java.util.Arrays;

public class IncreamentalMemoryLeak {
    public static void main(String[] args) {
       int[] res =  memLeak(Integer.MAX_VALUE - 2, Integer.MAX_VALUE - 2);
        System.out.println(Arrays.toString(res));
    }

    public static int[] memLeak(int memory1, int memory2) {
        int[] res = new int[3];
        int i = 1;

        while(true){
            if(memory1 >= memory2){
                if(memory1 - i >= 0){
                    memory1-=i;
                }else{
                    res[0] = i;
                    res[1] = memory1;
                    res[2] = memory2;
                    return res;
                }
            }else if(memory1 < memory2){
                if(memory2 - i >= 0){
                    memory2-=i;
                }else{
                    res[0] = i;
                    res[1] = memory1;
                    res[2] = memory2;
                    return res;
                }
            }
            ++i;
        }
    }
}
