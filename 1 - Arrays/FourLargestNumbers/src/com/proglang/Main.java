package com.proglang;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter elements: ");
        String[] s = scanner.nextLine().split(" ");
        int[] arr = Arrays.stream(s).mapToInt(Integer::parseInt).toArray();

        findFourLargestNumbers1(arr);
        findFourLargestNumbers2(arr);

        scanner.close();
    }

    /*
        Approach 1 -
            sort the array and retrieve last 4 elements

            TC - O(nlog(n))
            SC - O(1)
     */

    public static void findFourLargestNumbers1(int[] array) {
        Arrays.sort(array);
        if (array.length < 4)
            System.out.println(Arrays.toString(array));
        System.out.println(array[array.length-4] + " " + array[array.length-3] + " " + array[array.length-2] + " " + array[array.length-1]);
    }

    /*
        Approach 2 -

            TC - O(n)
            SC - O(1)
     */

    public static void findFourLargestNumbers2(int[] array) {
        int[] nums = {Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE};
        for (int i=0; i< array.length; i++) {
            updateArray(nums, array[i]);
        }
        System.out.println(Arrays.toString(nums));
    }

    public static void updateArray(int[] nums, int num) {
        for (int i=nums.length-1; i>=0; i--) {
            if (nums[i] == Integer.MIN_VALUE || num > nums[i]) {
                shiftAndUpdate(nums, num, i);
                break;
            }
        }
    }

    private static void shiftAndUpdate(int[] nums, int num, int idx) {
        for (int i=0; i<=idx; i++) {
            if (i==idx)
                nums[i] = num;
            else
                nums[i] = nums[i+1];
        }
    }
}
