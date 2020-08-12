package com.proglang;

import java.util.Arrays;
import java.util.Scanner;

public class InsertionSort {
    public static void main(String[] args) {
         /*  Insertion Sort
            Time Complexity -
                Best Case - Omega(n)
                Average Case - Theta(n^2)
                Worst Case - BigO(n^2)
         */

        Scanner scanner = new Scanner(System.in);
        System.out.print("n: ");
        int n = scanner.nextInt();  // size of array

        scanner.nextLine();

        String[] s = scanner.nextLine().split(" ");
        int[] array = new int[n];

        for(int i=0; i<n; i++) {
            array[i] = Integer.parseInt(s[i]);
        }
        int tmp;
        for (int i=0; i<n-1; i++) {
            for (int j=i+1; j>0; j--) {
                if(array[j] < array[j-1]) {
                    tmp = array[j];
                    array[j] = array[j-1];
                    array[j-1] = tmp;
                } else {
                    System.out.println(Arrays.toString(array));
                    break;
                }
                System.out.println(Arrays.toString(array));
            }
        }
        System.out.println("Sorted Array : " + Arrays.toString(array));
    }
}
