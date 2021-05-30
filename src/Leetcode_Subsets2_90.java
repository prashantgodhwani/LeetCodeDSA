import java.util.*;

public class Leetcode_Subsets2_90 {

    public static void main(String[] args) {
        int[] arr = {1,2,3};
        //1,4,4,4
        Arrays.sort(arr);
        List<Integer> res = new ArrayList<>();
        List<List<Integer>> lists = new ArrayList<>();
        subsets_optimized(arr, 0, res, lists);
        System.out.println(lists);
    }

    public static void subsets(int[] q, List<Integer> res, Set<List<Integer>> set){
        if(q.length == 0){
            System.out.println(res);
            set.add(new ArrayList<>(res));
            return;
        }


        for(int i = 0; i < q.length; i++){
            int el = q[i];
            if(i > 0 && el == q[i-1]) continue;
            int[] ques = new int[q.length-(1 + i)];
            for(int j = i+1, k = 0; j < q.length; j++, k++){
                ques[k] = q[j];
            }
            res.add(el);
            subsets(ques, res, set);
            res.remove(res.size() - 1);
            subsets(ques, res, set);
        }
    }

    public static void subsets_optimized(int[] q, int idx, List<Integer> res,  List<List<Integer>> resList){
        resList.add(new ArrayList<>(res));

        for(int i = idx; i < q.length; i++){
            if(i>idx && q[i]==q[i-1])
                continue;
            int el = q[i];
            res.add(el);
            subsets_optimized(q, i + 1, res, resList);
            res.remove(res.size() - 1);
        }
    }

}
