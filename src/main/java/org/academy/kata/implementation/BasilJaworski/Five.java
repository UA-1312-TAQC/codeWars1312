package org.academy.kata.implementation.BasilJaworski;


import java.math.BigInteger;
import org.academy.kata.IFive;

import java.math.BigInteger;

public class Five implements IFive {
    @Override
    public long[] gap(int g, long m, long n) {
        return new long[0];
    }

    @Override
    public int zeros(int n) {
        int count = 0;
        while (n >= 5){
            count += n / 5;
            n /= 5;
        }
        return count;
    }

    @Override
    public BigInteger perimeter(BigInteger n) {
        if (n.equals(BigInteger.ZERO)) {
            return BigInteger.valueOf(4);
        }

        BigInteger a = BigInteger.ONE;
        BigInteger b = BigInteger.ONE;
        BigInteger sum = a.add(b);

        for (BigInteger i = BigInteger.valueOf(2); i.compareTo(n) <= 0; i = i.add(BigInteger.ONE)) {
            BigInteger next = a.add(b);
            sum = sum.add(next);
            a = b;
            b = next;
        }

        return sum.multiply(BigInteger.valueOf(4));
    }

    @Override
    public double solve(double m) {
        double left = 0.0, right = 1.0;

        while (right - left > 1e-12) {
            double mid = (left + right) / 2.0;
            double value = mid / Math.pow(1 - mid, 2);

            if (value > m) {
                right = mid;
            } else {
                left = mid;
            }
        }

        return (left + right) / 2.0;
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
