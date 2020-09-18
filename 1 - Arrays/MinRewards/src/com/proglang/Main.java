package com.proglang;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] s = scanner.nextLine().split(" ");
        int[] scores = Arrays.stream(s).mapToInt(Integer::parseInt).toArray();

        displayResult(minRewards1(scores));
        displayResult(minRewards2(scores));
        displayResult(minRewards3(scores));

        scanner.close();
    }

    public static void displayResult(int minReward) {
        System.out.println("Min Reward: " + minReward);
    }

    /*
        Naive Approach -
        O(n^2) time | O(n) space
     */
    public static int minRewards1(int[] scores) {
        int[] rewards = new int[scores.length];
        Arrays.fill(rewards, 1);

        int i, j;
        for (i=1; i<scores.length; i++) {
            j = i - 1;
            if (scores[i] > scores[j])
                rewards[i] = rewards[j] +1;
            else {
                while (j>=0 && scores[j] > scores[j+1]) {
                    rewards[j] = Math.max(rewards[j], rewards[j+1]+1);
                    j--;
                }
            }
        }
        return Arrays.stream(rewards).sum();
    }

    /*
        peek min ids technique.
        O(n) time | O(n) space
     */
    public static int minRewards2(int[] scores) {
        int[] rewards = new int[scores.length];
        Arrays.fill(rewards, 1);

        int[] localMinIdxs = getLocalMinIdxs(scores);

        for (int localMinIdx: localMinIdxs) {
            expandFromLocalMinIdx(localMinIdx, scores, rewards);
        }
        return Arrays.stream(rewards).sum();
    }

    public static int[] getLocalMinIdxs(int[] array) {
        if (array.length==1)
            return new int[]{0};

        ArrayList<Integer> localMinIdxs = new ArrayList<>();
        for (int i=0; i<array.length; i++) {
            if (i==0 && array[i] < array[i+1])
                localMinIdxs.add(i);
            if (i==array.length-1 && array[i] < array[i-1])
                localMinIdxs.add(i);
            if (i==0 || i==array.length-1)
                continue;
            if (array[i] < array[i+1] && array[i] < array[i-1])
                localMinIdxs.add(i);
        }

        return localMinIdxs.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void expandFromLocalMinIdx(int localMinIdx, int[] scores, int[] rewards) {
        int leftIdx = localMinIdx -1;
        while (leftIdx>=0 && scores[leftIdx] > scores[leftIdx+1]) {
            rewards[leftIdx] = Math.max(rewards[leftIdx], rewards[leftIdx +1]+1);
            leftIdx--;
        }

        int rightIdx = localMinIdx +1;
        while (rightIdx< scores.length && scores[rightIdx] > scores[rightIdx -1]) {
            rewards[rightIdx] = rewards[rightIdx -1] +1;
            rightIdx++;
        }
    }

    /*

        optimal solution and clean code.
        O(2n) ~ O(n) time | O(n) space
     */
    public static int minRewards3(int[] scores) {
        int[] rewards = new int[scores.length];
        Arrays.fill(rewards, 1);

        for (int i=1; i< scores.length; i++) {
            if (scores[i] > scores[i-1])
                rewards[i] = rewards[i-1]+1;
        }

        for (int i=scores.length-2; i>= 0; i--) {
            if (scores[i] > scores[i+1])
                rewards[i] = Math.max(rewards[i], rewards[i+1]+1);
        }

        return Arrays.stream(rewards).sum();
    }
}
