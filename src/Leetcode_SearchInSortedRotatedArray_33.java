public class Leetcode_SearchInSortedRotatedArray_33 {

    public static void main(String[] args) {
        int[] arr = {1};
        int tar = 1;

        int idx = searchInRotatedSortedArray2(arr,tar);
        System.out.println(idx);
    }

    public static int searchInRotatedSortedArray2(int[] arr, int tar){
        int lo = 0, hi = arr.length - 1;

        while(lo <= hi){
            int mid = lo + (hi - lo) / 2;

            if(arr[mid] == tar) return mid;

            else if(arr[mid] > arr[lo]){
                if(tar >= arr[lo] &&  tar < arr[mid]){
                    hi = mid;
                }else lo = mid + 1;
            }

            else if(arr[mid] < arr[hi]){
                if(tar > arr[mid] && tar <= arr[hi]){
                    lo = mid + 1;
                }else hi = mid;
            }
        }

        return -1;
    }

    public static int searchInRotatedSortedArray(int[] arr, int tar){
        int smallIndex = findSmallestElementInRotatedSortedArray(arr, 0, arr.length - 1);
        System.out.println("smallIndex = " + smallIndex);

        int idx = -1;
        if(smallIndex > 0 && tar >= arr[0] && tar <= arr[smallIndex - 1])
            idx = binarySearch(arr, tar, 0, smallIndex);

        if(idx == -1 && tar >= arr[smallIndex] && tar <= arr[arr.length - 1])
            idx = binarySearch(arr, tar, smallIndex, arr.length - 1);

        return idx;

    }

    private static int binarySearch(int[] arr, int tar, int start, int end) {
        System.out.println("start = " + start + ", end = " + end);
        if(start > end) return -1;

        int mid = start + (end - start) / 2;

        if(arr[mid] == tar){
            return mid;
        }else if(arr[mid] > tar){
            return binarySearch(arr, tar, start, mid - 1);
        }else return binarySearch(arr, tar, mid + 1, end);
    }

    public static int findSmallestElementInRotatedSortedArray(int[] arr, int lo, int hi){
        if(lo == hi) return lo;

        int mid = lo + ((hi - lo) / 2);

        int idx = -1;
        if(arr[mid] >= arr[hi]){
           idx = findSmallestElementInRotatedSortedArray(arr, mid + 1, hi);
        }else{
            idx = findSmallestElementInRotatedSortedArray(arr, lo, mid);
        }

        return idx;
    }
}
