package org.academy.kata.implementation.NatalyKokhaniuk;

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
        double epsilon = 1e-12;  
        double mid = 0.0;
        double fx;

        while (high - low > epsilon) {
            mid = (low + high) / 2.0;
            fx = mid / Math.pow(1 - mid, 2) - m;

            if (Math.abs(fx) < epsilon) {
                break;
            }

            if (fx < 0) {
                low = mid;
            } else {
                high = mid;
            }
        }

        return mid;
    }

    @Override
    public long[] smallest(long n) {
        return new long[0];
    }
}
