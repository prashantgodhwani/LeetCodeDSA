package Test.BiWeekly53;

import java.util.HashMap;

public class SubstringsOfSizeThreeWithDistinctCharacters {

    public static void main(String[] args) {
        int res= countGoodSubstrings("xyzzaz");
        System.out.println(res);
    }

    public static int countGoodSubstrings(String s) {
        int count = 0;
      for(int i = 0; i <= s.length() - 3; i++){
          if(check(s.substring(i, i + 3))){
              count++;
          }
      }

      return count;
    }

    public static boolean check(String s){
        char[] chars = s.toCharArray();
        HashMap<Character, Integer> freq = new HashMap<>();
        for(char ch : chars){
            if(freq.containsKey(ch)) return false;
            else freq.put(ch, 1);
        }

        return true;
    }
}
