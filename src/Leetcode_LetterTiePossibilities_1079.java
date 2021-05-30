import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Leetcode_LetterTiePossibilities_1079 {

    public static void main(String[] args) {
        Set<String> res= new HashSet<>();
        int[] freq = new int[26];
        for(char ch : "AAABBC".toCharArray()){
            freq[ch-'A']++;
        }
        System.out.println(Arrays.toString(freq));
        int count = numTilePossibilities2("AAABBC", 0, freq, 0);
        System.out.println(count);
    }

    public static void numTilePossibilities(String tiles, String asf, Set<String> res) {
        if(tiles.equals("")){
            if(!asf.equals("")) res.add(asf);
            return;
        }

        int[] set = new int[26];

        for(int i = 0; i < tiles.length(); i++) {
            char ch = tiles.charAt(i);
            if(set[ch-'A'] == 0) {
                set[ch-'A']++;
                String qsf = tiles.substring(0, i) + tiles.substring(i + 1);
                numTilePossibilities(qsf, asf + ch, res);
                numTilePossibilities(qsf, asf, res);
            }
        }
    }

    public static int numTilePossibilities2(String tiles, int level, int[] freq, int count) {
        if(level == tiles.length()){
            return count;
        }

        for(int i = 0; i < 26; i++){
            if(freq[i] <= 0) continue;
            freq[i]--;
            count++;
            count = numTilePossibilities2(tiles, level+1, freq, count);
            freq[i]++;
        }

        return count;
    }
}
