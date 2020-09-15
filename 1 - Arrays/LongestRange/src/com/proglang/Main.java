package com.proglang;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] s = scanner.nextLine().split(" ");
        int[] array = Arrays.stream(s).mapToInt(Integer::parseInt).toArray();

        displayResult(longestRange1(array));
        displayResult(longestRange2(array));

        scanner.close();
    }

    public static void displayResult(int[] result) {
        if (result[0]>result[1])
            System.out.println("Longest Range is not inside the array."); // example : [1, 0] -> the range is not valid because always left < right
        else
            System.out.println("Longest Range is " + Arrays.toString(result));
    }

    /*

        TC - O(nlog(n))
        SC - O(1)
     */

    public static int[] longestRange1(int[] array) {
        Arrays.sort(array);

        int[] bestRange = new int[2];
        int longestLength = 0;

        int left = 0, right = 0, currentLength = 0;
        for (int i=0; i< array.length; i++) {
            if (i>0 && array[i]==array[i-1]+1) {
                right = array[i];
                currentLength++;
            } else {
                left = array[i];
                currentLength = 1;
            }

            if (currentLength > longestLength) {
                longestLength = currentLength;
                bestRange = new int[]{left, right};  // [left, right]
            }
        }

        return bestRange;
    }

    /*

        TC - O(n)
        SC - O(n)
     */

    public static int[] longestRange2(int[] array) {
        int[] bestRange = new int[2];
        int longestLength = 0;
        HashMap<Integer, Boolean> nums = new HashMap<>();

        for (int num: array) {
            nums.put(num, true);
        }

        for (int num: array) {
            if (!nums.get(num))
                continue;

            nums.replace(num, false);

            int currentLength = 1;
            int left = num-1;
            int right = num+1;

            while (nums.containsKey(left)) {
                nums.replace(left, false);
                currentLength++;
                left--;
            }

            while (nums.containsKey(right)) {
                nums.replace(right, false);
                currentLength++;
                right++;
            }

            if (currentLength > longestLength) {
                longestLength = currentLength;
                bestRange = new int[]{left+1, right-1};
            }

        }
        return bestRange;
    }
}
