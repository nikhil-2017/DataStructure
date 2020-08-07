package com.proglang;

public class StackLinkedList {
    Node head;

    public void push(int data) {
        Node newNode = new Node();
        newNode.data  = data;

        // if the stack is empty and head is null
        if(head==null){
            head = newNode;    // // declare/reference the head to newNode
        }else {
            // declare head (top) element
            Node node = head;

            newNode.next = node;    // newNode next reference to previous top/head node
            head = newNode;     // declare/reference the head to newNode
        }

    }

    public int pop() {
        if(head!=null) {
            Node node = head;   // reference to the head next node
            head = node.next;   // declare/reference the head to node of next
            return node.data;   // front node is dereference and then remove from garbage collector
        } else {
            System.out.println("stack is empty");
            return -1;
        }
    }

    public void peek() {
        if(head != null) {
            System.out.println(head.data);  // display topmost element
        } else {
            System.out.println("stack is empty");
        }

    }

    // display all stack element
    public void show() {
        if(head != null){
            Node node = head;
            while (node.next != null) {
                System.out.print(node.data + " ");
                node = node.next;
            }
            System.out.print(node.data);
            System.out.println();
        } else {
            System.out.println("stack is empty");
        }
    }

    // return stack size
    public int size() {
        int count = 0;
        if(head!=null) {
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
