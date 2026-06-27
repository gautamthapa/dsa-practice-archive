package com.gautamthapa.coding;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    class Node {
        int key, value;
        Node prev, next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private final int capacity;
    private final Map<Integer, Node> cache;

    private final Node head;
    private final Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();

        head = new Node(0, 0);
        tail = new Node(0, 0);

        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        Node node = cache.get(key);

        if (node == null)
            return -1;

        remove(node);
        insertAtFront(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            node.value = value;

            remove(node);
            insertAtFront(node);
            return;
        }

        if (cache.size() == capacity) {
            Node lru = tail.prev;
            remove(lru);
            cache.remove(lru.key);
        }

        Node newNode = new Node(key, value);
        insertAtFront(newNode);
        cache.put(key, newNode);
    }

    private void insertAtFront(Node node) {
        node.next = head.next;
        node.prev = head;

        head.next.prev = node;
        head.next = node;
    }

    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    static void main() {
        LRUCache cache=new LRUCache(2);
        cache.put(1,10);
        cache.put(1,20);

        System.out.println(cache.get(1)); // 10

        cache.put(3, 30);

        System.out.println(cache.get(2)); // -1

        cache.put(4, 40);

        System.out.println(cache.get(1)); // -1

        System.out.println(cache.get(3)); // 30

        System.out.println(cache.get(4)); // 40
    }
}
