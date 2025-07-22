package leetCode.from141to160;


import java.util.HashMap;

class LRUCache {
    // https://leetcode.cn/problems/lru-cache/ 146
    int capacity;
    class Node {
        int key;
        int value;
        Node next;
        Node prev;
    }
    HashMap<Integer, Node> map;
    Node head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        Node n = map.get(key);
        if (n == null) {
            return -1;
        }
        moveToHead(n);
        return n.value;
    }

    private void moveToHead(Node n) {
        remove(n);
        AddToHead(n);

    }

    private void AddToHead(Node n) {
        head.next.prev = n;
        n.next = head.next;
        n.prev = head;
        head.next = n;
    }

    private void remove(Node n) {
        n.prev.next = n.next;
        n.next.prev = n.prev;
    }

    public void put(int key, int value) {
        Node n = map.get(key);
        if (n == null) {
            if (map.size() == capacity) {
                map.remove(tail.prev.key);
                remove(tail.prev);
            }
            n = new Node();
            n.key = key;
            n.value = value;
            AddToHead(n);
            map.put(key, n);
        } else {
            n.value = value;
            moveToHead(n);
        }
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(2, 1);
        cache.put(1, 1);
        cache.put(2, 3);
        cache.put(4, 1);
        System.out.println(cache.get(1));
        System.out.println(cache.get(2));
        System.out.println(cache.get(4));
    }
}



/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */