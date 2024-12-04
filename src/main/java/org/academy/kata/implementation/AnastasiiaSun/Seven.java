package org.academy.kata.implementation.AnastasiiaSun;

import org.academy.kata.ISeven;

public class Seven implements ISeven {
    @Override
    public long newAvg(double[] arr, double navg) {
        double currentSum = 0;
        for (double donation : arr) {
            currentSum += donation;
        }

        int n = arr.length + 1;
        double totalSum = navg * n;
        double newDonation = totalSum - currentSum;

        if (newDonation <= 0) {
            throw new IllegalArgumentException("Expected donation must be greater than zero.");
        }

        return (long) Math.ceil(newDonation);
    }

    @Override
    public String seriesSum(int n) {
        return "";
    }
}
