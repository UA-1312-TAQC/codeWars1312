package org.academy.kata.implementation.AnastasiiaSun;

import org.academy.kata.IFive;

import java.math.BigInteger;

public class Five implements IFive {
    @Override
    public long[] gap(int g, long m, long n) {
        long lastPrime = -1;
        for (long i = m; i <= n; i++) {
            if (isPrime(i)) {
                if (lastPrime != -1 && i - lastPrime == g) {
                    return new long[]{lastPrime, i};
                }
                lastPrime = i;
            }
        }
        return null;
    }

    private static boolean isPrime(long inputNumber) {
        boolean isItPrime = true;
        if (inputNumber <= 1) {
            isItPrime = false;
        } else {
            for (int i = 2; i <= inputNumber / 2; i++) {
                if ((inputNumber % i) == 0) {
                    isItPrime = false;
                    break;
                }
            }
        }
        return isItPrime;
    }

    @Override
    public int zeros(int n) {
        if (n < 0) {
            return 0;
        }
        int zeroCount = 0;
        for (long i = 5; i <= n; i *= 5) {
            zeroCount += (int) (n / i);
        }
        return zeroCount;
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
