package com.proglang;

import java.util.ArrayList;

public class MinMaxStack {
    // O(n) space
    private ArrayList<MinMaxKeyValue> minMaxStack;      // O(n) space ~ O(2n)
    private ArrayList<Integer> stack;                   // O(n) space

    public MinMaxStack() {
        this.minMaxStack = new ArrayList<>();
        this.stack = new ArrayList<>();
    }

    // O(1) time / O(1) space
    public void push(int num) {
        MinMaxKeyValue newMinMax = new MinMaxKeyValue(num, num);
        if (minMaxStack.size() > 0) {
            MinMaxKeyValue last = minMaxStack.get(minMaxStack.size()-1);
            newMinMax.setMin(Math.min(last.getMinVal(), num));
            newMinMax.setMax(Math.max(last.getMaxVal(), num));
        }
        minMaxStack.add(newMinMax);
        stack.add(num);
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
            return this.minMaxStack.get(minMaxStack.size()-1).getMinVal();
        return -1;
    }

    // O(1) time / O(1) space
    public int getMax() {
        if (minMaxStack.size() > 0)
            return this.minMaxStack.get(minMaxStack.size()-1).getMaxVal();
        return -1;
    }

    // O(1) time / O(1) space
    public void displayMinMaxPeek() {
        if (minMaxStack.size() > 0)
            System.out.println("min : " + this.getMin() + " max : " + this.getMax() + " peek : " + this.peek());
        else
            System.out.println("The stack is empty.");
    }

    /*

        structure of ArrayList:
        stack - [1,2,3,4,....]
        minMaxStack - [class@MinMaxKeyValue0001, class@MinMaxKeyValue0002, ....]
        class@MinMaxKeyValue0001 -> min = value, max = value

     */
}
