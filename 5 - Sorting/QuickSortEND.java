package com.proglang;

import java.util.Arrays;
import java.util.Scanner;

public class QuickSortEND {

    public static int partition(int[] array, int low, int high) {

        int pivot = array[high];
        int i = low-1, tmp;

        for(int j=low; j<=high; j++) {
            if (array[j] < pivot) {
                i++;

                tmp = array[i];
                array[i] = array[j];
                array[j] = tmp;
            }
        }

        tmp = array[i+1];
        array[i+1] = array[high];
        array[high] = tmp;

        return i+1;
    }

    public static void sort(int[] array, int low, int high) {
        if (low < high) {
            int pi = partition(array, low, high);

            System.out.println(Arrays.toString(array));

            sort(array, low, pi-1);
            sort(array, pi+1, high);
        }
    }

    public static void main(String[] args) {

        /*  Quit Sort
            Time Complexity -
                Best Case - Omega(n log(n))
                Average Case - Theta(n log(n))
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

        sort(array, 0, n-1);

        System.out.println(Arrays.toString(array));;

        scanner.close();
    }
}
