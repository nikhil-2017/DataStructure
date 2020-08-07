package programs;

import java.util.Arrays;

public class arraySort {
    public static void main(String[] args) {
        String[] companies = {"Google", "Microsoft", "Acer", "Adobe", "Abc", "Huwai", "Samsung", "Apple"};

        for(int i=0; i<companies.length; i++){
            companies[i] = companies[i].toLowerCase();
        }

        Arrays.sort(companies);

        System.out.println(Arrays.toString(companies));
    }
}