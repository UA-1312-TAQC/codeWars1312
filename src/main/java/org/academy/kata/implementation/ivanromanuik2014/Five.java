package org.academy.kata.implementation.ivanromanuik2014;

import org.academy.kata.IFive;

import java.math.BigInteger;
import java.util.ArrayList;

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
