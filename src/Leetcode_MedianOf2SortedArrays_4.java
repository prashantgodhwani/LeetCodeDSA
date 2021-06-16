public class Leetcode_MedianOf2SortedArrays_4 {

    public static void main(String[] args) {
        int[] a1 = {1,3};
        int[] a2 = {2};
        double res= findMedianSortedArrays(a1, a2);
        System.out.println(res);
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length){
            return findMedianSortedArrays(nums2, nums1);
        }

        int len1 = nums1.length;
        int len2 = nums2.length;
        int st = 0, end = len1;

        while(st <= end){

            int partitionX = (st + end) / 2;
            int partitionY = (len1 + len2 + 1) / 2 - partitionX;

            int maxLeftX = (partitionX == 0) ? Integer.MIN_VALUE : nums1[partitionX - 1];
            int minRightX = (partitionX == len1) ? Integer.MAX_VALUE : nums1[partitionX];

            int maxLeftY = (partitionY == 0) ? Integer.MIN_VALUE : nums2[partitionY - 1];
            int minRightY = (partitionY == len2) ? Integer.MAX_VALUE : nums2[partitionY];

            if(maxLeftX <= minRightY && maxLeftY <= minRightX){
                if ((len1 + len2) % 2 == 0) {
                    return ((double)Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY))/2;
                } else {
                    return (double)Math.max(maxLeftX, maxLeftY);
                }
            }

            else if(maxLeftX > minRightY){
                end = partitionX - 1;
            }

            else{
                st = partitionX + 1;
            }
        }

        return 0;
    }
}
