package dsa;
import java.util.List;

public class MaxBinaryHeap {
    public void insert(int val, List<Integer> list) {
        if (list.isEmpty()) return;
        list.add(val);

        int index = list.size() - 1;
        int parentIndex = (index - 1) / 2;

        while(parentIndex >= 0 && list.get(parentIndex) < list.get(index)) {
            int temp = list.get(parentIndex);
            list.set(parentIndex, list.get(index));
            list.set(index, temp);

            index = parentIndex;
            parentIndex = (index - 1) / 2;
        }
    }
    public int extractMax(List<Integer> list) {
        if (list.isEmpty()) {
            throw new IllegalStateException("Heap is empty");
        }
        swap(0, list.size() - 1, list);
        int max = list.remove(list.size() - 1);

        int index = 0;
        int size = list.size();
        while (true) {
            int left = 2 * index + 1;
            int right = 2 * index + 2;
            int largest = index;

            if (left < size && list.get(left) > list.get(largest)) {
                largest = left;
            }
            if (right < size && list.get(right) > list.get(largest)) {
                largest = right;
            }
            if (largest == index) {
                break;
            }
            swap(index, largest, list);
            index = largest;
        }
        return max;
    }
    private void swap(int childIndex, int parentIndex, List<Integer> list) {
        int temp = list.get(parentIndex);
        list.set(parentIndex, list.get(childIndex));
        list.set(childIndex, temp);
    }
}