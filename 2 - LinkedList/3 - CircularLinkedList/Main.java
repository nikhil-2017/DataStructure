package com.proglang;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CircularLinkedList list = new CircularLinkedList();

        boolean quit=false;
        int data, delData;

        displayOption();
        while (!quit) {
            System.out.print("Enter option : ");
            int action = scanner.nextInt();

            switch (action) {
                case 0:
                    displayOption();
                    break;
                case 1:
                    System.out.print("Enter Data : ");
                    data = scanner.nextInt();
                    list.insertEnd(data);
                    break;
                case 2:
                    delData = list.deleteEnd();
                    if (delData==-1) {
                        System.out.println("The LinkedList is empty.");
                    } else {
                        System.out.println("Deleted Data : " + delData);
                    }
                    break;
                case 3:
                    delData = list.delete(scanner.nextInt());
                    if (delData==-1) {
                        System.out.println("The number is not in LL or the LL is empty.");
                    } else {
                        System.out.println("Deleted Data : " + delData);
                    }
                    break;
                case 4:
                    list.show();
                    break;
                case 5:
                    System.out.println("Size of list : " + list.size());
                    break;
                case 6:
                    list.showHead();
                    break;
                case 7:
                    list.showTail();
                    break;
                case 8:
                    list.showLastNodeNext();
                    break;
                case 9:
                    int dataLoc = list.search(scanner.nextInt());
                    if (dataLoc == -1) {
                        System.out.println("The element is not exist in an LL");
                    } else {
                        System.out.println("The position of element in LL is " + dataLoc);
                    }
                    break;
                default:
                    quit=true;
                    break;
            }
        }
        scanner.close();
    }

    public static void displayOption() {
        String[] options = {"Display Option", "InsertAtEnd", "DeleteAtEnd", "Delete Number", "show", "size", "headElement", "tailElement", "lastNodeNext", "Search Number", "Quit"};
        System.out.println("Circular LinkedList Option :");

        for (int i=0; i< options.length; i++) {
            System.out.println(i + ": " + options[i]);
        }
    }
}