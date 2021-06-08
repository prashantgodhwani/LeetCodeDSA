import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Leetcode_MergeKSortedLists_23 {

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
        ListNode l1 = new ListNode(1, new ListNode(4, new ListNode(5)));
        ListNode l2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode l3 = new ListNode(2, new ListNode(6));
        ListNode[] lists = {l1, l2, l3};

        Leetcode_MergeKSortedLists_23 l = new Leetcode_MergeKSortedLists_23();
        ListNode head = l.mergeKLists(lists);

        while(head != null){
            System.out.println(head.val);
            head = head.next;
        }

    }

        public ListNode mergeKLists(ListNode[] lists) {

            ListNode head = null, curr = null;
            PriorityQueue<ListNode> queue = new PriorityQueue<>((l1, l2) -> l1.val - l2.val);
            for(int i = 0; i < lists.length; i++) {
                while (lists[i] != null) {
                    ListNode node = new ListNode(lists[i].val);
                    queue.add(node);
                    lists[i] = lists[i].next;
                }
            }

            System.out.println(queue);

            int k = 0;
            if(!queue.isEmpty()){
                head = queue.poll();
                curr = head;
            }
            while(!queue.isEmpty()){
                 curr.next = queue.poll();
                 curr = curr.next;
            }

            return head;
        }
}
