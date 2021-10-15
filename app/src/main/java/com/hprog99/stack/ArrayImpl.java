package com.hprog99.stack;

public class ArrayImpl {
    protected int capacity;
    protected int[] stack;
    protected int top = -1;

    public ArrayImpl(int capacity) {
        this.capacity = capacity;
        this.stack = new int[capacity];
    }

    public int size() {
        return top + 1;
    }

    public boolean isEmpty() {
        return top < 0;
    }

    public int top() throws Exception {
        if (isEmpty()) {
            throw new Exception("Stack is empty");
        }
        return stack[top];
    }

    public void push(int data) throws Exception {
        if (size() == capacity) {
            throw new Exception("Stack is full");
        }
        stack[++top] = data;
    }

    public int pop() throws Exception {
        if (isEmpty()) {
            throw new Exception("Stack is empty");
        }
        int data;
        data = stack[top];
        stack[top--] = Integer.MIN_VALUE;
        return data;
    }

    public String toString() {
        String str = "";
        for (int i = 0; i < top + 1; i++) {
            str += (stack[i] + ", ");
        }
        return str;
    }

    public static void main(String[] args) throws Exception {
        ArrayImpl arrayImpl = new ArrayImpl(10);
        for (int i = 1; i <= 10; i++) {
            arrayImpl.push(i);
        }

        System.out.println("Size => " + arrayImpl.size());

        System.out.println(arrayImpl);
    }
}
