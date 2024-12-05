package org.academy.kata.implementation.MisterV03;

import org.academy.kata.IFive;

import java.math.BigInteger;

public class Five implements IFive {
    public static BigInteger fib(BigInteger num) {
        BigInteger num1 = BigInteger.valueOf(1L);
        BigInteger num2 = BigInteger.valueOf(1L);
        BigInteger sum = BigInteger.valueOf(1L);
        for(long i = 2; BigInteger.valueOf(i).compareTo(num)<=0; i++) {
            sum = sum.add(num2);
            BigInteger temp = num2;
            num2 = num2.add(num1);
            num1 = temp;
        }
        return sum;
    }
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
        return fib(n.add(BigInteger.valueOf(1L))).multiply(BigInteger.valueOf(4L));
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
