package org.academy.kata.implementation.NastiaDamian;

import org.academy.kata.ISeven;

public class Seven implements ISeven {
    @Override
    public long newAvg(double[] arr, double navg) {
        double currentSum = 0;
        for (double arrs : arr) {
            currentSum += arrs;
        }

        double requiredSum = navg * (arr.length + 1);

        double newDonation = requiredSum - currentSum;

        if (newDonation <= 0) {
            throw new IllegalArgumentException("Donation must be positive.");
        }

        return (long) Math.ceil(newDonation);
    }

    @Override
    public String seriesSum(int n) {
        return "";
    }
}
