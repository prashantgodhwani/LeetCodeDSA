public class Leetcode_RemoveDuplicatesFromSortedList2_82 {

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
        ListNode l1 = new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(3, new ListNode(4))))));

        Leetcode_RemoveDuplicatesFromSortedList2_82 l = new Leetcode_RemoveDuplicatesFromSortedList2_82();
        ListNode head = l.removeDuplicates2(l1);

        while(head != null){
            System.out.print(head.val + " --> ");
            head = head.next;
        }

    }

    private ListNode removeDuplicates2(ListNode l1) {
        ListNode curr = l1, head = new ListNode(-1), newCurr = head;

        while(curr != null) {
            int c = 0;
            while (l1 != null && l1.val == curr.val) {
                l1 = l1.next;
                c++;
            }
            if(c == 1){
                newCurr.next = new ListNode(curr.val);
                newCurr = newCurr.next;
            }
            curr.next = l1;
            curr = curr.next;
        }

        return head.next;
    }
}
