package com.proglang;

public class QueueLinkedList {
    private Node head;
    private Node tail; // for reference to the last node

    public void enqueue(int data) {
        Node newNode = new Node();
        newNode.data = data;
        if(head==null) {
            head = tail = newNode;
        } else {
            Node lastNode = tail;
            lastNode.next = newNode;
            tail = newNode;
        }
    }

    public int dequeue() {
        if(head!=null) {
            Node node = head;
            head = node.next;
            return node.data;
        } else {
            System.out.println("Queue is empty");
            return -1;
        }
    }

    public void peek() {
        if(head!=null) {
            System.out.println(head.data);
        } else {
            System.out.println("Queue is empty");
        }
    }

    public void show() {
        if(head!=null) {
            Node node = head;
            while (node.next != null) {
                System.out.print(node.data + " ");
                node = node.next;
            }
            System.out.print(node.data);
            System.out.println();
        } else {
            System.out.println("Queue is empty");
        }
    }

    public int size() {
        int count=0;
        if(head!=null){
            Node node = head;
            while (node.next != null) {
                count++;
                node = node.next;
            }
            count++;
        }
        return count;
    }

}
