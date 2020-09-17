package com.proglang;

import java.util.HashMap;

public class MinMaxKeyValue {

    // O(1) space ~ O(1)
    private int min;
    private int max;

    public MinMaxKeyValue(int minNum, int maxNum) {
        this.min = minNum;
        this.max = maxNum;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getMinVal() {
        return this.min;
    }

    public int getMaxVal() {
        return this.max;
    }
}
