package com.hprog99.queue;

public class DynamicCircularArrayQueue {
    private int capacity;
    private int front, rear, size;
    private int[] queue;

    public DynamicCircularArrayQueue(int capacity) {
        this.capacity = capacity;
        this.queue = new int[capacity];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return capacity == size;
    }

    public void enqueue(int data) {
        if (isFull()) {
            expand();
        }
        size++;
        queue[rear] = data;
        rear = (rear + 1) % capacity;
    }

    public int dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        size--;
        int data = queue[front];
        queue[front] = Integer.MIN_VALUE;
        front = (front + 1) % capacity;
        shrink();
        return data;
    }

    public void expand() {
        int[] array = new int[capacity << 1];
        System.arraycopy(queue, 0, array, 0, size);
        queue = array;
        front = 0;
        rear = size - 1;
        capacity = capacity << 1;
    }

    public void shrink() {
        if (size < capacity / 2) {
            int[] array = new int[capacity / 2];
            System.arraycopy(queue, 0, array, 0, size);
            queue = array;
            front = 0;
            rear = size - 1;
            capacity = capacity / 2;
        }
    }

    public static void main(String[] args) {
        DynamicCircularArrayQueue arrayQueue = new DynamicCircularArrayQueue(10);
        for (int i = 1; i <= 10; i++) {
            arrayQueue.enqueue(i);
        }

        System.out.println(arrayQueue);

        System.out.printf("Size => %d, Front => %d, Rear => %d, Capacity => %d\n", arrayQueue.size, arrayQueue.front,
                arrayQueue.rear, arrayQueue.capacity);

        arrayQueue.enqueue(-1);

        System.out.println(arrayQueue);

        System.out.printf("Size => %d, Front => %d, Rear => %d, Capacity => %d\n", arrayQueue.size, arrayQueue.front,
                arrayQueue.rear, arrayQueue.capacity);

        arrayQueue.dequeue();
        arrayQueue.dequeue();

        System.out.println(arrayQueue);

        System.out.printf("Size => %d, Front => %d, Rear => %d, Capacity => %d\n", arrayQueue.size, arrayQueue.front,
                arrayQueue.rear, arrayQueue.capacity);
    }
}
