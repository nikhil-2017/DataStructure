package com.proglang;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter n number of elements in an array: ");
        int n = scanner.nextInt();
        System.out.print("Sum : ");
        int k = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter data : ");
        String[] s = scanner.nextLine().split(" ");

        int[] arr = Arrays.stream(s).mapToInt(Integer::parseInt).toArray();

        System.out.println(getTwoNumbers1(arr, k));
        System.out.println(getTwoNumbers2(arr, k));
        System.out.println(getTwoNumbers3(arr, k));

        scanner.close();
    }

    /*
        Approach 1 -
            1. add each element with other element so we can get k
            TC - O(n^2)
            SC - No extra space

            This approach takes more time but it takes no extra space.
     */
    public static String getTwoNumbers1(int[] arr, int k) {
        for (int i=0; i<arr.length; i++) {
            for (int j=i+1; j< arr.length; j++) {
                if (arr[i]+arr[j]==k) {
                    return arr[i] + " " + arr[j];
                }
            }
        }
        return "NO";
    }

    /*
        Approach 2 -
            1. create a new HashMap and
            2. then iterate array and initialise diff = k - arr[i]
            3. check the diff is inside HashMap return diff + " " + arr[i]
            4. else put element inside the HashMap

            TC - O(n)
            SC - O(n)

            This approach takes linear time and  it takes extra space of n.
     */
    public static String getTwoNumbers2(int[] arr, int k) {
        HashMap<Integer, Boolean> nums = new HashMap<>();
        int diff;
        for (int i=0; i< arr.length; i++) {
            diff = k - arr[i];
            if (nums.containsKey(diff)) {
                return diff + " " + arr[i];
            } else {
                nums.put(arr[i], true);
            }
        }
        return "NO";
    }

    /*
        Approach 3 -
            1. sort array O(n log(n))
            2. then use two pointers left and right
            3. DECLARE left = 0, right = array.length-1, sum
            4. loop left < right
                4.1 sum = array[left] + array[right]
                4.2 check if the sum is equal to the k then return array[left] + " " + array[right]
                4.3 else if check the sum < k : then do left++
                4.4 else check sum > k : then do right--
            TC - O(n log(n))
            SC - No extra space -> O(3) ~ O(1)

            This approach takes more time but it takes no extra space.
     */

    public static String getTwoNumbers3(int[] arr, int k) {
        Arrays.sort(arr);
        int left = 0, right = arr.length - 1, sum;
        while (left < right) {
            sum = arr[left] + arr[right];
            if (sum == k) {
                return arr[left] + " " + arr[right];
            } else if (sum < k) {
                left++;
            } else {
                right--;
            }
        }
        return "NO";
    }
}