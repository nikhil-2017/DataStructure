package com.proglang;

public class DoublyLinkedList {
    private Node head;
    private Node tail;

    public void insertEnd(int data) {
        Node newNode = new Node();

        newNode.next = null;
        newNode.data = data;

        if (head == null) {
            newNode.prev = null;
            head = tail = newNode;
        } else {
            Node lastNode = tail;

            lastNode.next = newNode;
            newNode.prev = lastNode;

            tail = newNode;
            tail.prev = lastNode;
        }
    }

    public void insertFront(int data) {
        Node newNode = new Node();
        Node frontNode = head;

        newNode.data = data;

        newNode.next = frontNode;
        newNode.prev = null;

        head = newNode;
        frontNode.prev = newNode;

    }

    public void insertBefore(int ind, int data) {
        if(ind==0) {
            insertFront(data);
        } else if(ind == showSize()+1) {
            insertEnd(data);
        } else if(ind > 0 && ind <= showSize()+1) {
            Node node = head;
            int count=0;
            while (count!=ind){
                count++;
                node = node.next;
            }
            Node newNode = new Node();
            newNode.data = data;

            node.prev.next = newNode;
            newNode.prev = node.prev;
            newNode.next = node;
            node.prev = newNode;
        }

    }

    public void insertAfter(int ind, int data) {
        if (ind == showSize() + 1) {
            insertEnd(data);
        } else if (ind >= 0 && ind <= showSize() + 1) {
            insertBefore(ind+1, data);
        }
    }

    public void reverse() {
        int n = showSize();
        int half = n/2, count=0, tmp;

        Node node1 = head;
        Node node2 = tail;

        while (count!=half){
            tmp = node1.data;
            node1.data = node2.data;
            node2.data = tmp;

            node1 = node1.next;
            node2 = node2.prev;
            count++;
        }

    }

    public int deleteEnd() {
        int deleteData = tail.data;
        Node prevNode = tail.prev;
        prevNode.next = null;

        tail = prevNode;
        tail.prev = prevNode.prev;

        return deleteData;
    }

    public int deleteFront() {
        int deleteData = head.data;
        Node nextNode = head;

        head = nextNode.next;
        nextNode.next.prev = null;

        return deleteData;
    }

    public int deleteAt(int ind) {
        if (ind == 0) {
            return deleteFront();
        } else if (ind == showSize()-1) {
            return deleteEnd();
        } else if (ind > 0 && ind < showSize()) {
            Node node = head;
            int count = 0;
            while (count != ind) {
                count++;
                node = node.next;
            }

            node.prev.next = node.next;
            node.next.prev = node.prev;

            return node.data;
        } else {
            System.out.println("Index out of range");
            return -1;
        }
    }

    public void show() {
        Node node = head;
        while (node.next!=null){
            System.out.print(node.data + " ->");
            node = node.next;
        }
        System.out.println(node.data);
    }

    public void reversedShow() {
        Node node = tail;
        while (node.prev != null) {
            System.out.print(node.data + " ->");
            node = node.prev;
        }
        System.out.print(node.data);
        System.out.println();
    }

    public void showHead() {
        System.out.println("Head next : " + head.data);
        System.out.println("Head prev : " + head.prev);
    }

    public void showTail() {
        System.out.println("Tail next : " + tail.data);
        System.out.println("Tail prev : " + tail.prev.data);
    }

    public int showSize() {
        int count=0;
        Node node = head;
        if(head!=null){
            count++;
            while (node.next!=null){
                count++;
                node = node.next;
            }
        }
        return count;
    }

    private boolean checkPalindrome(){
        int n = showSize();
        int half = n/2;

        int count=0;
        Node node1 = head;
        Node node2 = tail;

        while (count!=half){
            if(node1.data != node2.data){
                return false;
            }
            node1 = node1.next;
            node2 = node2.prev;
            count++;
        }
        return true;
    }

    public void isPalindrome() {
        if(checkPalindrome()){
            System.out.println("List is palindrome.");
        } else {
            System.out.println("List is not palindrome.");
        }
    }

    // linear search - O(n)
    public boolean searchEle(int element) {
        Node node = head;
        while (node.next != null) {
            if(node.data == element){
                return true;
            }
            node = node.next;
        }
        if(node.data == element) {
            return true;
        }
        return false;
    }
}