package org.academy.kata.implementation.TanyaB777;

import org.academy.kata.IFive;

import java.math.BigInteger;

public class Five implements IFive {
    @Override
    public long[] gap(int g, long m, long n) {
        long firstPrime = -1;

        for (long i = m; i <= n; i++) {
            if (isPrime(i)) {
                if (firstPrime != -1 && i - firstPrime == g) {
                    return new long[]{firstPrime, i};
                }
                firstPrime = i;
            }
        }

        return null;
    }

    private boolean isPrime(long num) {
        if (num < 2) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }

    @Override
    public int zeros(int n) {
        int count = 0;
        int div;

        while (n >= 5) {
            div = n / 5;
            count += div;
            n = div;
        }

        return count;
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
