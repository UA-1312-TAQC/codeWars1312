package org.academy.kata.implementation.TanyaB777;

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
        String numString = String.valueOf(n);
        int len = numString.length();
        long minValue = n;
        int fromIndex = 0;
        int toIndex = 0;

        for (int i = 0; i < len; i++) {
            char digit = numString.charAt(i);

            for (int j = 0; j < len; j++) {
                if (i == j) continue;

                StringBuilder sb = new StringBuilder(numString);
                sb.deleteCharAt(i);
                sb.insert(j, digit);

                long newNum = Long.parseLong(sb.toString());

                if (newNum < minValue ||
                        (newNum == minValue && (i < fromIndex || (i == fromIndex && j < toIndex)))) {
                    minValue = newNum;
                    fromIndex = i;
                    toIndex = j;
                }
            }
        }

        return new long[]{minValue, fromIndex, toIndex};
    }
}
