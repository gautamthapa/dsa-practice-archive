package com.gautamthapa.javapractice.collection;

class Node {
    private int data;
    private Node next;

    public Node() {
        this.data = 0;
        this.next = null;
    }

    public Node(int data, Node next) {
        this.data = data;
        this.next = next;
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
}

class LinkedList {
    private int size;
    private Node start;

    public LinkedList() {
        size = 0;
        start = null;
    }

    public void insertAtFirst(int val) {
        Node n = new Node();
        n.setData(val);
        n.setNext(start);
        start = n;
        size++;
    }

    public boolean isEmpty() {
        if (start == null)
            return true;
        else
            return false;
    }

    public int getListSize() {
        return (size);
    }

    public void viewList() {
        Node n;
        if (isEmpty()) {
            System.out.println(start.getData());
        } else {
            n = start;
            for (int i = 1; i <= size; i++) {
                System.out.print(" " + n.getData());
                n = n.getNext();
            }
        }
    }

}

public class OwnLinkedList {
    public static void main(String[] args) {

    }
}
