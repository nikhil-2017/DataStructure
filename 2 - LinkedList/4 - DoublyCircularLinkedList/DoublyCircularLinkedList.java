package com.proglang;

public class DoublyCircularLinkedList {
    private Node head;
    private Node tail;

    public void insertEnd(int data) {
        Node newNode = new Node();
        newNode.data = data;

        if (head==null) {
            head = newNode;
        } else {
            tail.next = newNode;
        }
        newNode.prev = tail;
        tail = newNode;
        tail.next =head;
        head.prev = tail;
    }

    public int deleteEnd() {
        int delData = -1;
        if (head!=null) {
            if (head==tail) {
                delData = head.data;
                head = tail = null;
                return delData;
            } else {

                delData = tail.data;
                tail.prev.next = head;
                tail = tail.prev;
                head.prev = tail;

                return delData;
            }
        } else {
            return -1;
        }
    }

    public int delete(int data) {
        int delLoc=-1;
        if (head!=null) {
            if (head.data == data) {
                head = head.next;
                tail.next = head;
                head.prev = tail;
            } else {
                Node node = head;
                do {
                    delLoc++;
                    if (node.data == data) {
                        if (node == tail) {
                            tail = tail.prev;
                            tail.next = head;
                            head.prev = tail;
                            return delLoc;
                        }
                        node.prev.next = node.next;
                        node.next.prev = node.prev;
                        return delLoc;
                    }
                    node = node.next;
                } while (node != head);
                return -1;
            }
        }
        return -1;
    }

    public void show() {
        Node node = head;
        if (head != null) {
            do {
                System.out.print(node.data + " <-> ");
                node = node.next;
            } while (node != head);
            System.out.println();
        } else {
            System.out.println("The LL is empty.");
        }
    }

    public void showHead() {
        if (head!=null) {
            System.out.println("Head : " + head.data);
        } else {
            System.out.println("The LL is empty.");
        }
    }

    public void showTail() {
        if (tail!=null) {
            System.out.println("Tail : " + tail.data);
        } else {
            System.out.println("The LL is empty.");
        }
    }

    public void showHeadPrev() {
        if (head!=null) {
            System.out.println("Head prev data : " + head.prev.data);
        } else {
            System.out.println("The LL is empty.");
        }
    }

    public void showTailNext() {
        if (tail!=null) {
            System.out.println("Tail next data : " + tail.next.data);
        } else {
            System.out.println("The LL is empty.");
        }
    }

    public int size() {
        int count=0;
        if (head!=null) {
            Node node = head;
            do {
                count++;
                node = node.next;
            } while (node != head);
            return count;
        }
        return count;
    }

    public int search(int data) {
        int dataLoc = -1;
        if (head!=null) {
            Node node = head;
            do {
                dataLoc++;
                if (data == node.data) {
                    return dataLoc;
                }
                node = node.next;
            } while (node != head);
            return -1;
        }
        return dataLoc;
    }

}
