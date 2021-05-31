import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class Leetcode_Smallest_Subsequence_of_distinct_chars_1081 {

    public static void main(String[] args) {
        String res = smallestSubsequence2("bcabc");
        System.out.println(res);
    }

    public static String smallestSubsequence(String s) {
        Stack<Character> chStack = new Stack<>();
        HashMap<Character, Integer> map = new HashMap<>();
        HashMap<Character, Boolean> boolMap = new HashMap<>();

        for(char ch : s.toCharArray()){
            int freq = map.getOrDefault(ch, 0) + 1;
            map.put(ch, freq);
            boolMap.put(ch, true);
        }

        for(char ch : s.toCharArray()){

            if(!boolMap.get(ch)){
                map.put(ch, map.get(ch) - 1);
                continue;
            }

            if(chStack.size() == 0 && boolMap.get(ch)){
                chStack.push(ch);
                map.put(ch, map.get(ch) - 1);
                boolMap.put(ch, false);
            }else{
                while(chStack.size() > 0 && ch < chStack.peek() && map.get(chStack.peek()) > 0){
                    char c = chStack.pop();
                    boolMap.put(c, true);
                }
                if(boolMap.get(ch)){
                    chStack.push(ch);
                    boolMap.put(ch, false);
                    map.put(ch, map.get(ch) - 1);
                }
            }
            System.out.println(chStack);
            System.out.println(map);
            System.out.println(boolMap);
        }

        StringBuilder res = new StringBuilder();
        while (chStack.size() > 0){
            res.insert(0, chStack.pop());
        }

        return res.toString();
    }

    public static String smallestSubsequence2(String s) {
        Stack<Character> chStack = new Stack<>();
        int[] map = new int[26];
        boolean[] boolMap = new boolean[26];

        for(char ch : s.toCharArray()){
            map[ch - 'a']++;
            boolMap[ch - 'a'] = true;
        }

        for(char ch : s.toCharArray()){

            if(!boolMap[ch - 'a']){
                map[ch - 'a']--;
                continue;
            }

            if(chStack.size() == 0 && boolMap[ch - 'a']){
                chStack.push(ch);
                map[ch - 'a']--;
                boolMap[ch - 'a'] = false;
            }else{
                while(chStack.size() > 0 && ch < chStack.peek() && map[chStack.peek() - 'a'] > 0){
                    char c = chStack.pop();
                    boolMap[c - 'a'] = true;
                }
                if(boolMap[ch - 'a']){
                    chStack.push(ch);
                    boolMap[ch - 'a'] = false;
                    map[ch - 'a']--;
                }
            }
            System.out.println(chStack);
            System.out.println(Arrays.toString(map));
            System.out.println(Arrays.toString(boolMap));
        }

        StringBuilder res = new StringBuilder();
        while (chStack.size() > 0){
            res.insert(0, chStack.pop());
        }

        return res.toString();
    }
}
