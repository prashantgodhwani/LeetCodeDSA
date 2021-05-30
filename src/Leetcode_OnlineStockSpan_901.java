import java.util.Arrays;
import java.util.Stack;

public class Leetcode_OnlineStockSpan_901 {

    public static void main(String[] args) {
        StockSpanner stockSpanner = new StockSpanner();
        System.out.println(stockSpanner.next(100));
        System.out.println(stockSpanner.next(80));
        System.out.println(stockSpanner.next(60));
        System.out.println(stockSpanner.next(70));
        System.out.println(stockSpanner.next(60));
        System.out.println(stockSpanner.next(75));
        System.out.println(stockSpanner.next(85));
//        System.out.println(stockSpanner.next(110));
    }

}


class StockSpanner {

    Stack<int[]> nums;
    // Stack<Integer> counts;
    int size;

    public StockSpanner() {
        nums = new Stack<>();
        // counts = new Stack<>();
        size = 0;
    }

    public int next(int price) {
        int count = 1;
        while (size > 0 && nums.peek()[0] <= price) {
            System.out.println(nums.peek()[0]);
            count += nums.pop()[1];
            size--;
        }
        System.out.println(Arrays.toString(new int[]{price, count}));
        nums.push(new int[]{price, count});
        size++;
        return count;
    }
}
