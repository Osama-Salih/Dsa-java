package easy.reverseLinkedList;

import easy.RemoveDuplicatesFromSortedList.ListNode;

public class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null) return null;

        ListNode curr = head;
        ListNode prev = null;
        ListNode nxt;

        while (curr != null) {
            nxt = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nxt;
        }
        return prev;
    }
}
