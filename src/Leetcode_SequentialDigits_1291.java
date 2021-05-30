public class Leetcode_SequentialDigits_1291 {

    public static void main(String[] args) {
        for(int i = 1; i <= 9; i++) {
            sequentialDigits(100, 300, i, 0);
        }
    }

    public static void sequentialDigits(int low, int high, int st, int res) {
        if(res >= low){
            System.out.println(res);
        }


        res = res * 10 + (st);
        if(res <= high && st + 1 <= 9)
            sequentialDigits(low, high, st + 1, res);

    }
}
