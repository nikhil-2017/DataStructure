package com.proglang;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();

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
                    queue.add(ele);
                    break;
                case 2:
                    if (queue.size()>0) {
                        System.out.println("delData : " + queue.poll());
                    } else {
                        System.out.println("The queue is empty");
                    }
                    break;
                case 3:
                    if (queue.size()>0) {
                        System.out.println("front Data : " + queue.peek());
                    } else {
                        System.out.println("The queue is empty");
                    }
                    break;
                case 4:
                    if (queue.size()>0) {
                        System.out.println(queue);
                    } else {
                        System.out.println("The queue is empty");
                    }
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
                "1: Enqueue \n" +
                "2: Dequeue \n" +
                "3: Peek \n" +
                "4: Display\n" +
                "5: exit \n");
    }
}
