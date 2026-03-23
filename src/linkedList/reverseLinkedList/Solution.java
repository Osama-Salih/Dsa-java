package linkedList.reverseLinkedList;
import linkedList.ListNode;

public class Solution {
    // Iteration
    public ListNode reverseList(ListNode head) {
        ListNode current = head;
        if (current == null || current.next == null) return new ListNode();

        ListNode next = null;
        ListNode prev = null;
        while(current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return current;
    }
//    // Recursion
//    public ListNode reverseList(ListNode head) {
//        if (head == null) {
//            return null;
//        }
//
//        ListNode newHead = head;
//        if (head.next != null) {
//            newHead = reverseList(head.next);
//            head.next.next = head;
//        }
//        head.next = null;
//        return newHead;
//    }
}
