package org.academy.kata.implementation.TanyaB777;

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
            throw new IllegalArgumentException("Parameter m must be greater than 0.");
        }

        double sqrtTerm = Math.sqrt(1 + 4 * m);
        double x = ((2 * m + 1) - sqrtTerm) / (2 * m);

        if (Double.isNaN(x) || Double.isInfinite(x)) {
            throw new ArithmeticException("Result is not a valid double.");
        }

        return x;
    }

    @Override
    public long[] smallest(long n) {
        return new long[0];
    }
}
