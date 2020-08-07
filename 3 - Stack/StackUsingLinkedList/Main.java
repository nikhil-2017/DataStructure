package com.proglang;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	    // stack using singly LinkedList
        // create node class -
        // to store that instance to the StackLinkedList class to make stack using linked list
        // we insert data from front (top) because to saved the time complexity og pop operation (O(n) to O(1))
        // operations: push(), pop(), peek(), show(), size()
        Scanner scanner = new Scanner(System.in);
        StackLinkedList stack = new StackLinkedList();
        boolean quit = false;

        displayOption();
        while (!quit) {
            System.out.print("choose option : ");
            int action = scanner.nextInt();
            switch (action) {
                case 0:
                    displayOption();
                    break;
                case 1:
                    System.out.print("Enter data : ");
                    int data = scanner.nextInt();
                    stack.push(data);
                    break;
                case 2:
                    int delData = stack.pop();
                    if(delData>0) {
                        System.out.println("Deleted Data : " + delData);
                    }
                    break;
                case 3:
                    stack.peek();
                    break;
                case 4:
                    stack.show();
                    break;
                case 5:
                    System.out.println(stack.size());
                    break;
                default:
                    quit=true;
                    break;
            }
        }

        scanner.close();
    }

    public static void displayOption() {
        System.out.println("Stack Operations\n" +
                            "0: display options\n" +
                            "1: Push\n" +
                            "2: Pop\n" +
                            "3: Peek\n" +
                            "4: Show\n" +
                            "5: Size\n" +
                            "6: quit (press >= 6)");
    }
}
