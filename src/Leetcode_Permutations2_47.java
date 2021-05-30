import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode_Permutations2_47 {

    public static void main(String[] args) {
        int[] arr ={1,1,2};
        List<List<Integer>> finalRes = new ArrayList<>();
        permuteUnique(arr, arr.length, finalRes, new ArrayList<>());
    }

    public static void permuteUnique(int[] arr, int size, List<List<Integer>> finalRes, List<Integer> res) {
        if(res.size() == size){
            finalRes.add(new ArrayList<>(res));
        }

        for(int i = 0; i < arr.length; i++){
            if(i > 0 && arr[i] == arr[i-1]) continue;

            int[] q = new int[arr.length - 1];

            int k = 0;
            for(int j = 0; j < i; j++){
                q[k] = arr[j];
                k++;
            }

            for(int j = i + 1; j < arr.length; j++){
                q[k] = arr[j];
                k++;
            }

            res.add(arr[i]);

            permuteUnique(q, size, finalRes, res);

            res.remove(res.size() - 1);
        }
    }
}
