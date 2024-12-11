package org.academy.kata.implementation.ivanromanuik2014;

import org.academy.kata.IFive;

import java.math.BigInteger;
import java.util.ArrayList;

public class Five implements IFive {
    @Override
    public long[] gap(int g, long m, long n) {
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
        ArrayList<BigInteger> fibs = new ArrayList<>();
        fibs.add(BigInteger.ONE);
        fibs.add(BigInteger.ONE);

        for (BigInteger i = BigInteger.valueOf(2); i.compareTo(n) <= 0; i = i.add(BigInteger.ONE)) {
            BigInteger nextFibItem = fibs.get(fibs.size() - 1).add(fibs.get(fibs.size() - 2));
            fibs.add(nextFibItem);
        }

        BigInteger sumFibs = BigInteger.ZERO;
        for (BigInteger elem : fibs) {
            sumFibs = sumFibs.add(elem);
        }

        return sumFibs.multiply(BigInteger.valueOf(4));
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
