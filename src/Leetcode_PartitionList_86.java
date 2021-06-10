public class Leetcode_PartitionList_86 {

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
        ListNode l1 = new ListNode(3, new ListNode(1, new ListNode(2)));

        Leetcode_PartitionList_86 l = new Leetcode_PartitionList_86();
        int k = 3;
        ListNode head = l.partitionList(l1, k);

        while(head != null){
            System.out.print(head.val + " --> ");
            head = head.next;
        }

    }

    public ListNode partitionList(ListNode l1, int k) {
        ListNode head = l1, curr = l1, prev = new ListNode(-1), newHead = new ListNode(-1), newCurr = newHead;

        while(curr != null){
            System.out.println("curr = " + curr.val + ", prev = " + prev.val);
            if(curr.val < k){
                if(curr == head) head = head.next;
                newCurr.next = curr;
                newCurr = newCurr.next;
                curr = curr.next;
                prev.next = curr;
                newCurr.next = null;
            }else{
                prev = curr;
                curr = curr.next;
            }
        }


        System.out.println("-->" + head);
        if(newCurr != head)
            newCurr.next = head;

        return newHead.next;
    }
}
