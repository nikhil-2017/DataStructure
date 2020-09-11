package com.proglang;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    /*
        Approach 1 & Approach 2 -

        TC - O(log(n))
        SC - O(1)
     */

    public static int shiftedBinarySearchRec(int[] array, int target, int left, int right) {
        if (left > right)
            return -1;
        int middle = (left + right) / 2 ;
        int middleNum = array[middle];
        int leftNum = array[left];
        int rightNum = array[right];

        if (target == middleNum)
            return middle;
        else if (leftNum <= middleNum) {
            if (target < middleNum && target >= leftNum)
                return shiftedBinarySearchRec(array, target, left, middle-1);
            else
                return shiftedBinarySearchRec(array, target, middle+1, right);
        } else {
            if (target > middleNum && target <= rightNum)
                return shiftedBinarySearchRec(array, target, middle+1, right);
            else
                return shiftedBinarySearchRec(array, target, left, middle-1);
        }
    }

    public static int shiftedBinarySearchIter(int[] array, int target, int left, int right) {
        int middle, middleNum, leftNum, rightNum;
        while (left <= right) {
            middle = (left + right) / 2;
            middleNum = array[middle];
            leftNum = array[left];
            rightNum = array[right];

            if (target == middleNum)
                return middle;
            else if (leftNum <= middleNum) {
                if (target < middleNum && target >= leftNum)
                    right = middle - 1;
                else
                    left = middle + 1;
            } else {
                if (target > middleNum && target <= rightNum)
                    left = middle + 1;
                else
                    right = middle - 1;
            }
        }
        return -1;
    }

    public static void result(int position) {
        if (position==-1)
            System.out.println("The target element is not in an array");
        else
            System.out.println("The target element position is " + position);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter array length: ");
        int n = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter elements: ");
        String[] s = scanner.nextLine().split(" ");
        int[] array = Arrays.stream(s).mapToInt(Integer::parseInt).toArray();
        System.out.print("Enter target element: ");
        int target = scanner.nextInt();

        int position;
        position = shiftedBinarySearchRec(array, target, 0, n-1);   // Recursive Approach
        result(position);
        position = shiftedBinarySearchIter(array, target, 0, n-1);  // Iterative Approach
        result(position);

        scanner.close();
    }
}