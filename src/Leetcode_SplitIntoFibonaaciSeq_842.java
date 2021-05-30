import java.util.ArrayList;
import java.util.List;

public class Leetcode_SplitIntoFibonaaciSeq_842 {

    public static void main(String[] args) {
        List<Integer> res = new ArrayList<>();
        splitIntoFib("123456579", res, 0);
        System.out.println(res);
    }

    private static boolean splitIntoFib(String s, List<Integer> res, int idx){
        System.out.println("res = " + res + ", i = " + idx);
        if(idx == s.length()){
            return res.size() > 2;
        }

        int num = 0;
        for(int i = idx; i < s.length(); i++){
            num = (num * 10 + (s.charAt(i) - '0'));

            if(res.size() >= 2) System.out.println("checking "+res.get(res.size() - 1) + " and " + res.get(res.size() - 2) + " = " + num);
            if(res.size() < 2 || res.get(res.size() - 1) + res.get(res.size() - 2) == num){
                res.add(num);
                if(splitIntoFib(s, res, i + 1)) return true;
                System.out.println("****after return num = " + num);
                res.remove(res.size() - 1);
            }

            if(i == idx && s.charAt(i) == '0') return false;
        }
        return false;
    }
}
