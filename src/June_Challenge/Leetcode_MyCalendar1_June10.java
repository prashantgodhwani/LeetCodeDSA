package June_Challenge;

import java.util.Arrays;
import java.util.LinkedList;

public class Leetcode_MyCalendar1_June10 {

    public static void main(String[] args) {
        MyCalendar obj = new MyCalendar();
        System.out.println(obj.book(47, 50));
        System.out.println(obj.book(33, 41));
        System.out.println(obj.book(39, 45));
        System.out.println(obj.book(33, 42));
        System.out.println(obj.book(25, 32));
        System.out.println(obj.book(26, 35));
        System.out.println(obj.book(19, 25));
        System.out.println(obj.book(3, 8));
        System.out.println(obj.book(8, 13));
        System.out.println(obj.book(18, 27));
    }

    static class MyCalendar {

        public static class ListNode {
            int[] val;
            ListNode next;

            ListNode() {
            }

            ListNode(int[] val) {
                this.val = val;
            }

            ListNode(int[] val, ListNode next) {
                this.val = val;
                this.next = next;
            }

            @Override
            public String toString() {
                return "ListNode{" +
                        "val=" + Arrays.toString(val) +
                        ", next=" + next +
                        '}';
            }
        }

        ListNode head = null;

        public MyCalendar() {
            head = new ListNode(new int[]{-1, -1});
        }

        public boolean book(int start, int end) {
            ListNode curr = head, prev = head;
            while(curr != null){
                if(curr.val[0] < start){
                    prev = curr;
                    curr = curr.next;
                }else break;
            }


            if(start >= prev.val[1] && (curr == null || end <= curr.val[0])){
                ListNode temp = prev.next;
                prev.next = new ListNode(new int[]{start, end}, temp);
                return true;
            }else {
                return false;
            }
        }

        private void showLL() {
            System.out.println(head);
        }
    }
}
