package org.academy.kata.implementation.ivanromanuik2014;

import org.academy.kata.IFive;

import java.math.BigInteger;

public class Five implements IFive {
    @Override
    public static long[] gap(int g, long m, long n) {
        long last = Long.MIN_VALUE;
        for (long i = m; i < n; i++) {
            if (isPrime(i)) {
                if (i - last == g) {
                    return new long[] { last, i };
                }
                last = i;
            }
        }

        return null;
    }

    public static boolean isPrime(long i) {
        for (long j = 2; j < i / 2; j++) {
            if (i % j == 0)
                return false;
        }
        return true;
    }

    @Override
    public int zeros(int n) {
        int countTrailingZero = 0;
        while (n >= 5) {
            n /= 5;
            countTrailingZero += n;
        }
        return countTrailingZero;
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
