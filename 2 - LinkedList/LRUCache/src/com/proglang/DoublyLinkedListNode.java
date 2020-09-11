package com.proglang;

public class DoublyLinkedListNode {
    char key;
    int value;
    DoublyLinkedListNode prev;
    DoublyLinkedListNode next;

    public DoublyLinkedListNode(char key, int value) {
        this.key = key;
        this.value = value;
        this.next = null;
        this.prev = null;
    }

    public void removeBindings() {
        if (this.prev != null)
            this.prev.next = this.next;
        if (this.next != null)
            this.next.prev = this.prev;
        this.prev = null;
        this.next = null;
    }
}
