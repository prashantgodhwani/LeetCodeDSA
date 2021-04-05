/*
Given the head of a singly linked list, return true if it is a palindrome.
Input: head = [1,2,2,1]
Output: true
*/

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class Leetcode_PalindromeLL_234 {
    public static void main(String[] args) {
        ListNode l5 = new ListNode(1, null);
        ListNode l4 = new ListNode(2, l5);
        ListNode l3 = new ListNode(3, l4);
        ListNode l2 = new ListNode(2, l3);
        ListNode l1 = new ListNode(1, l2);

        System.out.println(isPalindrome(l1));
    }

    public static boolean isPalindrome(ListNode head) {

        if(head.next == null || head == null) return true;

        ListNode slow = head, fast = head;

        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }

        slow = reverseLL(slow);
        fast = head;

        while(slow != null){
            if(fast.val != slow.val) return false;
            fast = fast.next;
            slow = slow.next;
        }

        return true;
    }

    private static ListNode reverseLL(ListNode curr) {
        ListNode prev = null, next = null;
        while (curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }
}
