package org.academy.kata.implementation.Dorrothee;

import org.academy.kata.IFive;

import java.math.BigInteger;

public class Five implements IFive {

    //Check if a number is prime
    private static boolean isPrime(long num) {
        if (num < 2) return false;
        for (long i = 2; i * i <= num; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
    @Override
    public long[] gap(int g, long m, long n) {
        long[] result = new long[2];

        //Variable to hold the previous prime number
        long previous = 0;

        for (long i = m; i <= n; i++) {
            if (isPrime(i)) {
                if (previous != 0 && (i - previous) == g) {
                    result[0] = previous;
                    result[1] = i;
                    return result;
                }
                previous = i;
            }
        }

        //If no pair is found
        return null;
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
