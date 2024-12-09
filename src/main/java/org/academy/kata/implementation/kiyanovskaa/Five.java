package org.academy.kata.implementation.kiyanovskaa;

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
        if (m <= 0) {
            throw new IllegalArgumentException();
        }
        double discriminant = Math.sqrt(4.0 * m + 1.0);

        double x = (2.0 * m + 1.0 - discriminant) / (2.0 * m);

        return x;
    }

    @Override
    public long[] smallest(long n) {
        String numStr = Long.toString(n);
        int length = numStr.length();
        long smallestNumber = n;
        int fromIndex = 0, toIndex = 0;

        for (int i = 0; i < length; i++) {
            char removedDigit = numStr.charAt(i);
            StringBuilder temp = new StringBuilder(numStr);
            temp.deleteCharAt(i);

            for (int j = 0; j <= temp.length(); j++) {
                StringBuilder newNumStr = new StringBuilder(temp);
                newNumStr.insert(j, removedDigit);

                long newNumber = Long.parseLong(newNumStr.toString());

                if (newNumber < smallestNumber ||
                        (newNumber == smallestNumber && i < fromIndex) ||
                        (newNumber == smallestNumber && i == fromIndex && j < toIndex)) {
                    smallestNumber = newNumber;
                    fromIndex = i;
                    toIndex = j;
                }
            }
        }

        return new long[]{smallestNumber, fromIndex, toIndex};
    }
}
