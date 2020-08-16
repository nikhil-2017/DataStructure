package com.proglang;

import java.util.Arrays;
import java.util.Scanner;

public class MergeSort {

    public static void merge(int[] array, int beg, int mid, int end) {
        int i=beg, j=mid+1, index=beg, k;
        int[] tmpArray = new int[array.length];

        while ((i<=mid) && (j<=end)) {
            if (array[i] < array[j]) {
                tmpArray[index] = array[i];
                i++;
            } else {
                tmpArray[index] = array[j];
                j++;
            }
            index++;
        }

        if(i > mid) {
            while (j <= end) {
                tmpArray[index] = array[j];
                j++;
                index++;
            }
        } else {
            while (i <= mid) {
                tmpArray[index] = array[i];
                i++;
                index++;
            }
        }

        for (k=beg; k<index; k++) {
            array[k] = tmpArray[k];
        }

    }

    public static void mergeSort(int[] array, int beg, int end) {
        if (beg < end) {
            int mid = (beg + end) / 2;

            // divide
            mergeSort(array, beg, mid); // left-side
            mergeSort(array, mid+1, end);   // right-side

            // conquer
            merge(array, beg, mid, end);
        }
    }

    public static void main(String[] args) {

        /*  Merge Sort
            Time Complexity -
                Best Case - Omega(n log(n))
                Average Case - Theta(n log(n))
                Worst Case - BigO(n log(n))
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

        mergeSort(array, 0, n-1);

        System.out.println(Arrays.toString(array));;

        scanner.close();
    }
}
