public class Leetcode_SortList_148 {

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
        ListNode l1 = new ListNode(-1, new ListNode(5, new ListNode(3, new ListNode(4, new ListNode(0)))));

        Leetcode_SortList_148 l = new Leetcode_SortList_148();
        ListNode head = l.sortList(l1);

        while(head != null){
            System.out.print(head.val + " --> ");
            head = head.next;
        }

    }

    private ListNode sortList(ListNode l1) {
        System.out.println(l1);

        if(l1 == null || l1.next == null){
            return l1;
        }

        ListNode mid = getMid(l1);
        System.out.println(mid.val);
        ListNode right = sortList(mid.next);
        mid.next = null;
        ListNode left = sortList(l1);

        return mergeSortedLists(left, right);
    }

    private ListNode mergeSortedLists(ListNode left, ListNode right) {
        ListNode dummyHead = new ListNode();
        ListNode tail = dummyHead;
        while (left != null && right != null) {
            if (left.val < right.val) {
                tail.next = left;
                left = left.next;
                tail = tail.next;
            } else {
                tail.next = right;
                right = right.next;
                tail = tail.next;
            }
        }
        tail.next = (left != null) ? left : right;
        return dummyHead.next;
    }

    private ListNode getMid(ListNode l1) {
        ListNode slow = l1, fast = l1;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return (slow.next == null) ? l1 : slow;
    }
}
