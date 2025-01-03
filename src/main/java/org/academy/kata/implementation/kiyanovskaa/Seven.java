package org.academy.kata.implementation.kiyanovskaa;

import org.academy.kata.ISeven;

public class Seven implements ISeven {
    @Override
    public long newAvg(double[] arr, double navg) {
        double sum = 0;
        for (double donation : arr) {
            sum += donation;
        }
        int n = arr.length;
        double nextDonation = (n + 1) * navg - sum;
        if (nextDonation <= 0) {
            throw new IllegalArgumentException();
        }
        return (long) Math.ceil(nextDonation);
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
