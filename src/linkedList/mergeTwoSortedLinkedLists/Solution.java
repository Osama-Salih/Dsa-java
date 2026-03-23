package linkedList.mergeTwoSortedLinkedLists;

import linkedList.ListNode;

public class Solution {
    public ListNode merge(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        ListNode cur1 = list1;
        ListNode cur2 = list2;

        while(cur1 != null && cur2 != null) {
            if (cur1.val < cur2.val) {
                tail.next = cur1;
                cur1 = cur1.next;
            } else {
                tail.next = cur2;
                cur2 = cur2.next;
            }
            tail = tail.next;
        }

        tail.next = cur1 != null ? cur1 : cur2;
        return dummy.next;
    }
}
