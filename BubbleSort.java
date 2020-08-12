package com.proglang;

import java.util.Arrays;
import java.util.Scanner;

public class BubbleSort {
    public static void main(String[] args) {

        /*  Bubble Sort
            Time Complexity -
                Best Case - Omega(n)
                Average Case - Theta(n^2)
                Worst Case - BigO(n^2)
         */

        Scanner scanner = new Scanner(System.in);
        System.out.print("n: ");
        int n = scanner.nextInt();

        scanner.nextLine();

        String[] s = scanner.nextLine().split(" ");
        int[] array = new int[n];

        for(int i=0; i<n; i++) {
            array[i] = Integer.parseInt(s[i]);
        }

        int tmp, swapCount=0;
        for (int i=0; i<array.length; i++) {
            for (int k=0; k<array.length-i-1; k++) {
                if (array[k] > array[k+1]) {
                    tmp = array[k];
                    array[k] = array[k+1];
                    array[k+1] = tmp;
                    swapCount++;
                    System.out.println("swap " + swapCount + " : " + Arrays.toString(array));
                }
            }
        }

        System.out.println("Sorted Array : " + Arrays.toString(array));
        System.out.println("swapCount : " + swapCount);

        scanner.close();
    }
}
