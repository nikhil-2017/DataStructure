package com.proglang;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // using ArrayList & Composition
        Scanner scanner = new Scanner(System.in);
        MinMaxStack stack = new MinMaxStack();

        boolean quit = false;

        displayOption();
        while (!quit) {
            System.out.print("Enter option: ");
            int action = scanner.nextInt();
            switch (action) {
                case 0:
                    displayOption();
                    break;

                case 1:
                    System.out.print("Enter number : ");
                    int num = scanner.nextInt();
                    stack.push(num);
                    break;

                case 2:
                    int delNum = stack.pop();
                    if (delNum==-1)
                        System.out.println("The stack is empty.");
                    else
                        System.out.println("Deleted Data : " + delNum);
                    break;

                case 3:
                    stack.displayMinMaxPeek();
                    break;

                default:
                    quit = true;
                    break;
            }

        }

        scanner.close();
    }

    public static void displayOption() {
        String[] options = {"options", "push", "pop", "display: Min Max Peek", "quit"};
        System.out.println("MinMaxStack Operations: ");
        for (int i=0; i<options.length; i++) {
            System.out.println(i + ". " + options[i]);
        }
    }
}
