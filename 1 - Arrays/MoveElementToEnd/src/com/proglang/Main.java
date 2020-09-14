package com.proglang;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter elements in an array: ");
        String[] s = scanner.nextLine().split(" ");
        int[] array = Arrays.stream(s).mapToInt(Integer::parseInt).toArray();

        System.out.print("Enter Move element: ");
        int toMove = scanner.nextInt();

        moveElementToEnd(array, toMove);
        displayResult(array);

        scanner.close();
    }

    public static void displayResult(int[] array) {
        System.out.println(Arrays.toString(array));
    }

    public static void moveElementToEnd(int[] array, int toMove) {
        int i = 0;
        int j = array.length - 1;
        int tmp;

        while (i<j) {
            while (i<j && array[j]==toMove) {
                j--;
            }
            if (array[i] == toMove) {
                tmp = array[i];
                array[i] = array[j];
                array[j] = tmp;
            }
            i++;
        }
    }
}
