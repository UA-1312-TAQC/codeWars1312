package org.academy.kata.implementation.BasilJaworski;

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
        String str = String.valueOf(n);
        int len = str.length();
        int minIdx = -1;
        int insertIdx = -1;
        long minValue = n;

        for (int i = 0; i < len; i++) {
            char digit = str.charAt(i);

            for (int j = 0; j < len; j++) {
                if (i == j) continue;

                StringBuilder newStr = new StringBuilder(str);
                newStr.deleteCharAt(i);
                newStr.insert(j, digit);

                long newNum = Long.parseLong(newStr.toString());

                if (newNum < minValue) {
                    minValue = newNum;
                    minIdx = i;
                    insertIdx = j;
                }
            }
        }

        return new long[] {minValue, minIdx, insertIdx};
    }
}
