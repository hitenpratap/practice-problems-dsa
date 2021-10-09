package com.hprog99.linkedlist;

public class DoublyLinkedList {
    private Node head;

    class Node {
        private Node next;
        private Node prev;
        private int data;

        public Node(int data) {
            this.data = data;
        }

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Node getPrev() {
            return prev;
        }

        public void setPrev(Node prev) {
            this.prev = prev;
        }
    }

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public static void main(String[] args) {
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        for (int i = 1; i <= 10; i++) {
            DoublyLinkedList.Node node = doublyLinkedList.new Node(i);
            if (doublyLinkedList.getHead() == null) {
                doublyLinkedList.setHead(node);
            } else {
                DoublyLinkedList.Node currentNode = doublyLinkedList.getHead();
                while (currentNode.getNext() != null) {
                    currentNode = currentNode.getNext();
                }
                currentNode.setNext(node);
                node.setPrev(currentNode);
            }
        }

        printList(doublyLinkedList.getHead());

        insertAtFirst(99, doublyLinkedList);

        printList(doublyLinkedList.getHead());

        insertAtLast(101, doublyLinkedList);

        printList(doublyLinkedList.getHead());

        insertAtPosition(-11, 4, doublyLinkedList);

        printList(doublyLinkedList.getHead());

        removeFirst(doublyLinkedList);

        printList(doublyLinkedList.getHead());

        removeLast(doublyLinkedList);

        printList(doublyLinkedList.getHead());

        removeAtPosition(2, doublyLinkedList);

        printList(doublyLinkedList.getHead());
    }

    public static void printList(Node head) {
        Node currentNode = head;
        while (currentNode != null) {
            System.out.printf("%d -> ", currentNode.getData());
            currentNode = currentNode.getNext();
        }
        System.out.println();
    }

    public static void insertAtFirst(int data, DoublyLinkedList doublyLinkedList) {
        DoublyLinkedList.Node node = doublyLinkedList.new Node(data);
        Node head = doublyLinkedList.getHead();
        node.setNext(head);
        head.setPrev(node);
        doublyLinkedList.setHead(node);
    }

    public static void insertAtLast(int data, DoublyLinkedList doublyLinkedList) {
        Node currentNode = doublyLinkedList.getHead();
        while (currentNode.getNext() != null) {
            currentNode = currentNode.getNext();
        }
        DoublyLinkedList.Node node = doublyLinkedList.new Node(data);
        node.setPrev(currentNode);
        currentNode.setNext(node);
    }

    public static void insertAtPosition(int data, int position, DoublyLinkedList doublyLinkedList) {
        Node currentNode = doublyLinkedList.getHead();
        for (int i = 1; i < position; i++) {
            currentNode = currentNode.getNext();
        }
        DoublyLinkedList.Node node = doublyLinkedList.new Node(data);
        node.setNext(currentNode.getNext());
        currentNode.getNext().setPrev(node);
        node.setPrev(currentNode);
        currentNode.setNext(node);
    }

    public static Node removeFirst(DoublyLinkedList doublyLinkedList) {
        Node removedNode = doublyLinkedList.getHead();
        doublyLinkedList.setHead(removedNode.getNext());
        removedNode.getNext().setPrev(null);
        removedNode.setNext(null);
        return removedNode;
    }

    public static Node removeLast(DoublyLinkedList doublyLinkedList) {
        Node removedNode = doublyLinkedList.getHead();
        while (removedNode.getNext() != null) {
            removedNode = removedNode.getNext();
        }
        removedNode.getPrev().setNext(null);
        removedNode.setPrev(null);
        return removedNode;
    }

    public static Node removeAtPosition(int position, DoublyLinkedList doublyLinkedList) {
        Node removedNode = doublyLinkedList.getHead();
        for (int i = 1; i < position; i++) {
            removedNode = removedNode.getNext();
        }
        removedNode.getPrev().setNext(removedNode.getNext());
        removedNode.getNext().setPrev(removedNode.getPrev());
        removedNode.setNext(null);
        removedNode.setPrev(null);
        return removedNode;
    }
}
