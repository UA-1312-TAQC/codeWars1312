package org.academy.kata.implementation.AnastasiiaSun;

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
        long smallestNum = n;
        int sourceIndex = 0;
        int destIndex = 0;

        for (int i = 0; i < numStr.length(); i++) {
            for (int j = 0; j < numStr.length(); j++) {
                if (i == j) continue;

                String newNumStr = removeAndInsert(numStr, i, j);
                long newNum = Long.parseLong(newNumStr);

                if (newNum < smallestNum || (newNum == smallestNum &&
                        (i < sourceIndex || (i == sourceIndex && j < destIndex)))) {
                    smallestNum = newNum;
                    sourceIndex = i;
                    destIndex = j;
                }
            }
        }
        return new long[]{smallestNum, sourceIndex, destIndex};
    }

    private static String removeAndInsert(String numStr, int removeIndex, int insertIndex) {
        StringBuilder sb = new StringBuilder(numStr);
        char digit = sb.charAt(removeIndex);
        sb.deleteCharAt(removeIndex);
        sb.insert(insertIndex, digit);

        return sb.toString();
    }
}
