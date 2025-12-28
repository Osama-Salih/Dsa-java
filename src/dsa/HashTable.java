package dsa;
import java.util.ArrayList;
import java.util.List;

public class HashTable {
    private int size = 53;
    List<Entry>[] keyMap;

    public HashTable() {
        this.keyMap = new ArrayList[size];
    }

    public HashTable(int size) {
        this.keyMap = new ArrayList[size];
    }

    public int hash(String key) {
        int total = 0;
        int WEIRD_PRIME = 31;

        for (int i = 0; i < Math.min(key.length(), 100); i++) {
            char ch = key.charAt(i);
            int value = (int) ch - 96;
            total = (total * WEIRD_PRIME + value) % this.keyMap.length;

        }
        return total;
    }

    public void set(String key, String value) {
        String keyLower = key.toLowerCase();
        int index = hash(keyLower);

        if (this.keyMap[index] == null) {
            this.keyMap[index] = new ArrayList<>();
        }
        this.keyMap[index].add(new Entry(keyLower, value));
    }

    public String get(String key) {
       String keyLower = key.toLowerCase();
       List<Entry> entryList = this.keyMap[hash(keyLower)];

       if (entryList != null) {
          for (Entry entry : entryList) {
              if (entry.key.equals(keyLower)) {
                  return entry.value;
              }
          }
       }
       return null;
    }

    public List<String> keys() {
       List<String> keyList = new ArrayList<>();
       for (int i = 0; i < this.keyMap.length; i++) {
           if (keyMap[i] != null) {
               for (Entry entry : keyMap[i]) {
                   if (!keyList.contains(entry.key)) {
                       keyList.add(entry.key);
                   }
               }
           }
       }
       return keyList;
    }

    public List<String> values() {
        List<String> valuesList = new ArrayList<>();
        for (int i = 0; i < this.keyMap.length; i++) {
            if (keyMap[i] != null) {
                for (Entry entry : keyMap[i]) {
                    if (!valuesList.contains(entry.value)) {
                        valuesList.add(entry.value);
                    }
                }
            }
        }
        return valuesList;
    }
}