package org.academy.kata.implementation.nestea4;

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
        String numStr = String.valueOf(n);
        int len = numStr.length();

        long smallestNum = n;
        int takeIdx = 0;
        int putIdx = 0;
        for (int i=0; i<len; i++) {
            for (int j=0; j<len; j++) {
                StringBuilder sb = new StringBuilder(numStr);
                char digit = sb.charAt(i);
                sb.deleteCharAt(i);
                sb.insert(j, digit);

                long newNum = Long.parseLong(sb.toString());
                if (newNum<smallestNum || (newNum == smallestNum && (i<takeIdx || (i == takeIdx && j<putIdx)))) {
                    smallestNum = newNum;
                    takeIdx = i;
                    putIdx = j;
                }
            }
        }

        return new long[] {smallestNum,takeIdx,putIdx};
    }
}
