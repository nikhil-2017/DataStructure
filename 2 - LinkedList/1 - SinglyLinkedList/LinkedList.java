package com.proglang;

public class LinkedList {
    private Node head;
    private Node tail;

    public void insertEnd(int data) {
        Node node = new Node();

        node.data = data;
        node.next = null; // by default

        if (head==null){
            head = tail = node;
        } else {
            Node n = tail;
            n.next = node;
            tail = node;
        }
    }

    public void insertFront(int data){
        Node newNode = new Node();
        newNode.data = data;

        newNode.next = head;
        head = newNode;
    }

    public void insertBefore(int ind, int data) {
        if(ind==0){
            insertFront(data);
        } else if(ind==listSize()){
            insertEnd(data);
        } else if(ind>0 && ind<listSize()){

            Node newNode = new Node();
            newNode.data = data;

            Node prevNode = head;
            Node nextNode = head;

            Node[] nodes = findNodes(ind, prevNode, nextNode);

            prevNode = nodes[0];
            nextNode = nodes[1];

            prevNode.next = newNode;
            newNode.next = nextNode;

        } else{
            System.out.println("Index : " + ind + " is out of Range!");
        }
    }

    public void insertAfter(int ind, int data){
        if(ind==0){
            insertBefore(ind+1, data);
        } else if(ind==listSize()){
            insertEnd(data);
        } else if(ind>0 && ind<listSize()){
            insertBefore(ind+1, data);
        }
    }

    public void deleteFront(){
        Node node = head;
        head = node.next;
    }

    public void deleteEnd() {
        Node node = head;
        while (node.next!=tail){
            node = node.next;
        }
        tail = node;
        node.next = null;
    }

    public void deleteAt(int ind) {
        if(ind==0) {
            deleteFront();
        } else if(ind==listSize()-1) {
            deleteEnd();
        } else if(ind>0 && ind<listSize()-1) {
            Node prevNode = head;
            Node atNode = head;

            Node[] nodes = findNodes(ind, prevNode, atNode);

            prevNode = nodes[0];
            atNode = nodes[1];

            prevNode.next = atNode.next;

        } else {
            System.out.println("Index is out of Range!");
        }
    }

    public void show(){
        Node node = head;
        while (node.next!=null) {
            System.out.print(node.data + " -> ");
            node = node.next;
        }
        System.out.println(node.data);
    }

    public void showTail(){
        System.out.println(tail.data);
    }

    public void showHead(){
        System.out.println(head.data);
    }

    public int listSize(){
        int count = 0;
        Node node = head;

        if(head!=null){
            count++;
            while (node.next != null) {
                count++;
                node = node.next;
            }
        }

        return count;
    }

    public Node[] findNodes(int ind, Node prevNode, Node nextNode) {
        Node[] nodes = new Node[2];
        int count=0;
        while (count!=ind) {
            if(count>=1){
                prevNode = prevNode.next;
            }
            count++;
            nextNode = nextNode.next;
        }

        nodes[0] = prevNode;
        nodes[1] = nextNode;

        return nodes;
    }

}