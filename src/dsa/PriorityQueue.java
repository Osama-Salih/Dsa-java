package dsa;
import java.util.ArrayList;
import java.util.List;

public class PriorityQueue {
    private List<Nodee> heap;

    public PriorityQueue() {
        heap = new ArrayList<>();
    }

    public void enqueue(String val, int priority) {
        Nodee newNode = new Nodee(val, priority);
        heap.add(newNode);

        int index = heap.size() - 1;
        while(index > 0) {
            int parentIndex = (index - 1) / 2;
            if (heap.get(parentIndex).priority <= heap.get(index).priority) {
                break;
            }
            swap(parentIndex, index, heap);
            index = parentIndex;
        }
    }

    public Nodee dequeue() {
        if (heap.isEmpty()) {
            throw new IllegalStateException("Heap is empty");
        }

        swap(0, heap.size() - 1, heap);
        Nodee min = heap.removeLast();

        int index = 0;
        int size = heap.size();
        while(true) {
            int left = 2 * index + 1;
            int right = 2 * index + 2;
            int smallest = index;

            if (left < size && heap.get(left).priority < heap.get(smallest).priority) {
                smallest = left;
            }
            if (right < size && heap.get(right).priority < heap.get(smallest).priority) {
                smallest = right;
            }
            if (smallest == index) {
                break;
            }
            swap(smallest, index, heap);
            index = smallest;
        }
        return min;
    }

    private void swap(int childIndex, int parentIndex, List<Nodee> heap) {
        Nodee temp = heap.get(parentIndex);
        heap.set(parentIndex, heap.get(childIndex));
        heap.set(childIndex, temp);
    }
}