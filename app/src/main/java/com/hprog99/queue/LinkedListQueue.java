package com.hprog99.queue;

public class LinkedListQueue {
    private int size;
    private Node front, rear;

    class Node {
        Node next;
        int data;

        public Node(int data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }
    }

    public Node getFront() {
        return this.front;
    }

    public void setFront(Node front) {
        this.front = front;
    }

    public Node getRear() {
        return this.rear;
    }

    public void setRear(Node rear) {
        this.rear = rear;
    }

    public void enqueue(int data) {
        Node node = new Node(data);
        if (size == 0) {
            this.setFront(node);
        } else {
            Node rear = this.getRear();
            rear.setNext(node);
        }
        this.setRear(node);
        size++;
    }

    public int dequeue() {
        if (size == 0) {
            throw new IllegalStateException("Queue is empty");
        }
        Node front = this.getFront();
        int data = front.getData();
        this.setFront(front.getNext());
        front.setNext(null);
        return data;
    }

    public String toString() {
        String str = "";
        Node current = this.getFront();
        while (current != null) {
            str += current.getData() + ", ";
            current = current.getNext();
        }
        return str;
    }

    public static void main(String[] args) {
        LinkedListQueue arrayQueue = new LinkedListQueue();
        for (int i = 1; i <= 10; i++) {
            arrayQueue.enqueue(i);
        }

        System.out.println(arrayQueue);

        arrayQueue.dequeue();

        System.out.println(arrayQueue);

        arrayQueue.enqueue(11);

        System.out.println(arrayQueue);
    }
}
