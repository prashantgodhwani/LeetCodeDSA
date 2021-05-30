public class Leetcode_CountSortedVowelStrings_1641 {

    static char[] chars = {'a', 'e', 'i', 'o', 'u'};

    public static void main(String[] args) {
        int n = countVowelStrings(33, 0, 0, "");
        System.out.println();
        System.out.println(n);
    }

    public static int countVowelStrings(int n, int idx, int count, String asf) {
        if(n == 0){
            count++;
            return count;
        }

        for(int i = idx; i < 5; i++){
            count = countVowelStrings(n-1, i, count, asf+chars[i]);
        }
        return count;
    }
}
