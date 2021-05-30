public class Leetcode_SearchInSortedRotatedArray2_81 {

    public static void main(String[] args) {
        int[] arr = {1,1,1,1,1,1,1,1,1,13,1,1,1,1,1,1,1,1,1,1,1,1};
        int tar = 13;

        int idx = searchInRotatedSortedArray2(arr,tar);
        System.out.println(idx);
    }

    public static int searchInRotatedSortedArray2(int[] arr, int tar){
        int lo = 0, hi = arr.length - 1;

        while(lo <= hi){
            int mid = lo + (hi - lo) / 2;

            if(arr[mid] == tar) return mid;

            //check if left half is sorted
            else if(arr[mid] > arr[lo] || arr[mid] > arr[hi]){
                if(tar >= arr[lo] &&  tar < arr[mid]){
                    hi = mid - 1;
                }else lo = mid + 1;
            }

            //check if right half is sorted
            else if(arr[mid] < arr[lo] || arr[mid] < arr[hi]){
                if(tar > arr[mid] && tar < arr[lo]){
                    lo = mid + 1;
                }else hi = mid;
            }

            else lo++;
        }

        return -1;
    }
}
