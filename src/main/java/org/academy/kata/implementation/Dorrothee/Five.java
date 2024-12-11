package org.academy.kata.implementation.Dorrothee;

import org.academy.kata.IFive;

import java.math.BigInteger;

public class Five implements IFive {
    @Override
    public long[] gap(int g, long m, long n) {
        return new long[0];
    }

    @Override
    public int zeros(int n) {
        int result = 0;

        int k = (int) Math.floor(Math.log(n) / Math.log(5));
        for (int i = 1; i <= k; i++) {
            result += n / Math.pow(5, i);
        }

        return result;
    }

    @Override
    public BigInteger perimeter(BigInteger n) {
        return null;
    }

    @Override
    public double solve(double m) {
        return 0;
    }

    @Override
    public long[] smallest(long n) {
        return new long[0];
    }
}
