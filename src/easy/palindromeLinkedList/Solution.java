package easy.palindromeLinkedList;
import easy.RemoveDuplicatesFromSortedList.ListNode;

public class Solution {

    public boolean isPalindrome(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode temp = reverse(slow.next);
        slow.next = temp;

        ListNode t1 = head;
        ListNode t2 = slow.next;

        while (t2 != null) {
            if (t1.val != t2.val) {
                return false;
            }
            t1 = t1.next;
            t2 = t2.next;
        }
        return true;
    }

    private ListNode reverse(ListNode head) {
        ListNode cur = head;
        ListNode prev = null;
        ListNode temp = null;

        while (cur != null) {
            temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        return prev;
    }
}
