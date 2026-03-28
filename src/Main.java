import linkedList.ListNode;

import java.util.*;

public class Main {
    public static void main(String[] args){
        ListNode list1 = new ListNode(9);
        list1.next = new ListNode(9);
        list1.next.next = new ListNode(9);
        list1.next.next.next = new ListNode(9);
        list1.next.next.next.next = new ListNode(9);
//        list1.next.next.next.next.next = new ListNode(9);
//        list1.next.next.next.next.next.next = new ListNode(9);

        ListNode list2 = new ListNode(9);
        list2.next = new ListNode(9);
        list2.next.next = new ListNode(9);
//        list2.next.next.next = new ListNode(9);
        print(addTwoNumbers(list1, list2));
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode results = new ListNode(0);
        ListNode ptr = results;
        int carry = 0;

        while(l1 != null || l2 != null) {
            int sum = carry;

            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            carry = sum / 10;
            sum = sum % 10;
            ptr.next = new ListNode(sum);
            ptr = ptr.next;
        }
        if (carry == 1) ptr.next = new ListNode(1);
        return results.next;
    }




    public static void print(ListNode list) {
        ListNode cur = list;
        while(cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
    }
}