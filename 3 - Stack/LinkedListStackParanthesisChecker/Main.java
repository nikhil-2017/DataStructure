package com.proglang;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Expression: ");
        String s = scanner.nextLine();
        LinkedList stackList = new LinkedList();

        char str, popStr;
        int flag = 1;

        for (int i=0; i<s.length(); i++) {
            str = s.charAt(i);
            if(str=='(' || str=='[' || str=='{') {
                stackList.push(str);
            } else if(str==')' || str==']' || str=='}') {
                if(stackList.size()==0) {
                    flag = 0;
                } else {
                    popStr = stackList.pop();
                    if(popStr=='(' && (str==']' || str=='}')) {
                        flag = 0;
                    }
                    else if(popStr=='[' && (str==')' || str=='}')) {
                        flag = 0;
                    }
                    else if(popStr=='{' && (str==']' || str==')')) {
                        flag = 0;
                    }
                }
            }
        }

        if(stackList.size()>0) {
            flag = 0;
        }
        if(flag==1) {
            System.out.println("Valid Expression");
        } else {
            System.out.println("Not Valid Expression");
        }
    }
}