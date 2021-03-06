public class Leetcode_RemoveNthNodeFromLinkedList_19 {

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

        Leetcode_RemoveNthNodeFromLinkedList_19 l = new Leetcode_RemoveNthNodeFromLinkedList_19();
        int k = 1;
        ListNode head = l.removeNthFromEnd(l1, k);

        while(head != null){
            System.out.println(head.val);
            head = head.next;
        }

    }

    public ListNode removeNthFromEnd(ListNode l1, int k) {
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

        if(toBeDeleted == head && l1 == null){
            head = head.next;
        }else {
            toBeDeleted.next = toBeDeleted.next.next;
        }


        return head;
    }
}
