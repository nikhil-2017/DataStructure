package com.proglang;

import java.util.Scanner;

public class BinarySearch {
    public static void main(String[] args) {

        /*  Binary Search
            Time Complexity -
                Best Case - Omega(1)
                Average Case - Theta(log(n))
                Worst Case - BigO(log(n))

            Space Complexity - O(1)
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

        System.out.print("Enter element: ");
        int element = scanner.nextInt();

        int ind = programmedBinarySearch(element, array, 0, n-1);

        if(ind==-1) {
            System.out.println("The element is not exist in an array.");
        } else {
            System.out.println("The element is at " + ind + " index in an array.");
        }

    }

    public static int programmedBinarySearch(int element, int[] array, int start, int end) {
        if(start<=end) {
            int mid = (start + end) / 2;
            if(array[mid]==element) {
                return  mid;
            } else if (array[mid] > element) {
                return programmedBinarySearch(element, array, start, mid-1);
            } else if (array[mid] < element) {
                return programmedBinarySearch(element, array, mid+1, end);
            }
        }
        return -1;
    }
}
