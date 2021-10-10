package com.hprog99.linkedlist;

public class CircularSinglyLinkedList {
    private Node tail;

    class Node {
        private Node next;
        private int data;

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

        public Node(int data) {
            this.data = data;
        }
    }

    public Node getTail() {
        return tail;
    }

    public void setTail(Node tail) {
        this.tail = tail;
    }

    public static void main(String[] args) {
        CircularSinglyLinkedList circularSinglyLinkedList = new CircularSinglyLinkedList();
        for (int i = 1; i <= 10; i++) {
            CircularSinglyLinkedList.Node node = circularSinglyLinkedList.new Node(i);
            if (circularSinglyLinkedList.getTail() == null) {
                circularSinglyLinkedList.setTail(node);
                node.setNext(node);
            } else {
                CircularSinglyLinkedList.Node currentNode = circularSinglyLinkedList.getTail();
                node.setNext(currentNode.getNext());
                currentNode.setNext(node);
                circularSinglyLinkedList.setTail(node);
            }
        }

        printList(circularSinglyLinkedList);

        insertFirst(99, circularSinglyLinkedList);

        printList(circularSinglyLinkedList);

        insertLast(101, circularSinglyLinkedList);

        printList(circularSinglyLinkedList);

        insertAtPosition(-91, 3, circularSinglyLinkedList);

        printList(circularSinglyLinkedList);

        removeFirst(circularSinglyLinkedList);

        printList(circularSinglyLinkedList);

        removeLast(circularSinglyLinkedList);

        printList(circularSinglyLinkedList);
    }

    public static void printList(CircularSinglyLinkedList circularSinglyLinkedList) {
        Node temp = circularSinglyLinkedList.getTail().getNext();
        do {
            System.out.printf("%d -> ", temp.getData());
            temp = temp.getNext();
        } while (temp != circularSinglyLinkedList.getTail().getNext());
        System.out.println("");
    }

    public static void insertFirst(int data, CircularSinglyLinkedList circularSinglyLinkedList) {
        CircularSinglyLinkedList.Node node = circularSinglyLinkedList.new Node(data);
        node.setNext(circularSinglyLinkedList.getTail().getNext());
        circularSinglyLinkedList.getTail().setNext(node);
    }

    public static void insertLast(int data, CircularSinglyLinkedList circularSinglyLinkedList) {
        CircularSinglyLinkedList.Node node = circularSinglyLinkedList.new Node(data);
        node.setNext(circularSinglyLinkedList.getTail().getNext());
        circularSinglyLinkedList.getTail().setNext(node);
        circularSinglyLinkedList.setTail(node);
    }

    public static void insertAtPosition(int data, int position, CircularSinglyLinkedList circularSinglyLinkedList) {
        CircularSinglyLinkedList.Node node = circularSinglyLinkedList.new Node(data);
        Node currentNode = circularSinglyLinkedList.getTail().getNext();
        for (int i = 1; i < position; i++) {
            currentNode = currentNode.getNext();
        }
        node.setNext(currentNode.getNext());
        currentNode.setNext(node);
    }

    public static Node removeFirst(CircularSinglyLinkedList circularSinglyLinkedList) {
        Node removedNode = circularSinglyLinkedList.getTail().getNext();
        circularSinglyLinkedList.getTail().setNext(removedNode.getNext());
        removedNode.setNext(null);
        return removedNode;
    }

    public static Node removeLast(CircularSinglyLinkedList circularSinglyLinkedList) {
        Node removedNode = circularSinglyLinkedList.getTail();
        Node tailNode = removedNode.getNext();
        while (tailNode.getNext() != removedNode) {
            tailNode = tailNode.getNext();
        }
        tailNode.setNext(removedNode.getNext());
        circularSinglyLinkedList.setTail(tailNode);
        removedNode.setNext(null);
        return removedNode;
    }
}
