package org.academy.kata.implementation.AnastasiiaSun;

import org.academy.kata.IFive;

import java.math.BigInteger;

public class Five implements IFive {
    @Override
    public long[] gap(int g, long m, long n) {
        return new long[0];
    }

    @Override
    public int zeros(int n) {
        return 0;
    }

    @Override
    public BigInteger perimeter(BigInteger n) {
        return null;
    }

    @Override
    public double solve(double m) {
        double low = 0;
        double high = 1;
        double epsilon = 1e-12;

        while (high - low > epsilon) {
            double mid = (low + high) / 2;
            double sum = mid / Math.pow(1 - mid, 2);

            if (sum < m) {
                low = mid;
            } else {
                high = mid;
            }
        }

        double result = (low + high) / 2;

        if (Math.abs(result / Math.pow(1 - result, 2) - m) > 1e-9) {
            throw new IllegalStateException("The result does not match the expected value.");
        }
        return result;
    }

    @Override
    public long[] smallest(long n) {
        return new long[0];
    }
}
