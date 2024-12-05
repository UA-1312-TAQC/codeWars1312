package org.academy.kata.implementation.Vovanchek;

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
        double low = 0.0;
        double high = 1.0;
        double eps = 1e-12;

        while (high - low > eps) {
            double mid = (low + high) / 2;
            double f = mid / Math.pow(1 - mid, 2) - m;

            if (f > 0) {
                high = mid; 
            } else {
                low = mid; 
            }
        }

        return (low + high) / 2;
    }

    @Override
    public long[] smallest(long n) {
        return new long[0];
    }
}
