package com.proglang;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter rows & cols : ");
        String[] input = scanner.nextLine().split(" ");
        int row = Integer.parseInt(input[0]), col = Integer.parseInt(input[1]);
        int[][] array = new int[row][col];

        zigzagInsert(array);
        displayZigZagArray(array);

        displayZigZagResult(zigzagTraverse(array));

        scanner.close();
    }

    public static void displayZigZagArray(int[][] arr) {
        System.out.println("ZigZag Array: ");
        for (int i=0; i< arr.length; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }
    }

    public static void displayZigZagResult(int[] result) {
        System.out.println("result : " + Arrays.toString(result));
    }

    public static int[][] zigzagInsert(int[][] arr) {
        int height = arr.length - 1;
        int width = arr[0].length - 1;

        int row = 0, col = 0, i=1;
        boolean goingDown = true;

        while (!isOutOfBounds(row, col, height, width)) {
            arr[row][col] = i;
            i++;
            if (goingDown) {
                if (col==0 || row==height) {
                    goingDown = false;
                    if (row == height)
                        col++;
                    else
                        row++;
                }
                else {
                    row++;
                    col--;
                }
            } else {
                if (row==0 || col==width) {
                    goingDown = true;
                    if (col == width)
                        row++;
                    else
                        col++;
                } else {
                    row--;
                    col++;
                }
            }
        }
        return arr;
    }

    private static boolean isOutOfBounds(int row, int col, int height, int width) {
        return row < 0 || row > height || col < 0 ||  col > width;
    }

    public static int[] zigzagTraverse(int[][] arr) {
        int[] result = new int[arr.length* arr[0].length];
        int height = arr.length - 1;
        int width = arr[0].length - 1;

        int row = 0, col = 0, i=0;
        boolean goingDown = true;

        while (!isOutOfBounds(row, col, height, width)) {
            result[i] = arr[row][col];
            i++;
            if (goingDown) {
                if (col==0 || row==height) {
                    goingDown = false;
                    if (row == height)
                        col++;
                    else
                        row++;
                }
                else {
                    row++;
                    col--;
                }
            } else {
                if (row==0 || col==width) {
                    goingDown = true;
                    if (col == width)
                        row++;
                    else
                        col++;
                } else {
                    row--;
                    col++;
                }
            }
        }
        return result;
    }
}
