package org.academy.kata.implementation.daniilrusanov;

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
        int len = numStr.length();
        long smallest = n;
        int removeIndex = 0, insertIndex = 0;

        for (int i = 0; i < len; i++) {
            char digit = numStr.charAt(i);
            String current = numStr.substring(0, i) + numStr.substring(i + 1);

            for (int j = 0; j <= current.length(); j++) {
                String newStr = current.substring(0, j) + digit + current.substring(j);
                long newNum = Long.parseLong(newStr);

                if (newNum < smallest || (newNum == smallest && i < removeIndex) ||
                        (newNum == smallest && i == removeIndex && j < insertIndex)) {
                    smallest = newNum;
                    removeIndex = i;
                    insertIndex = j;
                }
            }
        }

        return new long[] {smallest, removeIndex, insertIndex};
    }
}
