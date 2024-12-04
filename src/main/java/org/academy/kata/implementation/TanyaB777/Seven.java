package org.academy.kata.implementation.TanyaB777;

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

        double sum = 0.0;
        int denominator = 1;

        for (int i = 0; i < n; i++) {
            sum += 1.0 / denominator;
            denominator += 3;
        }

        return String.format("%.2f", sum);
    }
}
