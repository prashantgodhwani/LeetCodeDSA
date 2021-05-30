import java.util.*;

public class Leetcode_FindCommonCharacters_1002 {
    public static void main(String[] args) {
        System.out.println(commonChars_optimised(new String[]{"cool","lock","cook"}));
    }

    public static List<String> commonChars_HashMap(String[] A) {
        ArrayList<String> res = new ArrayList<>();
        Map<Character, Integer> sArr1 = new HashMap<>();
        for(char c : A[0].toCharArray()){
            if(sArr1.containsKey(c)){
                sArr1.put(c, sArr1.get(c) + 1);
            }else sArr1.put(c, 1);
        }

        for(int i = 1; i < A.length; i++){
            Map<Character, Integer> sArr2 = new HashMap<>();
            for(char c : A[i].toCharArray()){
                if(sArr2.containsKey(c)){
                    sArr2.put(c, sArr2.get(c) + 1);
                }else sArr2.put(c, 1);
            }

            for(char c : sArr1.keySet()){
                if(sArr2.containsKey(c)) sArr1.put(c, Math.min(sArr1.get(c), sArr2.get(c)));
                else sArr1.put(c, 0);
            }
            System.out.println(sArr1 + ", str = " + A[i]);

        }

        for(char c : sArr1.keySet()){
            for(int j = 0; j < sArr1.get(c); j++){
                res.add(""+c);
            }
        }

        return res;

    }

    public static List<String> commonChars_optimised(String[] A) {
        ArrayList<String> res = new ArrayList<>();
        if (A == null || A.length == 0) return res;
        int[] sArr1 = new int[26];
        for(char c : A[0].toCharArray()){
            sArr1[c - 'a'] += 1;
        }

        for(int i = 1; i < A.length; i++){
            int[] sArr2 = new int[26];
            for(char c : A[i].toCharArray()){
                sArr2[c - 'a'] += 1;
            }

            for(int j = 0; j < 26; j++){
                sArr1[j] = Math.min(sArr1[j], sArr2[j]);
            }
        }

        for(int k = 0; k < sArr1.length; k++){
            String s = Character.toString('a' + k);
            for(int j = 0; j < sArr1[k]; j++){
                res.add(s);
            }
        }

        return res;

    }
}
