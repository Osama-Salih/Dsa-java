package linkedList.copyListWithRandomPointer;

public class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return null;

        Node cur = head;
        while(cur != null) {
            Node newNode = new Node(cur.val);
            newNode.next = cur.next;
            cur.next = newNode;
            cur = newNode.next;
        }

        cur = head;
        while(cur != null) {
            if (cur.random != null)
                cur.next.random = cur.random.next;
            cur = cur.next.next;
        }

        cur = head;
        Node newHead = head.next;
        Node newCur = newHead;
        while(cur != null) {
            cur.next = newCur.next;
            cur = cur.next;
            if (cur != null) {
                newCur.next = cur.next;
                newCur = newCur.next;
            }
        }
        return newHead;
    }

    private static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
