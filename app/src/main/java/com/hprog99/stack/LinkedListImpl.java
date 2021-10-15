package com.hprog99.stack;

import org.w3c.dom.Node;

public class LinkedListImpl {
    private Node head;
    private int length;

    class Node {
        private int data;
        private Node next;

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

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public int size() {
        return length;
    }

    public boolean isEmpty() {
        return length == 0;
    }

    public void push(int data) {
        Node node = new Node(data);
        Node current = head;
        node.setNext(current);
        setHead(node);
        length++;
    }

    public int pop() throws Exception {
        if (size() == 0) {
            throw new Exception("Stack is empty");
        }
        Node current = head;
        setHead(current.getNext());
        length--;
        return current.getData();
    }

    public int peek() throws Exception {
        if (size() == 0) {
            throw new Exception("Stack is empty");
        }
        return head.getData();
    }

    public String toString() {
        String str = "";
        Node current = head;
        while (current != null) {
            str += current.getData() + ", ";
            current = current.getNext();
        }
        return str;
    }

    public static void main(String[] args) throws Exception {
        LinkedListImpl listImpl = new LinkedListImpl();
        for (int i = 1; i <= 10; i++) {
            listImpl.push(i);
        }

        System.out.println(listImpl.toString());

        System.out.println("Top element => " + listImpl.peek());

        listImpl.pop();

        System.out.println(listImpl.toString());
    }
}
