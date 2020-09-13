package com.proglang;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	    Scanner scanner = new Scanner(System.in);

		System.out.print("Enter elements of f1 array: ");
	    String[] s1 = scanner.nextLine().split(" ");
	    int[] arrayOne = Arrays.stream(s1).mapToInt(Integer::parseInt).toArray();

		System.out.print("Enter elements of f2 array: ");
		s1 = scanner.nextLine().split(" ");
		int[] arrayTwo = Arrays.stream(s1).mapToInt(Integer::parseInt).toArray();

		displaySmallestPair(smallestDifference1(arrayOne, arrayTwo));
		displaySmallestPair(smallestDifference2(arrayOne, arrayTwo));

		scanner.close();
    }

    public static void displaySmallestPair(int[] pair) {
		System.out.println("Smallest Pair : " + Arrays.toString(pair));
	}

    /*
	Naive approach -
	check difference of each element from first array with each element from second array.

    TC - O(n^2)
    SC - O(1)
     */

    public static int[] smallestDifference1(int[] arrayOne, int[] arrayTwo) {
    	int smallestDiff = Integer.MAX_VALUE;
		int[] smallestPair = new int[2];
		int currentDiff;
    	for (int i=0; i< arrayOne.length; i++) {
    		for (int j=0; j< arrayTwo.length; j++) {
    			currentDiff = Math.abs(arrayOne[i] - arrayTwo[j]);
    			if (currentDiff==0)
    				return new int[]{arrayOne[i], arrayTwo[j]};

    			if (currentDiff < smallestDiff) {
    				smallestDiff = currentDiff;
					smallestPair = new int[]{arrayOne[i], arrayTwo[j]};
				}
			}
		}
    	return smallestPair;
	}

	/*
		sort the array.

		LOOP check (idx1 < len(arr1) && idx2 < len(arr2) {
			f1 = arr1[idx1]
			f2 = arr2[idx2]
			if (f1 is less than f2) then
				currentDiff = f2 - f1
				idx1++;
			else if (f1 is greater than f2) then
				currentDiff = f1 - f2
				idx2++;
			else
				return [f1, f2]

			if currentDiff < smallestDiff then
				smallestDiff = currentDiff
				smallestPair = [f1, f2]
		}
		return smallestPair

		TC - O(nlog(n) + mlog(m))
		SC - O(1)
	 */

	public static int[] smallestDifference2(int[] arrayOne, int[] arrayTwo) {
    	Arrays.sort(arrayOne);
    	Arrays.sort(arrayTwo);

    	int idxOne = 0, idxTwo = 0;
    	int[] smallestPair = new int[2];
    	int smallestDiff = Integer.MAX_VALUE;
    	int currentDiff;

    	int firstNum, secondNum;
    	while (idxOne < arrayOne.length && idxTwo < arrayTwo.length) {
    		firstNum = arrayOne[idxOne];
    		secondNum = arrayTwo[idxTwo];

    		if (firstNum < secondNum) {
    			currentDiff = secondNum - firstNum;
    			idxOne++;
			} else if (firstNum > secondNum) {
    			currentDiff = firstNum - secondNum;
    			idxTwo++;
			} else {
    			return new int[] {firstNum, secondNum};
			}

    		if (currentDiff < smallestDiff) {
    			smallestDiff = currentDiff;
    			smallestPair = new int[] {firstNum, secondNum};
			}
		}

    	return smallestPair;
	}
}