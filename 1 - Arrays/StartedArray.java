package programs;

import java.util.Scanner;

public class StartedArray {
    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.print("n = ");
        int n = sc.nextInt();
        int[] intArray = getData(n);

        display(intArray);

        System.out.println(average(intArray)); 

        sc.close();
    }

    public static int[] getData(int num){
        // Scanner sc = new Scanner(System.in);
        System.out.println("Enter " + num + " Elements: \r");
        int[] valuesArray = new int[num];

        for(int i=0; i<num; i++){
            valuesArray[i] = sc.nextInt();
        }

        return valuesArray;

    }

    public static void display(int[] array){
        for(int i=0; i<array.length; i++){
            System.out.println("ele " + i + "->" + array[i]);
        }
    } 

    public static double average(int[] array){
        int sum = 0;
        for(int i=0; i<array.length; i++){
            sum += array[i];
        }

        return (double) sum / (double) array.length;
    }
}