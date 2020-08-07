import java.util.Arrays;

public class secondHighest {
    public static void main(String[] args) {
        int[] arr = {1,2,9,6,4,2,3,};

        Arrays.sort(arr);

        System.out.println(arr[arr.length - 2]);
    }
}
