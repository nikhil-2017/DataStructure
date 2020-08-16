package com.proglang;

import java.util.Scanner;

public class LinearSearch {
    public static void main(String[] args) {

        /*  Linear Search
            Time Complexity -
                Best Case - Omega(1)
                Average Case - Theta(n)
                Worst Case - BigO(n)

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

        int element = scanner.nextInt(), ind=-1;
        System.out.println(ind);

        for (int i=0; i<n; i++) {
            if(element==array[i]) {
                ind = i;
            }
        }

        if(ind==-1) {
            System.out.println("The element is not exist in an array.");
        } else {
            System.out.println("The element is at " + ind + " index in an array.");
        }

        scanner.close();
    }
}