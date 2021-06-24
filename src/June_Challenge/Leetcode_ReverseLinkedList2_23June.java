package June_Challenge;

public class Leetcode_ReverseLinkedList2_23June {
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }


    public static ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode leftP = new ListNode(-1, head);
        int tempLeft = left;

        if(head.next ==null || left == right){
            return head;
        }
        if(left == 1){
            head = leftP;
        }else {
            leftP = leftP.next;
            while (left - 2 > 0) {
                leftP = leftP.next;
                left--;
            }
        }

        ListNode rightP = leftP.next;
        ListNode newHead = rightP;
        ListNode newTail = newHead;
        ListNode temp = rightP.next;
        newHead.next = null;
        right = right - tempLeft;
        while(right > 0 && temp != null){
            rightP = temp;
            temp = rightP.next;
            rightP.next = newHead;
            newHead = rightP;
            right--;
        }
        leftP.next.next = temp;

        leftP.next = newHead;

        return (tempLeft == 1 ) ? head.next : head;
    }

    public static void main(String[] args) {
        ListNode l5 = new ListNode(5, null);
        ListNode l4 = new ListNode(4, l5);
        ListNode l3 = new ListNode(3, l4);
        ListNode l2 = new ListNode(2, l3);
        ListNode l1 = new ListNode(1, l2);

        ListNode res = reverseBetween(l1, 3, 4);
        while(res != null){
            System.out.println(res.val);
            res = res.next;
        }
    }
}
