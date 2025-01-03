package org.academy.kata.implementation.Dorrothee;

import org.academy.kata.ISeven;

import java.math.BigDecimal;
import java.math.RoundingMode;

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
        if (n == 0) { return "0.00"; }

        float result = 0;
        float denominator = 1;

        for (int i = 1; i <= n; i++) {
            result += 1 / denominator;
            denominator += 3;
        }

        BigDecimal resultRounded = new BigDecimal(result);
        resultRounded = resultRounded.setScale(2, RoundingMode.HALF_UP);

        return resultRounded.toString();
    }
}
