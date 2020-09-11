package com.proglang;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Elements: ");
        String[] s = scanner.nextLine().split(" ");
        int[] arr = Arrays.stream(s).mapToInt(Integer::parseInt).toArray();

        findTwoLargestNumbers1(arr);    // approach 1
        findTwoLargestNumbers2(arr);    // approach 2
        findTwoLargestNumbers3(arr);    // approach 3

       scanner.close();
    }

    /*
        Approach 1 - sort the array

        TC - O(nlog(n))
        SC - O(1)
     */

    public static void findTwoLargestNumbers1(int[] array) {
        Arrays.sort(array);
        if (array.length < 2)
            System.out.println(Arrays.toString(array));
        System.out.println(array[array.length-2] + " " + array[array.length-1]);
    }

    /*
        Approach 2 -
        1. traverse and check array[i] element is larger than second or first is same as second
            1.1 if above condition is true:
            1.2 if array[i] is bigger than first:
                1.2.1 second = first
                1.2.2 first = array[i]
                1.2.3 flag = true
            1.3 if flag is false:
                1.3.1 second = array[i]
            1.4 flag = false
        2. print result

        TC - O(n)
        SC - O(3) ~ O(1)

     */
    public static void findTwoLargestNumbers2(int[] array) {
        int first=array[0], second=array[0];
        boolean flag = false;
        for (int i=1; i< array.length; i++) {
            if (array[i] > second || second==first) {
                if (array[i] > first) {
                    second = first;
                    first = array[i];
                    flag = true;
                }

                if (!flag)
                    second = array[i];

                flag = false;
            }
        }
        System.out.println(second + " " + first);
    }

    /* Approach 3 -

        TC - O(n)
        SC - O(1)
     */

    public static void findTwoLargestNumbers3(int[] array) {
        int[] nums = {Integer.MIN_VALUE, Integer.MIN_VALUE};
        for (int i=0; i<array.length; i++) {
            shiftAndUpdate(nums, array[i]);
        }
        System.out.println(nums[0] + " " + nums[1]);
    }

    public static void shiftAndUpdate(int[] nums, int num) {
        if (nums[1] == Integer.MIN_VALUE || num > nums[1]) {
            nums[0] = nums[1];
            nums[1] = num;
        } else if (nums[0] == Integer.MIN_VALUE || num > nums[0]) {
            nums[0] = num;
        }
    }
}
