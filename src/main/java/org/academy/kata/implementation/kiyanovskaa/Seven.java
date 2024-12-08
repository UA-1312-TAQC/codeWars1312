package org.academy.kata.implementation.kiyanovskaa;

import org.academy.kata.ISeven;

public class Seven implements ISeven {
    @Override
    public long newAvg(double[] arr, double navg) {
        return 0;
    }

    @Override
    public String seriesSum(int n) {
        double sum = 0.0;
        for (int i = 0; i < n; i++) {
            sum += 1.0 / (3 * i + 1);
        }

        return String.format("%.2f", sum);
    }
}
