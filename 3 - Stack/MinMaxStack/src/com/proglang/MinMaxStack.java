package com.proglang;

import java.util.ArrayList;
import java.util.HashMap;

public class MinMaxStack {

    ArrayList<ArrayList<HashMap<String, Integer>>> minMaxStack;
    ArrayList<Integer> stack;

    public MinMaxStack() {
        this.minMaxStack = new ArrayList<>();
        this.stack = new ArrayList<>();
    }

    // O(1) time / O(1) space
    public void push(int num) {
        HashMap<String, Integer> newMinMax = new HashMap<>();
        newMinMax.put("min", num);
        newMinMax.put("max", num);
        if (minMaxStack.size() > 0) {
            ArrayList<HashMap<String, Integer>> lastMinMax = this.minMaxStack.get(minMaxStack.size()-1);
            newMinMax.replace("min", Math.min(lastMinMax.get(0).get("min"), num));
            newMinMax.replace("max", Math.max(lastMinMax.get(0).get("max"), num));
        }
        ArrayList<HashMap<String, Integer>> mapList = new ArrayList<>();
        mapList.add(newMinMax);
        this.minMaxStack.add(mapList);
        this.stack.add(num);

    }

    // O(1) time / O(1) space
    public int pop() {
        if (stack.size() == 0)
            return -1;

        this.minMaxStack.remove(minMaxStack.size()-1);
        return this.stack.remove(stack.size()-1);
    }

    // O(1) time / O(1) space
    public int peek() {
        if (stack.size() > 0)
            return this.stack.get(stack.size()-1);
        return -1;
    }

    // O(1) time / O(1) space
    public int getMin() {
        if (minMaxStack.size() > 0)
            return this.minMaxStack.get(minMaxStack.size()-1).get(0).get("min");
        return -1;
    }

    // O(1) time / O(1) space
    public int getMax() {
        if (minMaxStack.size() > 0)
            return this.minMaxStack.get(minMaxStack.size()-1).get(0).get("max");
        return -1;
    }

    // O(1) time / O(1) space
    public void displayMinMaxPeek() {
        if (minMaxStack.size() > 0)
            System.out.println("min : " + this.getMin() + " max : " + this.getMax() + " peek : " + this.peek());
        else
            System.out.println("The stack is empty.");
    }
}