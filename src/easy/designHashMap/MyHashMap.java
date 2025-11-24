package easy.designHashMap;

public class MyHashMap {

    private final ListNode []map;
    private final int ARRAY_SIZE = 1000;

    public MyHashMap() {
        map = new ListNode[ARRAY_SIZE];
        for (int i = 0; i < ARRAY_SIZE; i++) {
            map[i] = new ListNode();
        }
    }

    public int hash(int key) {
        return key % ARRAY_SIZE;
    }

    public void put(int key, int value) {
        ListNode cur = map[hash(key)];
        while (cur.next != null) {
            if(cur.next.key == key) {
                cur.next.val = value;
                return;
            }
            cur = cur.next;
        }

        cur.next = new ListNode(key, value, null);
    }

    public int get(int key) {
       ListNode cur = map[hash(key)].next;
       while (cur != null) {
           if (cur.key == key) {
               return cur.val;
           }
           cur = cur.next;
       }
       return -1;
    }

    public void remove(int key) {
      ListNode cur = map[hash(key)];
      while (cur.next != null) {
          if (cur.next.key == key) {
              cur.next = cur.next.next;
              return;
          }
          cur = cur.next;
      }
    }
}