package src.main.kotlin.leetcode.neetcode;

import java.util.HashMap;
import java.util.Map;

class DoublyNode {
    int val;
    int key;
    DoublyNode next;
    DoublyNode prev;

    public DoublyNode(int key, int val) {
        this.val = val;
        this.key = key;
    }
}

class DoublyLinkedList {
    DoublyNode tail;
    DoublyNode head;

    void insertAfterHead(DoublyNode node) {
        DoublyNode headNext = head.next;
        head.next = node;
        node.prev = head;
        headNext.prev = node;
        node.next = headNext;
    }

    void removeNode(DoublyNode node) {
        DoublyNode prevNode = node.prev;
        DoublyNode nextNode = node.next;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }
}

public class LRUCache {
    Map<Integer, DoublyNode> mp = new HashMap<>();
    DoublyLinkedList list = new DoublyLinkedList();
    int capacity;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        list.head=new DoublyNode(-1,-1);
        list.tail=new DoublyNode(-1,-1);
        list.head.next=list.tail;
        list.tail.prev=list.head;
    }
    public int get(int key) {
        if (!mp.containsKey(key)) {
            return -1;
        }
        DoublyNode node = mp.get(key);
        list.removeNode(node);
        list.insertAfterHead(node);
        return node.val;
    }
    public void put(int key, int value) {
        if (mp.containsKey(key)) {
            DoublyNode node = mp.get(key);
            node.val = value;
            list.removeNode(node);
            list.insertAfterHead(node);
            return;
        } else {
            if (mp.size() == capacity) {
                DoublyNode node = list.tail.prev;
                mp.remove(node.key);
                list.removeNode(node);
            }
        }
        DoublyNode node = new DoublyNode(key, value);
        mp.put(key, node);
        list.insertAfterHead(node);
    }
}
