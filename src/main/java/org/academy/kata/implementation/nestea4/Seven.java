package org.academy.kata.implementation.nestea4;

import org.academy.kata.ISeven;

public class Seven implements ISeven {
    @Override
    public long newAvg(double[] arr, double navg) {
        double curSum = 0;
        for(double donation : arr){
            curSum+=donation;
        }

        double nextDonation = navg*(arr.length+1)-curSum;
        if (nextDonation<=0) {
            throw new IllegalArgumentException();
        }
        return (long) Math.ceil(nextDonation);
    }

    @Override
    public String seriesSum(int n) {
        return "";
    }
}
