package com.proglang;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> document = new ArrayList<>();
        ArrayList<String> redoStack = new ArrayList<>();

        boolean quit = false;
        String data;
        int docSize, redoSize;

        displayOption();
        while (!quit) {
            System.out.print("Enter option : ");
            int action = scanner.nextInt();
            scanner.nextLine();

            switch (action) {
                case 0:
                    displayOption();
                    break;

                case 1:
                    System.out.print("Enter data: ");
                    data = scanner.nextLine();
                    document.add(data);
                    redoStack.clear();
                    break;

                case 2:
                    docSize = document.size();
                    if (docSize > 0) {
                        data = document.remove(docSize - 1);
                        redoStack.add(data);
                    }
                    break;

                case 3:
                    redoSize = redoStack.size();
                    if (redoSize > 0) {
                        data = redoStack.remove(redoSize - 1);
                        document.add(data);
                    }
                    break;

                case 4:
                    docSize = document.size();
                    if (docSize > 0) {
                        for (String i : document) {
                            System.out.print(i + " ");
                        }
                        System.out.println();
                    } else {
                        System.out.println("No data found!!!");
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
        System.out.println("Options :\n" +
                "1: push data\n" +
                "2: undo\n" +
                "3: redo\n" +
                "4: show document\n" +
                "5: exit");
    }
}