package com.proglang;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter rows & cols : ");
        String[] input = scanner.nextLine().split(" ");
        int row = Integer.parseInt(input[0]), col = Integer.parseInt(input[1]);
        int[][] matrix = new int[row][col];

        String[] s;
        for (int i=0; i< matrix.length; i++) {
            s = scanner.nextLine().split(" ");
            for (int j=0; j< matrix[0].length; j++) {
                matrix[i][j] = Integer.parseInt(s[j]);
            }
        }

        System.out.print("target element : ");
        int target = scanner.nextInt();

        displayArray(matrix);
        displayResult(searchInSortedMatrix(matrix, target));

        scanner.close();
    }

    public static void displayArray(int[][] matrix) {
        System.out.println("Array : ");
        for (int i=0; i< matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
    }

    public static void displayResult(int[] result) {
        if (result[0]==-1 && result[1]==-1)
            System.out.println("The target element is not in the matrix.");
        else
            System.out.println("The target element position is " + Arrays.toString(result) + " in the matrix.");
    }

    /*
        working of algo -
        LOOP:
            check the start 0 rows last element and check is less or greater or equal.
            if it is greater than target value : col--;
            else if it is less than target : row++;
            else : the element is same -> return {rowLoc, colLoc}
        return {-1, -1}     // the element is not present in the matrix.

        TC - O(n+m)     where n is row and m is col
        SC - O(1)
     */
    public static int[] searchInSortedMatrix(int[][] matrix, int target) {
        int row = 0;
        int col = matrix[0].length - 1;

        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] > target)
                col--;
            else if (matrix[row][col] < target)
                row++;
            else
                return new int[]{row, col};
        }
        return new int[]{-1,-1};
    }
}
