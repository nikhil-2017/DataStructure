package com.proglang;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	    Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Expression: ");
	    String s = scanner.nextLine();
	    String[] strArray = s.split("");

	    int flag=1;
	    String str, popStr;
	    ArrayList<String> stackArray = new ArrayList<>();

	    for(int i=0; i< strArray.length; i++) {
	        str = strArray[i];
	        if(str.equals("(") || str.equals("[") || str.equals("{")) {
	            stackArray.add(str);
            } else if (str.equals(")") || str.equals("]") || str.equals("}")) {
	            if(stackArray.size() == 0) {
	                flag = 0;
                } else {
	                popStr = stackArray.remove(stackArray.size()-1);
	                if(popStr.equals("(") && (str.equals("]") || str.equals("}"))){
	                    flag=0;
                    }
                    if(popStr.equals("[") && (str.equals(")") || str.equals("}"))){
                        flag=0;
                    }
                    if(popStr.equals("{") && (str.equals("]") || str.equals(")"))){
                        flag=0;
                    }
                }
            }
        }

	    if(stackArray.size() > 0){
	        flag = 0;
        }
	    if(flag==1){
            System.out.println("Valid Expression");
        } else {
            System.out.println("Not Valid Expression");
        }

    }
}
