package org.academy.kata.implementation.kiyanovskaa;

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
        if (m <= 0) {
            throw new IllegalArgumentException();
        }
        double discriminant = Math.sqrt(4.0 * m + 1.0);

        double x = (2.0 * m + 1.0 - discriminant) / (2.0 * m);

        return x;
    }

    @Override
    public long[] smallest(long n) {
        return new long[0];
    }
}
