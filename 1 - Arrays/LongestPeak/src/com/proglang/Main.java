package com.proglang;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] s = scanner.nextLine().split(" ");
        int[] array = Arrays.stream(s).mapToInt(Integer::parseInt).toArray();

        displayResult(longestPeak(array));

        scanner.close();
    }

    public static void displayResult(int peek) {
        System.out.println("Longest Peak : " + peek);
    }

    /*

        TC - O(n)
        SC - O(1)
     */

    public static int longestPeak(int[] array) {
        int longestPeakLength = 0;
        int i = 1;
        boolean isPeak;

        while (i < array.length-1) {
            isPeak = array[i-1] < array[i] && array[i] > array[i+1];
            if(!isPeak) {
               i++;
               continue;
            }

            int leftIdx = i-2;
            while (leftIdx >= 0 && array[leftIdx] < array[leftIdx+1])
                leftIdx--;

            int rightIdx = i+2;
            while (rightIdx < array.length && array[rightIdx] < array[rightIdx-1])
                rightIdx++;

            int currentPeakLength =  rightIdx - leftIdx -1;
            longestPeakLength = Math.max(currentPeakLength, longestPeakLength);
            i = rightIdx;
        }
        return longestPeakLength;
    }
}
