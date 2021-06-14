import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class Leetcode_NextGreaterInALinkedList_1019 {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1, new ListNode(7, new ListNode(5, new ListNode(1, new ListNode(9, new ListNode(2, new ListNode(5, new ListNode(1))))))));

        Leetcode_NextGreaterInALinkedList_1019 l = new Leetcode_NextGreaterInALinkedList_1019();
        int[] res = l.nextLargerNodes(l1);

        System.out.println(Arrays.toString(res));
    }

    public int[] nextLargerNodes(ListNode head) {
        Stack<Integer[]> stack = new Stack<>();
        ListNode curr = head;
        int size = 0;
        while (curr != null) {
            curr = curr.next;
            size++;
        }
        int[] res = new int[size];
        int i = 0;

        while (head != null) {
            while (stack.size() > 0 && stack.peek()[1] < head.val) {
                res[stack.peek()[0]] = head.val;
                stack.pop();
            }
            stack.push(new Integer[]{i, head.val});
            i++;
            head = head.next;
            System.out.println("--> "+stack);
            System.out.println(Arrays.toString(res));
        }

        return res;
    }
}
