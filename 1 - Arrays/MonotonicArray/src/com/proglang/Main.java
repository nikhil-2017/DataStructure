package com.proglang;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	    Scanner scanner = new Scanner(System.in);
	    String[] s = scanner.nextLine().split(" ");
	    int[] array = Arrays.stream(s).mapToInt(Integer::parseInt).toArray();

        displayResult(isMonotonic1(array));     // approach 1
        displayResult(isMonotonic2(array));     // approach 2

	    scanner.close();
    }

    public static void displayResult(boolean isMonotonic) {
        if (isMonotonic)
            System.out.println("The array is Monotonic.");
        else
            System.out.println("The array is not Monotonic.");
    }

    /*

        Approach 1 -

        TC - O(n)
        SC - o(1)
     */

    public static boolean isMonotonic1(int[] array) {
        if (array.length <= 2)
            return true;
        int direction = array[1] - array[0];

        for (int i=2; i< array.length; i++) {
            if (direction == 0) {
                direction = array[i] - array[i - 1];
                continue;
            }
            if (breakDirection(direction, array[i-1], array[i]))
                return false;
        }

        return true;
    }

    public static boolean breakDirection(int direction, int previousInt, int currentInt) {
        int difference = currentInt - previousInt;
        if (direction > 0)
            return difference < 0;
        return difference > 0;
    }

    public static boolean isMonotonic2(int[] array) {
        boolean isNonDecreasing = true;
        boolean isNonIncreasing = true;

        for (int i=1; i< array.length; i++) {
            if (array[i] < array[i-1])
                isNonDecreasing = false;
            if (array[i] > array[i-1])
                isNonIncreasing = false;
        }

        return isNonDecreasing || isNonIncreasing;
    }
}
