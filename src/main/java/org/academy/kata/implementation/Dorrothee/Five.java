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
        return 0;
    }

    @Override
    public BigInteger perimeter(BigInteger n) {
        BigInteger perimeterRecs = BigInteger.ONE;
        BigInteger previous = BigInteger.ONE;
        BigInteger current = BigInteger.ONE;

        for (BigInteger i = BigInteger.ONE; i.compareTo(n) <= 0; i = i.add(BigInteger.ONE)) {
            perimeterRecs = perimeterRecs.add(current);

            //Move to the next Fibonacci number
            BigInteger next = previous.add(current);
            previous = current;
            current = next;
        }

        return perimeterRecs.multiply(BigInteger.valueOf(4));
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
