package com.proglang;

import java.util.LinkedList;
import java.util.Scanner;

public class StackList {
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        LinkedList<Integer> intList = new LinkedList<>();
        
        displayOption();
        boolean quit = false;
        while (!quit) {
            System.out.print("choose an option: ");
            int action = scanner.nextInt();
            switch (action) {
                case 0:
                    displayOption();
                    break;
                case 1:
                    System.out.print("element : " );
                    int ele = scanner.nextInt();
                    push(ele, intList);
                    break;
                case 2:
                    pop(intList);
                    break;
                case 3:
                    peek(intList);
                    break;
                case 4:
                    display(intList);
                    break;
                default:
                    quit = true;
                    break;
            }
        }
        scanner.close();
    }

    public static void displayOption() {
        System.out.println("0: show option \n" +
                "1: Push \n" +
                "2: Pop \n" +
                "3: Peek \n" +
                "4: Display\n" +
                "5: exit \n");
    }

    public static void push(int ele, LinkedList<Integer> intList){
        intList.add(ele);
    }

    public static void pop(LinkedList<Integer> intList){
        if(intList.size() <= 0){
            System.out.println("Stack Underflow");
        } else {
            int ind = intList.size()-1;
            System.out.println("Deleted element : " + intList.get(ind) + " at index " + ind);
            intList.remove(ind);
        }
    }

    public static void peek(LinkedList<Integer> intList){
        if(intList.size() <= 0){
            System.out.println("Stack Underflow");
        } else {
            System.out.println(intList.get(intList.size()-1));
        }
    }

    public static void display(LinkedList<Integer> intList){
        if(intList.size() <= 0){
            System.out.println("Stack is Empty");
        } else {
            for(int i=intList.size()-1; i>=0; i--) {
                System.out.print(intList.get(i) + " ");
            }
            System.out.println();
        }
    }
}