package com.proglang;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	    Scanner scanner = new Scanner(System.in);
	    String[] s = scanner.nextLine().split(" ");
	    int[] array = Arrays.stream(s).mapToInt(Integer::parseInt).toArray();

	    displayResult(subArraySort(array));

	    scanner.close();
    }

    public static void displayResult(int[] result) {
    	if (result[0]==-1 && result[1]==-1)
			System.out.println("The array is already sorted.");
    	else
			System.out.println("subArray is " + Arrays.toString(result));
	}

	/*

		TC - O(n)
		SC - O(1)
	 */

    public static int[] subArraySort(int[] array) {
    	int minOutOfOrder = Integer.MAX_VALUE, maxOutOfOrder = Integer.MIN_VALUE;

    	for (int i=0; i< array.length; i++) {
    		int num = array[i];
    		if (isOutOfOrder(i, num, array)) {
    			minOutOfOrder = Math.min(minOutOfOrder, array[i]);
    			maxOutOfOrder = Math.max(maxOutOfOrder, array[i]);
			}
		}

    	if (minOutOfOrder==Integer.MAX_VALUE)
    		return new int[]{-1,-1};

    	int subarrayLeftIdx = 0;
    	while (minOutOfOrder >= array[subarrayLeftIdx])
    		subarrayLeftIdx++;

    	int subarrayRightIdx = array.length -1;
    	while (maxOutOfOrder <= array[subarrayRightIdx])
    		subarrayRightIdx--;

    	return new int[] {subarrayLeftIdx, subarrayRightIdx};
	}

	public static boolean isOutOfOrder(int i, int num, int[] array) {
    	if (i==0)
    		return num > array[i+1];
    	if (i== array.length-1)
    		return num < array[i-1];
    	return num > array[i+1] || num < array[i-1];
	}
}
