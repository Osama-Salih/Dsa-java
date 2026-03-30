package linkedList.reverseLinkedListII;

import linkedList.ListNode;

public class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode preLeft = dummy;
        ListNode currNode = head;

        for (int i = 0; i < left - 1; i++) {
            preLeft = preLeft.next;
            currNode = currNode.next;
        }

        ListNode subListNode = currNode;
        ListNode preNode = null;
        for (int i = 0; i <= right - left; i++) {
            ListNode nextNode = currNode.next;
            currNode.next = preNode;
            preNode = currNode;
            currNode = nextNode;
        }
        preLeft.next = preNode;
        subListNode.next = currNode;
        return dummy.next;
    }
}
