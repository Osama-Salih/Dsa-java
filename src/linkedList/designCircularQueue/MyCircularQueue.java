package linkedList.designCircularQueue;

public class MyCircularQueue {
    private int[] arr;
    private int front, rear;

    public MyCircularQueue(int k) {
        arr = new int[k];
        front = -1;
        rear = -1;
    }

    public boolean enQueue(int value) {
        if (isFull()) return false;
        else if (isEmpty()) {
            rear = front = 0;
        } else {
            rear = (rear + 1) % arr.length;
        }
        arr[rear] = value;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) return false;
        else if (front == rear) {
            front = rear = -1;
        } else {
            front = (front + 1) % arr.length;
        }
        return true;
    }

    public int Front() {
        if (isEmpty()) return -1;
        return arr[front];
    }

    public int Rear() {
        if (isEmpty()) return -1;
        return arr[rear];
    }

    public boolean isEmpty() {
        return front == -1 && rear == -1;
    }

    public boolean isFull() {
        return (rear + 1) % arr.length == front;
    }
}
