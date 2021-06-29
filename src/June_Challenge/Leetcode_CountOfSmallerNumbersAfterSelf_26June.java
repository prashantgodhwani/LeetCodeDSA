package June_Challenge;

import java.util.*;

public class Leetcode_CountOfSmallerNumbersAfterSelf_26June {

    public static void main(String[] args) {
        int[] nums = {9,10,11,2,5,6};
        List<Integer> res = countSmaller(nums);
        System.out.println(res);
    }

    static class ArrayElement{
        int data;
        int index;

        public ArrayElement(int data, int index){
            this.data = data;
            this.index = index;
        }
    }

    public static List<Integer> countSmaller(int[] nums) {
        if(nums == null || nums.length == 0) return new ArrayList<>();

        ArrayElement[] arr = new ArrayElement[nums.length];

        for(int i = 0; i < nums.length; i++){
            arr[i] = new ArrayElement(nums[i], i);
        }

        int[] res = new int[arr.length];

        mergeAndSortRevised(arr, 0, arr.length - 1, res);

        List<Integer> ress = new ArrayList<>();
        for(int i : res){
            ress.add(i);
        }

        return ress;
    }

    private static void mergeAndSortRevised(ArrayElement[] arr, int start, int end, int[] res) {

        if(start >= end) return;

        int mid = start + (end - start) / 2;
        mergeAndSortRevised(arr, start, mid, res);
        mergeAndSortRevised(arr, mid + 1, end, res);

        int leftPos = start;
        int rightPos = mid + 1;
        int numElemsRightArrayLessThanLeftArray = 0;
        List<ArrayElement> sortedArr = new LinkedList<>();

        while (leftPos < mid + 1 && rightPos <= end) {
            if(arr[leftPos].data > arr[rightPos].data){
                ++numElemsRightArrayLessThanLeftArray;
                sortedArr.add(arr[rightPos]);
                ++rightPos;
            }
            else{
                res[arr[leftPos].index] += numElemsRightArrayLessThanLeftArray;
                sortedArr.add(arr[leftPos]);
                ++leftPos;
            }
        }

        while (leftPos < mid + 1) {
            res[arr[leftPos].index] += numElemsRightArrayLessThanLeftArray;

            sortedArr.add(arr[leftPos]);
            ++leftPos;
        }

        while (rightPos <= end) {
            sortedArr.add(arr[rightPos]);
            ++rightPos;
        }

        int pos = start;
        for (ArrayElement m : sortedArr) {
            System.out.print(m.data + " ");
            arr[pos] = m;
            ++pos;
        }
        System.out.println();
    }
}
