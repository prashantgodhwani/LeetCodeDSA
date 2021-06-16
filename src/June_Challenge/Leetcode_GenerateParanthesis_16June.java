package June_Challenge;

import java.util.ArrayList;
import java.util.List;

public class Leetcode_GenerateParanthesis_16June {

    public static void main(String[] args) {
        List<String> res = generateParenthesis(3, 0, 0, 0, "", 0);
        System.out.println(res);
    }

    public static List<String> generateParenthesis(int n, int idx, int op, int cl, String asf, int curOpen) {
        if(idx == n * 2){
            System.out.println(asf);
            ArrayList<String> bres = new ArrayList<>();
            bres.add(asf);
            return bres;
        }

        List<String> finalRes = new ArrayList<>();
        if(idx == 0){
            finalRes.addAll(generateParenthesis(n, idx + 1, op + 1, cl, asf+"(", curOpen + 1));
        }else{
            if(op <= n - 1)
                finalRes.addAll(generateParenthesis(n, idx + 1, op + 1, cl, asf+"(", curOpen + 1));
            if(cl <= n && curOpen > 0)
                finalRes.addAll(generateParenthesis(n, idx + 1, op, cl + 1, asf+")", curOpen - 1));
        }

        return finalRes;
    }
}
