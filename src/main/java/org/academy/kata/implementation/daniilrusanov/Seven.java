package org.academy.kata.implementation.daniilrusanov;

import org.academy.kata.ISeven;

public class Seven implements ISeven {
    @Override
    public long newAvg(double[] arr, double navg) {
        if(arr == null)
            throw new IllegalArgumentException();

        double sum = 0;
        for (double val : arr)
            sum += val;

        double res = navg * (arr.length + 1) - sum;
        if (res < 0)
            throw new IllegalArgumentException();
        else return (long) Math.ceil(res);
    }

    @Override
    public String seriesSum(int n) {
        return "";
    }
}
