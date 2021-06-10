public class Leetcode_SwapNodes_1721 {

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
        ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));

        Leetcode_SwapNodes_1721 l = new Leetcode_SwapNodes_1721();
        int k = 4;
        ListNode head = l.swapNodes(l1, k);

        while(head != null){
            System.out.print(head.val + " --> ");
            head = head.next;
        }

    }

    private ListNode swapNodes(ListNode l1, int k) {

        ListNode n1 = l1, slow = l1, fast = l1;

        while(k != 1){
            fast = fast.next;
            k--;
        }

        n1 = fast;

        while (fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }

        ListNode n2 = slow;

        int val = n1.val;
        n1.val = slow.val;
        slow.val = val;

        return l1;
    }
}
