package org.academy.kata.implementation.AnastasiiaSun;

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
        double result = 0.00;
        for (int i = 0; i < n; i++) {
            result += 1.0 / (i * 3 + 1);
        }
        return String.format("%.2f", result);
    }
}
