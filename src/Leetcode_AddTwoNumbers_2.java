public class Leetcode_AddTwoNumbers_2 {

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
        ListNode l1 = new ListNode(9, new ListNode(9, new ListNode(9)));
        ListNode l2 = new ListNode(9, new ListNode(9));

        Leetcode_AddTwoNumbers_2 l = new Leetcode_AddTwoNumbers_2();
        ListNode head = l.addTwoNumbers(l1, l2);

        while(head != null){
            System.out.println(head.val);
            head = head.next;
        }

    }

    private ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode curr = head;

        int carry = 0;
        ListNode node = null;
        while(l1 != null && l2 != null){
            if(l1.val + l2.val + carry > 9){
                node = new ListNode((l1.val + l2.val + carry) % 10);
                carry = 1;
            }else {
                node = new ListNode(l1.val + l2.val + carry);
                carry = 0;
            }
            curr.next = node;
            curr = curr.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        while(l1 != null){
            if(l1.val + carry > 9){
                node = new ListNode((l1.val + carry) % 10);
                carry = 1;
            }else {
                node = new ListNode(l1.val+ carry);
                carry = 0;
            }
            curr.next = node;
            curr = curr.next;
            l1 = l1.next;
        }

        while(l2 != null){
            if(l2.val + carry > 9){
                node = new ListNode((l2.val + carry) % 10);
                carry = 1;
            }else {
                node = new ListNode(l2.val+ carry);
                carry = 0;
            }
            curr.next = node;
            curr = curr.next;
            l2 = l2.next;
        }

        if(carry == 1){
            curr.next = new ListNode(1);
        }
        return head.next;
    }
}
