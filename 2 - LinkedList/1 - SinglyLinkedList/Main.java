package com.proglang;

public class Main {

    public static void main(String[] args) {

    	// LinkedList using tail pointer

	    LinkedList list = new LinkedList();
	    list.insertEnd(18);
	    list.insertEnd(20);
	    list.insertEnd(50);

	    list.show();

	    list.showTail();
	    list.showHead();

//	    list.deleteFront();

		list.insertFront(10);

		list.showHead();
		list.show();

		System.out.println(list.listSize());

//		list.deleteEnd();

		list.show();
		list.showTail();

		list.insertBefore(1, 55);
		list.show();
		list.insertBefore(3, 66);
		list.show();
//		list.insertBefore(0, 12); // check head insertFront
//		list.insertBefore(6, 99); // check the last ind using listSize() and then add it to the last
//		list.insertBefore(10, 100); // out of Range

		list.insertAfter(0, 77);
		list.insertAfter(4, 23);
//		list.insertAfter(1, 67);
//		list.insertAfter(4, 88);
		list.show();

		list.deleteAt(2);
		list.show();

	}
}
