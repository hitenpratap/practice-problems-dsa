package com.hprog99.queue;

public class CircularArrayQueue {
    private int capacity;
    private int[] queue;
    private int size, front, rear = 0;

    public CircularArrayQueue(int capacity) {
        this.capacity = capacity;
        this.queue = new int[capacity];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public void enqueue(int data) {
        if (isFull()) {
            throw new IllegalStateException("Queue is full");
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
        return data;
    }

    public String toString() {
        String str = "";
        for (int i = 0; i < size; i++) {
            str += queue[i] + ", ";
        }
        return str;
    }

    public static void main(String[] args) {
        CircularArrayQueue arrayQueue = new CircularArrayQueue(10);
        for (int i = 1; i <= 10; i++) {
            arrayQueue.enqueue(i);
        }

        System.out.println(arrayQueue);

        System.out.printf("Size => %d, Front => %d, Rear => %d\n", arrayQueue.size, arrayQueue.front, arrayQueue.rear);

        arrayQueue.dequeue();
        arrayQueue.dequeue();

        System.out.println(arrayQueue);

        System.out.printf("Size => %d, Front => %d, Rear => %d\n", arrayQueue.size, arrayQueue.front, arrayQueue.rear);
    }
}
