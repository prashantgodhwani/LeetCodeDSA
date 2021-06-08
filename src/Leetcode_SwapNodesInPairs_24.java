public class Leetcode_SwapNodesInPairs_24 {

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
        ListNode l1 = new ListNode(1);

        Leetcode_SwapNodesInPairs_24 l = new Leetcode_SwapNodesInPairs_24();
        ListNode head = l.swapPairs(l1, 0);

        while(head != null){
            System.out.println(head.val);
            head = head.next;
        }

    }

    private ListNode swapPairs(ListNode l1, int idx) {

        if(l1==null || l1.next == null) return l1;

        ListNode temp = l1.next.next;
        ListNode head = null;
        l1.next.next = l1;
        if(idx == 0){
            head = l1.next;
        }
        ListNode r = l1.next;
        l1.next = swapPairs(temp, idx + 1);

        if(idx == 0){
            return head;
        }
        return r;
    }
}
