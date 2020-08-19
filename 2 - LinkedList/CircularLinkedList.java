package com.proglang;

public class CircularLinkedList {
    private Node head;
    private Node tail;

    public void insertEnd(int data) {
        Node newNode = new Node();
        newNode.data = data;

        if(head==null) {
            head = newNode;
        } else{
            tail.next = newNode;
        }
        tail = newNode;
        newNode.next = head;
    }

//    TODO: deleteEnd is not work properly
    public int deleteEnd() {
        Node node = head;
        int delNode;
        if (head != null) {
            if (head == tail) {
                delNode = node.data;
                head = tail = null;
                return delNode;
            } else {
                delNode = tail.data;
                while (node.next != tail) {
                    node = node.next;
                }
                tail = node;
                tail.next = head;
                return delNode;
            }
        } else {
            return -1;
        }
    }

    public int delete(int data) {
        int delLoc, count=-1;
        if (head!=null) {
            delLoc  = search(data);
            if (delLoc>=0) {
                if (delLoc==0) {
                    head = head.next;
                    tail.next = head;
                } else {
                    Node currentNode = head;
                    Node nextNode;
                    do {
                        count++;
                        nextNode = currentNode.next;
                        if (count==delLoc-1) {
                            currentNode.next = nextNode.next;
                            if (delLoc==size()) {
                                tail = currentNode;
                            }
                            break;
                        }
                        currentNode = currentNode.next;
                    } while (currentNode != head);
                }
            } else {
                return -1;
            }
        }
        return -1;
    }

    public void showHead() {
        if (head != null) { System.out.println("head : " + head.data); }
        else { System.out.println("The LL is empty"); }
    }

    public void showTail() {
        if (tail != null) { System.out.println("tail : " + tail.data); }
        else { System.out.println("The LL is empty"); }
    }

    public void showLastNodeNext() {
        if (tail != null) { System.out.println("lastNode.next ->" + tail.next.data); }
        else { System.out.println("The LL is empty"); }
    }

    public void show() {
        Node node = head;
        if (head!=null) {
            do {
                System.out.print(node.data + " -> ");
                node = node.next;
            } while (node != head);
            System.out.println();
        } else {
            System.out.println("The LL is empty.");
        }
    }

    public int size() {
        int count = 0;
        Node node = head;
        if(head!=null) {
            while(node.next != head) {
                count++;
                node = node.next;
            }
            count++;
        }
        return count;
    }

    public int search(int data) {
        int ind=-1;
        Node node = head;
        if (head==null) {
            return -1;
        } else {
            do {
                ind++;
                if (node.data == data) {
                    return ind;
                }
                node = node.next;
            } while (node != head);
        }
        return -1;
    }

}