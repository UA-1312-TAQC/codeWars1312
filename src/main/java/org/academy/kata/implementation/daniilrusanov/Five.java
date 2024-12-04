package org.academy.kata.implementation.daniilrusanov;

import org.academy.kata.IFive;

import java.math.BigInteger;

public class Five implements IFive {
    @Override
    public long[] gap(int g, long m, long n) {
        long prevPrime = -1;

        for (long i = m; i <= n; i++) {
            if (isPrime(i)) {
                if(prevPrime != i && i - prevPrime == g) {
                    return new long[]{prevPrime, i};
                }
                prevPrime = i;
            }
        }
        return null;
    }

    private static boolean isPrime(long num) {
        if (num < 2) return false;
        for (long i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
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
        return 0;
    }

    @Override
    public long[] smallest(long n) {
        return new long[0];
    }
}
