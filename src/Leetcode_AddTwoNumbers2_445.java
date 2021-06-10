import java.util.Stack;

public class Leetcode_AddTwoNumbers2_445 {

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
        ListNode l1 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9))));
        ListNode l2 = new ListNode(9, new ListNode(9, new ListNode(9)));

        Leetcode_AddTwoNumbers2_445 l = new Leetcode_AddTwoNumbers2_445();
        ListNode head = l.addTwoLists(l1, l2);

        while(head != null){
            System.out.print(head.val + " --> ");
            head = head.next;
        }

    }

    private ListNode addTwoLists(ListNode l1, ListNode l2) {
        Stack<Integer> one  = new Stack<>();
        Stack<Integer> two = new Stack<>();

        while(l1 != null){
            one.push(l1.val);
            ListNode l = l1;
            l1 = l1.next;
            l.next = null;
        }

        while(l2 != null){
            two.push(l2.val);
            ListNode l = l2;
            l2 = l2.next;
            l.next = null;
        }

        ListNode head = new ListNode(-1);
        int carry = 0;
        while(one.size() > 0 && two.size() > 0){
            int o = one.pop();
            int t = two.pop();
            System.out.println(o + t + carry);
            int sum = o + t + carry;
            if(sum > 9){
                carry = 1;
            }else carry = 0;

            ListNode node = new ListNode(sum % 10);
            node.next = head.next;
            head.next = node;
        }

        while(one.size() > 0){
            int n = carry + one.pop();
            ListNode node = new ListNode((n) % 10);
            if(n > 9) carry = 1;
            else carry = 0;
            node.next = head.next;
            head.next = node;
        }

        while (two.size() > 0){
            int n = carry + two.pop();
            ListNode node = new ListNode((n) % 10);
            if(n > 9) carry = 1;
            else carry = 0;
            node.next = head.next;
            head.next = node;
        }

        if(carry == 1){
            ListNode node = new ListNode(1);
            node.next = head.next;
            head.next = node;
        }

        return head.next;
    }
}
