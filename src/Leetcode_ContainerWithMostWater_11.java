public class Leetcode_ContainerWithMostWater_11 {
    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1,2,7,2,4,100,100,6,3}));
    }


    public static int maxArea(int[] height) {
        int i = 0, j = height.length - 1, area = 0;

        while(i < j){
            if(height[i] < height[j]){
                int ar = (j - i ) * height[i];
                if(ar > area) area = ar;
                i++;
            }
            else if(height[i] > height[j]){
                int ar = (j - i ) * height[j];
                if(ar > area) area = ar;
                j--;
            }else{
                int ar = (j - i ) * height[j];
                if(ar > area) area = ar;
                j--; i++;
            }
        }

        return area;
    }
}
