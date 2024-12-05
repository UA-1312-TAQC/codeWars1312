package org.academy.kata.implementation.MisterV03;

import org.academy.kata.ISeven;

public class Seven implements ISeven {
    @Override
    public long newAvg(double[] arr, double navg) {
        double sum = 0;
        for (double v : arr) sum += v;
        double res=navg*(arr.length+1) - sum;
        if(res<=0)
            throw new IllegalArgumentException();
        return (long)Math.ceil(res);
    }

    @Override
    public String seriesSum(int n) {
        return "";
    }
}
