public class Leetcode_RotateList_61 {

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
        ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6))))));

        Leetcode_RotateList_61 l = new Leetcode_RotateList_61();
        int k = 2;
        ListNode head = l.rotateList(l1, k);

        while(head != null){
            System.out.print(head.val + " --> ");
            head = head.next;
        }

    }

    public ListNode rotateList(ListNode l1, int k){
        ListNode head = l1;

        while(l1 != null && k != 0){
            l1 = l1.next;
            k--;
        }

        ListNode toBeDeleted = head;
        while(l1 != null && l1.next != null){
            l1 = l1.next;
            toBeDeleted = toBeDeleted.next;
        }

        ListNode newHead = toBeDeleted.next;
        toBeDeleted.next = null;
        l1.next = head;
        head = newHead;

        return head;

    }
}
