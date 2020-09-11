package com.proglang;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        /*
            problem statement - Three Numbers Sum

            input:
            k
            arr elements

            where k is value that we need to sum up with three numbers of array

            Sample Input:
            0
            12 3 1 2 -6 5 -8 6

            Output: // return ArrayList of three numbers
            [3, 5, -8] [1, -6, 5] [2, -8, 6]
         */

        Scanner scanner = new Scanner(System.in);

        int k = scanner.nextInt();
        scanner.nextLine();
        String[] s = scanner.nextLine().split(" ");
        int[] arr = Arrays.stream(s).mapToInt(Integer::parseInt).toArray();

        ArrayList<int[]> nums = findThreeNumSum1(arr, k);
        displayList(nums);

        nums = findThreeNumSum2(arr, k);
        displayList(nums);

        scanner.close();
    }

    /*
        Approach 1 -
            1. Iterate through three loops and do
                1.1 1LOOP -> len(arr)-2
                1.2 2LOOP -> len(arr)-1
                1.3 3LoOP -> len(arr)

        TC - O(n^3)
        SC - O(n)
     */

    public static ArrayList<int[]> findThreeNumSum1(int[] arr, int k) {
        int i, j, v, currentSum;
        ArrayList<int[]> nums = new ArrayList<>();
        for (i=0; i< arr.length-2; i++) {
            for (j=i+1; j< arr.length-1; j++) {
                for (v=j+1; v< arr.length; v++) {
                    currentSum = arr[i] + arr[j] + arr[v];
                    if (currentSum==k) {
                        nums.add(new int[]{arr[i], arr[j], arr[v]});
                    }
                }
            }
        }
        return nums;
    }

    /*
        Approach 2 -
            1. sort the array
            2. DECLARE left, right, currentSum
            3. DECLARE ArrayList of int[] array : nums
            4. for i in (0, len(arr)):
                4.1 left = i+1
                4.2 right = len(arr)-1
                4.2 LOOP left < right
                    4.2.1 currentSum = arr[i] + arr[left] + arr[right]
                    4.2.2 if currentSum == k : nums.add([arr[i], arr[left], arr[right]])
                    4.2.3 else if currentSum < k : left++
                    4.2.4 else if currentSum > k : right--

            5. return nums

        TC - O(n^2)
        SC - O(n)
     */
    public static ArrayList<int[]> findThreeNumSum2(int[] arr, int k) {
        Arrays.sort(arr);
        int left, right, currentSum;
        ArrayList<int[]> nums = new ArrayList<>();

        for (int i=0; i< arr.length-2; i++) {
            left = i+1;
            right = arr.length-1;

            while (left < right) {
                currentSum = arr[i] + arr[left] + arr[right];
                if (currentSum==k) {
                    nums.add(new int[]{arr[i], arr[left], arr[right]});
                    left++;
                    right--;
                } else if (currentSum < k) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return nums;
    }

    public static void displayList(ArrayList<int[]> nums) {
        for (int i=0; i< nums.size(); i++) {
            System.out.print(Arrays.toString(nums.get(i)) + " ");
        }
        System.out.println();
    }
}
