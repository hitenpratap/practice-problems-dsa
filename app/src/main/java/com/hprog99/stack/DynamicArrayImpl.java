package com.hprog99.stack;

public class DynamicArrayImpl {
    protected int capacity;
    protected int[] stack;
    protected int top = -1;

    public DynamicArrayImpl(int capacity) {
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
            expand();
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
        shrink();
        return data;
    }

    public void expand() {
        int[] newArray = new int[capacity << 1];
        System.arraycopy(stack, 0, newArray, 0, size());
        capacity = capacity << 1;
        stack = newArray;
    }

    public void shrink() {
        if (size() < capacity / 2) {
            int[] newArray = new int[capacity / 2];
            System.arraycopy(stack, 0, newArray, 0, size());
            capacity = newArray.length;
            stack = newArray;
        }
    }

    public String toString() {
        String str = "";
        for (int i = 0; i < size(); i++) {
            str += (stack[i] + ", ");
        }
        return str;
    }

    public static void main(String[] args) throws Exception {
        DynamicArrayImpl arrayImpl = new DynamicArrayImpl(10);
        for (int i = 1; i <= 10; i++) {
            arrayImpl.push(i);
        }

        System.out.println("Size => " + arrayImpl.size() + " & capacity => " + arrayImpl.capacity);

        System.out.println(arrayImpl);

        arrayImpl.push(99);

        System.out.println("Size => " + arrayImpl.size() + " & capacity => " + arrayImpl.capacity);

        System.out.println(arrayImpl.pop());

        System.out.println("Size => " + arrayImpl.size() + " & capacity => " + arrayImpl.capacity);

        System.out.println(arrayImpl.pop());

        System.out.println("Size => " + arrayImpl.size() + " & capacity => " + arrayImpl.capacity);
    }
}
