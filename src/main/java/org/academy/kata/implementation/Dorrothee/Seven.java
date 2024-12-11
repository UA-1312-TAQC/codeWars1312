package org.academy.kata.implementation.Dorrothee;

import org.academy.kata.ISeven;

public class Seven implements ISeven {
    @Override
    public long newAvg(double[] arr, double navg) {
        long donation;
        double sumArray = 0;

        for (double el:arr) {
            sumArray += el;
        }

        donation = (long) Math.ceil(navg * (arr.length + 1) - sumArray);

        if (donation <= 0) {
            throw new IllegalArgumentException("The last donation should be a positive number");
        }

        return donation;
    }

    @Override
    public String seriesSum(int n) {
        return "";
    }
}
