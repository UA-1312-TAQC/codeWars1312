package org.academy.kata.implementation.BasilJaworski;

import org.academy.kata.ISeven;

public class Seven implements ISeven {
    @Override
    public long newAvg(double[] arr, double navg) {
        int array_count = arr.length + 1;
        double array_sum = 0.0;

        for (double i : arr){
            array_sum += i;
        }

        double donat = (navg * array_count) - (array_sum);
        long result = (long)Math.ceil(donat);

        if  (result <= 0){
            throw new IllegalArgumentException();
        } else {
            return result;
        }
    }

    @Override
    public String seriesSum(int n) {
        return "";
    }
}
