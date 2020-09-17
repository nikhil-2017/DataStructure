package com.proglang;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String s = scanner.nextLine();

        System.out.println(balancedBrackets(s));

        scanner.close();
    }

    /*

        TC - O(n)
        SC - O(n)
     */
    public static boolean balancedBrackets(String bracketString) {
        String openingBrackets = "([{";
        String closingBrackets = ")]}";
        HashMap<Character, Character> matchingBrackets = new HashMap<>();
        matchingBrackets.put(')', '(');
        matchingBrackets.put(']', '[');
        matchingBrackets.put('}', '{');

        ArrayList<Character> stack = new ArrayList<>();
        char c;

        for (int i=0; i<bracketString.length(); i++) {
            c = bracketString.charAt(i);
            if (openingBrackets.contains(""+c)) {
                stack.add(c);
            }
            else if (closingBrackets.contains(""+c)) {
                if (stack.size() == 0)
                    return false;
                if (stack.get(stack.size() - 1) == matchingBrackets.get(c))
                    stack.remove(stack.size() - 1);
                else
                    return false;
            }
        }
        return stack.size() == 0;
    }
}
