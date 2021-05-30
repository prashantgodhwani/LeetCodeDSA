import java.util.ArrayList;

public class Leetcode_MinStack_155 {

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        minStack.push(4);
        minStack.push(-5);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
        System.out.println(minStack.top());
    }

}

class MinStack {

    ArrayList<Integer> stack;
    ArrayList<Integer> minAtIndex;
    int tos = -1, min = 0, length = -1;

    /** initialize your data structure here. */
    public MinStack() {
        stack = new ArrayList<>();
        minAtIndex = new ArrayList<>();
        tos = 0;
        min = Integer.MAX_VALUE;
    }

    public void push(int val) {
        if(val < min) min = val;
        stack.add(val);
        minAtIndex.add(min);
        length++;
    }

    public void pop() {
        stack.remove(length);
        minAtIndex.remove(length);
        min = minAtIndex.get(length - 1);
        length--;
    }

    public int top() {
        return stack.get(length);
    }

    public int getMin() {
        return minAtIndex.get(length);
    }
}

