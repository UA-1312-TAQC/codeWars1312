package org.academy.kata.implementation.TanyaB777;

import org.academy.kata.ISeven;

import java.util.Arrays;

public class Seven implements ISeven {
    @Override
    public long newAvg(double[] arr, double navg) {
        double sum = Arrays
                .stream(arr)
                .sum();

        double donation = navg * (arr.length + 1) - sum;

        if (donation <= 0) {
            return 0;
        }

        return (long) Math.ceil(donation);
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
