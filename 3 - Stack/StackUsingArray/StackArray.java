package com.proglang;

import java.util.Scanner;

public class StackArray {
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        int n = scanner.nextInt();
        int[] intArray = new int[n];

        int top=-1;

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
                    top = push(ele, intArray, top);
                    break;
                case 2:
                    top = pop(intArray, top);
                    break;
                case 3:
                    peek(intArray, top);
                    break;
                case 4:
                    display(intArray, top);
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

    public static int push(int ele, int[] intArray, int top){
        if(top >= intArray.length){
            System.out.println("Stack Overflow");
            return top;
        } else {
            top++;
            intArray[top] = ele;
        }
        return top;
    }

    public static int pop(int[] intArray, int top){
        if(top < 0){
            System.out.println("Stack Underflow");
            return top;
        } else {
            System.out.println("Deleted element : " + intArray[top] + " at index " + top);
            intArray[top] = -1;
            top--;
        }
        return top;
    }

    public static void peek(int[] intArray, int top){
        if(top < 0){
            System.out.println("Stack Underflow");
        } else {
            System.out.println(intArray[top]);
        }
    }

    public static void display(int[] intArray, int top){
        if(top < 0){
            System.out.println("Stack is Empty");
        } else {
            for(int i= top; i>=0; i--) {
                System.out.print(intArray[i] + " ");
            }
            System.out.println();
        }
    }
}