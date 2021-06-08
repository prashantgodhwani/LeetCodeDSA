public class Leetcode_RemoveDuplicatesFromLinkedList_83 {

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
        ListNode l1 = new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(3)))));

        Leetcode_RemoveDuplicatesFromLinkedList_83 l = new Leetcode_RemoveDuplicatesFromLinkedList_83();
        ListNode head = l.removeDuplicates(l1);

        while(head != null){
            System.out.print(head.val + " --> ");
            head = head.next;
        }

    }

    private ListNode removeDuplicates(ListNode l1) {
        ListNode curr = l1, head = curr;

        while(curr != null && l1 != null) {
            while (l1 != null && l1.val == curr.val) {
                l1 = l1.next;
            }
            curr.next = l1;
            curr = curr.next;
        }

        return head;
    }


}
