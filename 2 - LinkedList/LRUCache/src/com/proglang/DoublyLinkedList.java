package com.proglang;

public class DoublyLinkedList {
    DoublyLinkedListNode head;
    DoublyLinkedListNode tail;

    public void setHeadTo(DoublyLinkedListNode node) {
        if (this.head == node) {
            return;
        } else if (this.head == null) {
            this.head = this.tail = node;
        } else if (this.head == this.tail) {
            this.tail.prev = node;
            this.head = node;
            this.head.next = this.tail;
        } else {
            if (this.tail == node)
                this.removeTail();
            node.removeBindings();
            this.head.prev = node;
            node.next = this.head;
            this.head = node;
        }
    }

    public void removeTail() {
        if (this.tail == null) {
            return;
        }
        if (this.tail == this.head) {
            this.head = this.tail = null;
            return;
        }
        this.tail = this.tail.prev;
        this.tail.next = null;
    }

}
