package org.academy.kata.implementation.ivanromanuik2014;

import org.academy.kata.ISeven;

public class Seven implements ISeven {
    @Override
    public long newAvg(double[] arr, double navg) {
        return 0;
    }

    @Override
    public String seriesSum(int n) {
        if (n == 0) {
            return "0.00";
        }

        double totalSum = 0;

        for (int i = 0; i < n; i++) {
            totalSum += 1.0d / (3 * i + 1);
        }

        return String.format("%.2f", totalSum);
    }
}
