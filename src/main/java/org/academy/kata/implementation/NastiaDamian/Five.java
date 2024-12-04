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
        return null;
    }

    @Override
    public double solve(double m) {
        return 0;
    }

    @Override
    public long[] smallest(long n) {
        long min = n;
        int indexI = 0;
        int indexJ = 0;
        String number = String.valueOf(n);

        for (int i = 0; i < number.length(); i++) {
            for (int j = 0; j < number.length(); j++) {
                if (i != j) {
                    StringBuilder newNumb = new StringBuilder(number);
                    char c = newNumb.charAt(i);
                    newNumb.deleteCharAt(i);
                    newNumb.insert(j, c);
                    long newNumber = Long.parseLong(newNumb.toString());
                    if (newNumber < min) {
                        min = newNumber;
                        indexI = i;
                        indexJ = j;
                    }
                }
            }
        }
        return new long[]{min, indexI, indexJ};
    }
}
