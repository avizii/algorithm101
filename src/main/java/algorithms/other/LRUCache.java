package algorithms.other;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author : Avizii
 * @Create : 2021.03.10
 */
public class LRUCache {

    private final int capacity;

    private int size;

    private final Map<Integer, Node> cache;

    private final Node head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>(capacity);
        this.head = new Node();
        this.tail = new Node();
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        Node node = cache.get(key);
        if (node == null) return -1;
        moveToHead(node);
        return node.value;
    }

    private void moveToHead(Node node) {
        removeNode(node);
        addToHead(node);
    }

    private void addToHead(Node node) {
        Node next = head.next;
        node.pre = head;
        node.next = next;
        head.next = node;
        next.pre = node;
    }

    private void removeNode(Node node) {
        Node preNode = node.pre;
        Node nextNode = node.next;
        preNode.next = nextNode;
        nextNode.pre = preNode;
    }

    public void put(int key, int value) {
        Node node = cache.get(key);
        if (node == null) {
            if (size + 1 > capacity) {
                Node tail = removeTail();
                cache.remove(tail.key);
            } else size++;
            node = new Node(key, value);
            addToHead(node);
            cache.put(key, node);
        } else {
            node.value = value;
            moveToHead(node);
        }
    }

    private Node removeTail() {
        Node node = tail.pre;
        removeNode(node);
        return node;
    }

    class Node {

        int key;

        int value;

        Node pre;

        Node next;

        Node() {}

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

}
