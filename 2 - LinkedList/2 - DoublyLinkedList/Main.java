package com.proglang;

public class Main {

    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();

        list.insertEnd(12);
        list.insertEnd(13);
        list.insertEnd(15);
        list.insertEnd(13);
        list.insertEnd(12);
//        list.insertEnd(19);
        list.insertFront(20);
        list.insertFront(99);
        list.show();
        list.showHead();
        list.showTail();
        list.reversedShow();

        System.out.println(list.showSize());

        list.isPalindrome();

        System.out.println("deleted number : " + list.deleteEnd());
        list.show();

        System.out.println("deleted number : " + list.deleteFront());
        list.show();

        list.showHead();
        list.showTail();

        list.reverse();

        list.show();

        System.out.println(list.searchEle(20));
        System.out.println(list.searchEle(50));

        list.insertBefore(2, 70);
        list.show();

        list.insertAfter(2, 80);
        list.show();

        list.insertAfter(0, 90);
        list.show();

        System.out.println(list.deleteAt(2));
        list.show();
    }
}