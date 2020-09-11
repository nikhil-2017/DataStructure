package com.proglang;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        scanner.nextLine();
        String[] s = scanner.nextLine().split(" ");
        int[] arr = Arrays.stream(s).mapToInt(Integer::parseInt).toArray();

        int[] array = findThreeNumbers1(arr);
        System.out.println(Arrays.toString(array));

        array = findThreeNumbers2(arr);
        System.out.println(Arrays.toString(array));

        scanner.close();
    }

    /*
        Approach 1 -
        TC - O(nlog(n))
        SC - O(3) ~ O(1)
     */

    public static int[] findThreeNumbers1(int[] arr) {
        Arrays.sort(arr);
        if (arr.length > 3)
            return new int[]{arr[arr.length-3], arr[arr.length-2], arr[arr.length-1]};

        return arr;
    }

    /*
        Approach 2 -
        TC - O(n)
     */
    public static int[] findThreeNumbers2(int[] arr) {
        int[] threeLargest = {Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE};
        for (int i=0; i<arr.length; i++) {
            updateLargest(threeLargest, arr[i]);
        }
        return threeLargest;
    }

    public static void updateLargest(int[] threeLargest, int num) {
        if (threeLargest[2] == Integer.MIN_VALUE || num > threeLargest[2])
            shiftAndUpdate(threeLargest, num, 2);
        else if (threeLargest[1] == Integer.MIN_VALUE || num > threeLargest[1])
            shiftAndUpdate(threeLargest, num, 1);
        else if (threeLargest[0] == Integer.MIN_VALUE || num > threeLargest[0])
            shiftAndUpdate(threeLargest, num, 0);

    }

    public static void shiftAndUpdate(int[] array, int num, int idx) {
        for (int i=0; i<array.length; i++) {
            if (i==idx)
                array[i] = num;
            else
                array[i] = array[i+1];
        }
    }
}
