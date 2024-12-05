package org.academy.kata.implementation.ivanromanuik2014;

import org.academy.kata.ISeven;

public class Seven implements ISeven {
    @Override
    public long newAvg(double[] arr, double navg) {
        double arrSum = 0;
        for (double arrNumber : arr) {
            arrSum += arrNumber;
        }
        long lastValue = (long) Math.ceil(navg * (arr.length + 1) - arrSum);

        if (lastValue > 0) {
            return lastValue;
        }
        throw new IllegalArgumentException();
    }

    @Override
    public String seriesSum(int n) {
        return "";
    }
}
