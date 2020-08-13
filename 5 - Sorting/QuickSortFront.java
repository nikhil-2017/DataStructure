package com.proglang;

import java.util.Arrays;
import java.util.Scanner;

public class QuickSortFront {

    public  static int partition(int[] array, int low, int high) {
        int pivot = array[low];
        int i=low, tmp;

        for (int j=low; j<=high; j++) {
            if (array[j] < pivot) {
                i++;

                tmp = array[i];
                array[i] = array[j];
                array[j] = tmp;

            }
        }

        if (low!=i) {
            tmp = array[i];
            array[i] = array[low];
            array[low] = tmp;
        }

        return i;
    }

    public static void sort(int[] array, int low, int high) {
        if(low < high) {
            int pi = partition(array, low, high);

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
