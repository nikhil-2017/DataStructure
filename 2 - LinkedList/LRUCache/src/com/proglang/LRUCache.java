package com.proglang;

import java.util.HashMap;

public class LRUCache {

    HashMap<Character, DoublyLinkedListNode> cache = new HashMap<>();
    int maxSize;
    int currentSize;
    DoublyLinkedList listOfMostRecent = new DoublyLinkedList();

    public LRUCache(int maxSize) {
        this.maxSize = maxSize;
        this.currentSize = 0;
    }

    public void insertKeyValuePair(char key, int value) {
        if (!cache.containsKey(key)) {
            if (this.currentSize == maxSize) {
                this.evictLeastRecent();
            } else {
                this.currentSize++;
            }
            DoublyLinkedListNode node = new DoublyLinkedListNode(key, value);
            this.listOfMostRecent.setHeadTo(node);
            this.cache.put(key, node);
        }
        else {
            this.replaceKey(key, value);
        }
        this.updateMostRecent(this.cache.get(key));
    }

    public int getValueFromKey(char key)  {
        if (!this.cache.containsKey(key))
            return -1;
        return this.cache.get(key).value;
    }

    public void displayCacheKeyValuePair() {
        DoublyLinkedListNode node = listOfMostRecent.head;
        while (node != null) {
            System.out.print("{" + node.key + ":" + node.value + "} ");
            node = node.next;
        }
        System.out.println();
    }

    public char getMostLeastRecent() {
        return this.listOfMostRecent.head.key;
    }

    public char getLeastRecent() {
        return this.listOfMostRecent.tail.key;
    }

    public void evictLeastRecent() {
        char keyToRemove = this.listOfMostRecent.tail.key;
        this.listOfMostRecent.removeTail();
        this.cache.remove(keyToRemove);
    }

    public void updateMostRecent(DoublyLinkedListNode node) {
        this.listOfMostRecent.setHeadTo(node);
    }

    public void replaceKey(char key, int value) {
        this.cache.get(key).value = value;
    }
}
