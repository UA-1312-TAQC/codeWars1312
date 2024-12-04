package org.academy.kata.implementation.NastiaDamian;

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
        if (n.equals(BigInteger.ZERO)) {
            return BigInteger.valueOf(4);
        }

        BigInteger fib1 = BigInteger.ONE;
        BigInteger fib2 = BigInteger.ONE;
        BigInteger fibNext = BigInteger.ZERO;

        for (BigInteger i = BigInteger.valueOf(2); i.compareTo(n.add(BigInteger.valueOf(2))) <= 0; i = i.add(BigInteger.ONE)) {
            fibNext = fib1.add(fib2);
            fib1 = fib2;
            fib2 = fibNext;
        }

        return fib2.subtract(BigInteger.ONE).multiply(BigInteger.valueOf(4));
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
