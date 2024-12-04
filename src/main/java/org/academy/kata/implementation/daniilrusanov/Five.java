package org.academy.kata.implementation.daniilrusanov;

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
        double root = Math.sqrt(4 * m + 1);
        return (2 * m + 1 - root) / (2 * m);
    }

    @Override
    public long[] smallest(long n) {
        return new long[0];
    }
}
