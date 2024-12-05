package org.academy.kata.implementation.niker01;

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
        String numStr = Long.toString(n);
        long minNum = n;
        int minI = 0;
        int minJ = 0;
        for (int i = 0; i < numStr.length(); i++) {
            char ch = numStr.charAt(i);
            StringBuilder sb = new StringBuilder(numStr).deleteCharAt(i);
            for (int j = 0; j <= sb.length(); j++) {
                StringBuilder newNumStr = new StringBuilder(sb).insert(j, ch);
                long newNum = Long.parseLong(newNumStr.toString());
                
                if (newNum < minNum) {
                    minNum = newNum;
                    minI = i;
                    minJ = j;
                }
            }
        }
        return new long[] {minNum, minI, minJ};
    }
}
