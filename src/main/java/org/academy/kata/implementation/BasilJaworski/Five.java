package org.academy.kata.implementation.BasilJaworski;

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
        double left = 0.0, right = 1.0;

        while (right - left > 1e-12) {
            double mid = (left + right) / 2.0;
            double value = mid / Math.pow(1 - mid, 2);

            if (value > m) {
                right = mid;
            } else {
                left = mid;
            }
        }

        return (left + right) / 2.0;
    }

    @Override
    public long[] smallest(long n) {
        return new long[0];
    }
}
