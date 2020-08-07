package programs;

import java.util.Arrays;
import java.util.Scanner;

public class sortedArray {
    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int n = sc.nextInt();
        int[] intArray = getElement(n);

        reverse(intArray);
        printArray(reverseArray(intArray));
        // printArray(descSort(intArray));

        displayInt(minEle(intArray));
    }

    public static int[] getElement(int n){
        int[] array = new int[n];

        for(int i=0; i<array.length; i++){
            array[i] = sc.nextInt();
        }

        return array;
    }

    public static void printArray(int[] array){
        for(int i=0; i<array.length; i++){
            System.out.println(array[i]);
        }
    }

    public static int[] ascSort(int[] array){
        int[] arr = Arrays.copyOf(array, array.length);
        int tmp;
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr.length-i-1; j++){
                if(arr[j] > arr[j+1]){
                    tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
        }
        return arr;
    }

    public static int[] descSort(int[] array){
        int[] arr = Arrays.copyOf(array, array.length);
        int tmp;
        for(int i=0; i<arr.length; i++){
            for(int j=0+i; j<arr.length-1; j++){
                if(arr[j] < arr[j+1]){
                    tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
        }

        return arr;
    }

    public static int minEle(int[] array){
        int min = array[0];
        for(int i=1; i<array.length; i++) {
            if(array[i] < min){
                min = array[i];
            }
        }
        return min;
    }

    public static int maxEle(int[] array){
        int max = array[0];
        for(int i=1; i<array.length; i++) {
            if(array[i] > max){
                max = array[i];
            }
        }
        return max;
    }

    public static void displayInt(int num){
        System.out.println(" -> "+num);
    }

    public static int[] reverseArray(int[] array){
        int[] arr = new int[array.length];
        for(int i=0; i<arr.length; i++) {
            arr[i] = array[array.length-i-1];
        }       
        return arr;
    }

    public static void reverse(int[] array) {
        int tmp;
        for(int i=0; i<array.length/2; i++) {
            tmp = array[i];
            array[i] = array[array.length-i-1];
            array[array.length-i-1] = tmp;
        }
        System.out.println(Arrays.toString(array));
    }
}