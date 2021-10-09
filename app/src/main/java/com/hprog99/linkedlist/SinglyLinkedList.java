package com.hprog99.linkedlist;

public class SinglyLinkedList {
    private Node head;

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

    public static void main(String[] args) {
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        for (int i = 1; i <= 10; i++) {
            SinglyLinkedList.Node node = singlyLinkedList.new Node(i);
            if (singlyLinkedList.getHead() == null) {
                singlyLinkedList.setHead(node);
            } else {
                SinglyLinkedList.Node currentNode = singlyLinkedList.getHead();
                while (currentNode.getNext() != null) {
                    currentNode = currentNode.getNext();
                }
                currentNode.setNext(node);
            }
        }

        // printList(singlyLinkedList.getHead());

        // insertAtFirst(99, singlyLinkedList);

        // printList(singlyLinkedList.getHead());

        // insertAtLast(-99, singlyLinkedList);

        printList(singlyLinkedList.getHead());

        insertAtPosition(101, 4, singlyLinkedList);

        printList(singlyLinkedList.getHead());

        // removeFirst(singlyLinkedList);

        // printList(singlyLinkedList.getHead());

        // removeLast(singlyLinkedList);

        // printList(singlyLinkedList.getHead());

        removeAtPosition(2, singlyLinkedList);

        printList(singlyLinkedList.getHead());

        System.out.printf("Position found at -> %d\n", getPosition(101, singlyLinkedList));
    }

    public static void printList(Node head) {
        Node currentNode = head;
        while (currentNode != null) {
            System.out.printf("%d -> ", currentNode.getData());
            currentNode = currentNode.getNext();
        }
        System.out.println();
    }

    public static void insertAtFirst(int data, SinglyLinkedList singlyLinkedList) {
        SinglyLinkedList.Node node = singlyLinkedList.new Node(data);
        node.setNext(singlyLinkedList.getHead());
        singlyLinkedList.setHead(node);
    }

    public static void insertAtLast(int data, SinglyLinkedList singlyLinkedList) {
        SinglyLinkedList.Node node = singlyLinkedList.new Node(data);
        Node tailNode = singlyLinkedList.getHead();
        while (tailNode.getNext() != null) {
            tailNode = tailNode.getNext();
        }
        tailNode.setNext(node);
    }

    public static void insertAtPosition(int data, int position, SinglyLinkedList singlyLinkedList) {
        SinglyLinkedList.Node node = singlyLinkedList.new Node(data);
        Node currentNode = singlyLinkedList.getHead();
        for (int i = 1; i < position; i++) {
            currentNode = currentNode.getNext();
        }
        node.setNext(currentNode.getNext());
        currentNode.setNext(node);
    }

    public static Node removeFirst(SinglyLinkedList singlyLinkedList) {
        Node removeFirst = singlyLinkedList.getHead();
        singlyLinkedList.setHead(removeFirst.getNext());
        removeFirst.setNext(null);
        return removeFirst;
    }

    public static Node removeLast(SinglyLinkedList singlyLinkedList) {
        Node currentNode = singlyLinkedList.getHead();
        Node secondLastNode = null;
        while (currentNode.getNext() != null) {
            secondLastNode = currentNode;
            currentNode = currentNode.getNext();
        }
        secondLastNode.setNext(null);
        return currentNode;
    }

    public static Node removeAtPosition(int position, SinglyLinkedList singlyLinkedList) {
        Node currentNode = singlyLinkedList.getHead();
        Node tempNode = null;
        for (int i = 1; i < position; i++) {
            tempNode = currentNode;
            currentNode = currentNode.getNext();
        }
        tempNode.setNext(currentNode.getNext());
        currentNode.setNext(null);
        return currentNode;
    }

    public static int getPosition(int data, SinglyLinkedList singlyLinkedList) {
        int position = 0;
        Node currentNode = singlyLinkedList.getHead();
        while (currentNode != null) {
            if (currentNode.getData() == data) {
                break;
            }
            currentNode = currentNode.getNext();
            position++;
        }
        return position;
    }

}
