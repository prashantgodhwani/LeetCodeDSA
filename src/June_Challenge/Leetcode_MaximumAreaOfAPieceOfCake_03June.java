package June_Challenge;

import java.util.Arrays;

public class Leetcode_MaximumAreaOfAPieceOfCake_03June {

    public static void main(String[] args) {
        int[] horizontalCuts = {3,1};
        Arrays.sort(horizontalCuts);
        int[] verticalCuts = {1};
        Arrays.sort(verticalCuts);
        int res = maxArea2(5, 4, horizontalCuts, verticalCuts);
        System.out.println(res);

    }

    public static int maxArea2(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        int[] harr = new int[horizontalCuts.length + 1];
        int[] varr = new int[verticalCuts.length + 1];
        int maxh = 0, maxv = 0;

        for(int i = 0; i < horizontalCuts.length; i++){
            if(i == 0){
                harr[i] = horizontalCuts[i];
            }else{
                harr[i] = horizontalCuts[i] - horizontalCuts[i - 1];
            }
            maxh = Math.max(maxh, harr[i]);
        }
        harr[harr.length - 1] = h - horizontalCuts[horizontalCuts.length - 1];
        maxh = Math.max(maxh, harr[harr.length - 1]);

        for(int i = 0; i < verticalCuts.length; i++){
            if(i == 0){
                varr[i] = verticalCuts[i];
            }else{
                varr[i] = verticalCuts[i] - verticalCuts[i - 1];
            }
            maxv = Math.max(maxv, varr[i]);
        }
        varr[varr.length - 1] = w - verticalCuts[verticalCuts.length - 1];
        maxv = Math.max(maxv, varr[varr.length - 1]);

        return maxh * maxv;
    }

    public static int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        int res = 0;
        for(int i = 0; i < h; i++){
            for(int j = 0; j < w; j++){
               res = Math.max(res, maxAreaUtil(h, w, i, j, horizontalCuts, verticalCuts));
            }
        }

        return res;
    }

    private static int maxAreaUtil(int h, int w, int r, int c, int[] horizontalCuts, int[] verticalCuts) {
        int ir = -1, ib = -1;
        //find immediate right
        for(int i = 0; i < verticalCuts.length; i++){
            if(verticalCuts[i] > c){
                ir = verticalCuts[i];
                break;
            }
        }
        if(ir == -1) ir = w;
        //find immediate bottom
        for(int i = 0; i < horizontalCuts.length; i++){
            if(horizontalCuts[i] > r){
                ib = horizontalCuts[i];
                break;
            }
        }
        if(ib == -1) ib = h;

        System.out.println("ir = "  + ir + ", ib = " + ib);
        System.out.println("area for square startting at [" + r + ","  + c + "] is = " + (ir - c) * (ib - r));
        return (ir - c) * (ib - r);

    }
}
