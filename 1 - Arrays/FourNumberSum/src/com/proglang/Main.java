package com.proglang;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	    Scanner scanner = new Scanner(System.in);

	    String[] s = scanner.nextLine().split(" ");
	    int[] array = Arrays.stream(s).mapToInt(Integer::parseInt).toArray();
	    int targetSum = scanner.nextInt();

	    displayResult(fourNumberSum(array, targetSum));

	    scanner.close();
    }

    public static void displayResult(ArrayList<Integer[]> result) {
        if (result.size() > 0) {
            System.out.print("result : ");
            for (Integer[] arr : result) {
                System.out.print(Arrays.toString(arr) + " ");
            }
            System.out.println();
        } else {
            System.out.println("There is no solution.");
        }
    }

    /*

        TC -
            Average : O(n^2)
            Worst : O(n^3)

        SC - O(n^2)
     */
    public static ArrayList<Integer[]> fourNumberSum(int[] array, int targetSum) {
        HashMap<Integer, ArrayList<Integer[]>> allPairSums = new HashMap<>();
        ArrayList<Integer[]> quadruplets = new ArrayList<>();

        int currentSum, difference;
        for (int i=1; i< array.length; i++) {
            for (int j=i+1; j< array.length; j++) {
                currentSum = array[i] + array[j];
                difference = targetSum - currentSum;

                if (allPairSums.containsKey(difference)) {
                    for (Integer[] arr : allPairSums.get(difference)) {
                        quadruplets.add(new Integer[]{arr[0], arr[1], array[i], array[j]});
                    }
                }
            }

            for (int k=0; k<i; k++) {
                currentSum = array[i] + array[k];
                if (!allPairSums.containsKey(currentSum)) {
                    ArrayList<Integer[]> arr = new ArrayList<>();
                    arr.add(new Integer[]{array[i], array[k]});
                    allPairSums.put(currentSum, arr);
                } else {
                    ArrayList<Integer[]> arr = allPairSums.get(currentSum);
                    arr.add(new Integer[]{array[i], array[k]});
                    allPairSums.replace(currentSum, arr);
                }
            }
        }
        return quadruplets;
    }
}
