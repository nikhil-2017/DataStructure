package com.proglang;

public class LinkedList {
    private Node head;
    private Node tail;

    public void push(char data) {
        Node newNode = new Node();
        newNode.data = data;
        newNode.next = null;

        if(head==null) {
            head = tail = newNode;
        } else {
            Node lastNode = tail;

            lastNode.next = newNode;
            tail = newNode;
        }
    }

    public char pop() {

        if(tail == head) {
            head = tail = null;
        } else {
            Node lastNode = tail;
            Node newLastNode = head;

            if(size()>0) {
                while (newLastNode.next != tail) {
                    newLastNode = newLastNode.next;
                }
                tail = newLastNode;
                newLastNode.next = null;
            }
            return lastNode.data;
        }
        return '-';
    }

    public int size() {
        Node node = head;
        int count=0;
        if(head!=null) {
            while (node.next != null) {
                node = node.next;
                count++;
            }
            count++;
        }

        return count;
    }

    public void show() {
        Node node = head;
        while (node.next != null) {
            System.out.print(node.data + "-> ");
            node = node.next;
        }
        System.out.println(node.data);
    }

}