package com.proglang;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Queue using singly LinkedList
        // create node class -
        // to store that instance to the QueueLinkedList class to make queue using linked list
        // we insert data at the end and we use tail pointer to get reference of last node insert TC - O(n) & SC - O(1)
        // operations: enqueue(), dequeue(), peek(), show(), size()

        Scanner scanner = new Scanner(System.in);
        QueueLinkedList queue = new QueueLinkedList();
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
                    queue.enqueue(data);
                    break;
                case 2:
                    int delData = queue.dequeue();
                    if(delData>0) {
                        System.out.println("Deleted Data : " + delData);
                    }
                    break;
                case 3:
                    queue.peek();
                    break;
                case 4:
                    queue.show();
                    break;
                case 5:
                    System.out.println(queue.size());
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
