package com.proglang;

import java.util.Arrays;
import java.util.Scanner;

public class SelectionSort {
    public static void main(String[] args) {

        /*  Selection Sort
            Time Complexity -
                Best Case - Omega(n^2)
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

        int tmp, min, minInd, swapCount=0;
        for (int i=0; i<n-1; i++) {
            min = array[i];
            minInd = i;

            for (int j=i+1; j<n; j++) {
                if (min > array[j]) {
                    min = array[j];
                    minInd = j;
                }
            }

            if(minInd!=i) {
                tmp = array[i];
                array[i] = min;
                array[minInd] = tmp;
                swapCount++;
                System.out.println("swap " + swapCount + " : " + Arrays.toString(array));
            }
        }

        System.out.println("Sorted Array : " + Arrays.toString(array));
        System.out.println("swapCount : " + swapCount);
    }
}