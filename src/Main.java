import linkedList.ListNode;

public class Main {
    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(4);

        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(4);
//        print(mergeTwoLists(list1, list2));
    }

    public static void print(ListNode list) {
        ListNode cur = list;
        while(cur != null) {
            System.out.println(cur.val);
            cur = cur.next;
        }
    }
}