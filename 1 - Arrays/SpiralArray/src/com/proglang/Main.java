package com.proglang;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Rows & cols : ");
        String[] input = scanner.nextLine().split(" ");
        int row = Integer.parseInt(input[0]), col = Integer.parseInt(input[1]);

        int[][] array = new int[row][col];

//      Iterative method
        spiralInsert(array);
        displaySpiralArray(array);
        displayResult(spiralTraverse(array));

        System.out.println();

//      Recursive method
        spiralInsertRec(array);
        displaySpiralArray(array);
        displayResult(spiralTraverseRec(array));


        scanner.close();
    }

    public static void displaySpiralArray(int[][] arr) {
        System.out.println("Spiral Array: ");
        for (int i=0; i<arr.length; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }
    }

    public static void displayResult(int[] result) {
        System.out.println("Result : " + Arrays.toString(result));
    }

    /*
        Iterative method

        TC - O(n)
        SC - O(n)
     */

    public static int[][] spiralInsert(int[][] arr) {
        int startRow = 0, endRow = arr.length - 1;
        int startCol = 0, endCol = arr[0].length - 1;

        int col, row, i=1;
        while (startRow <= endRow && startCol <= endCol) {
            for (col=startCol; col<endCol+1; col++) {
                arr[startRow][col] = i;
                i++;
            }

            for (row=startRow+1; row<endRow+1; row++) {
                arr[row][endCol] = i;
                i++;
            }

            for (col=endCol-1; col>=startCol; col--) {
                arr[endRow][col] = i;
                i++;
            }

            for (row=endRow-1; row>=startRow+1; row--) {
                arr[row][startCol] = i;
                i++;
            }

            startRow++;
            endRow--;
            startCol++;
            endCol--;
        }
        return arr;
    }

    public static int[] spiralTraverse(int[][] arr) {
        int[] result = new int[arr.length*arr[0].length];
        int startRow = 0, endRow = arr.length - 1;
        int startCol = 0, endCol = arr[0].length - 1;

        int col, row, i=0;
        while (startRow <= endRow && startCol <= endCol) {
            for (col=startCol; col<endCol+1; col++) {
                result[i] = arr[startRow][col];
                i++;
            }

            for (row=startRow+1; row<endRow+1; row++) {
                result[i] = arr[row][endCol];
                i++;
            }

            for (col=endCol-1; col>=startCol; col--) {
                result[i] = arr[endRow][col];
                i++;
            }

            for (row=endRow-1; row>=startRow+1; row--) {
                result[i] = arr[row][startCol];
                i++;
            }

            startRow++;
            endRow--;
            startCol++;
            endCol--;
        }
        return result;
    }

    /*
        Recursive method -

        TC - O(n)
        SC - O(n)
     */

    public static int[][] spiralInsertRec(int[][] arr) {
        spiralInsertRec(arr, 0, arr.length - 1, 0, arr[0].length - 1, 1);
        return arr;
    }

    private static void spiralInsertRec(int[][] arr, int startRow, int endRow, int startCol, int endCol, int i) {
        if (startRow > endRow || startCol > endCol)
            return;

        int row, col;

        for (col=startCol; col<endCol+1; col++) {
            arr[startRow][col] = i;
            i++;
        }

        for (row=startRow+1; row<endRow+1; row++) {
            arr[row][endCol] = i;
            i++;
        }

        for (col=endCol-1; col>=startCol; col--) {
            arr[endRow][col] = i;
            i++;
        }

        for (row=endRow-1; row>=startRow+1; row--) {
            arr[row][startCol] = i;
            i++;
        }
        spiralInsertRec(arr, startRow+1, endRow-1, startCol+1, endCol-1, i);
    }

    public static int[] spiralTraverseRec(int[][] arr) {
        int[] result = new int[arr.length*arr[0].length];
        spiralTraverseRec(arr, 0, arr.length - 1, 0, arr[0].length - 1, result, 0);
        return result;
    }

    private static void spiralTraverseRec(int[][] arr, int startRow, int endRow, int startCol, int endCol, int[] result, int i) {
        if (startRow > endRow || startCol > endCol)
            return;

        int row, col;

        for (col=startCol; col<endCol+1; col++) {
            result[i] = arr[startRow][col];
            i++;
        }

        for (row=startRow+1; row<endRow+1; row++) {
            result[i] = arr[row][endCol];
            i++;
        }

        for (col=endCol-1; col>=startCol; col--) {
            result[i] = arr[endRow][col];
            i++;
        }

        for (row=endRow-1; row>=startRow+1; row--) {
            result[i] = arr[row][startCol];
            i++;
        }
        spiralTraverseRec(arr, startRow+1, endRow-1, startCol+1, endCol-1, result, i);
    }
}