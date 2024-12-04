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
            throw new IllegalArgumentException("The required donation must be greater than 0.");
        }

        return (long) Math.ceil(donation);
    }

    @Override
    public String seriesSum(int n) {
        return "";
    }
}
