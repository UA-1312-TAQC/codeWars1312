package org.academy.kata.implementation.daniilrusanov;

import org.academy.kata.IFive;

import java.math.BigInteger;

public class Five implements IFive {
    @Override
    public long[] gap(int g, long m, long n) {
        long prevPrime = -1;

        for (long i = m; i <= n; i++) {
            if (isPrime(i)) {
                if(prevPrime != i && i - prevPrime == g) {
                    return new long[]{prevPrime, i};
                }
                prevPrime = i;
            }
        }
        return null;
    }

    private static boolean isPrime(long num) {
        if (num < 2) return false;
        for (long i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }

    @Override
    public int zeros(int n) {
        int zeros = 0;
        while (n > 0) {
            n /= 5;
            zeros += n;
        }
        return zeros;
    }

    @Override
    public BigInteger perimeter(BigInteger n) {
        BigInteger sum = BigInteger.ONE;

        BigInteger prev = BigInteger.ZERO;
        BigInteger curr = BigInteger.ONE;

        for (BigInteger i = BigInteger.TWO; i.compareTo(n.add(BigInteger.ONE)) <= 0; i = i.add(BigInteger.ONE)) {
            BigInteger temp = curr;
            curr = curr.add(prev);
            prev = temp;

            sum = sum.add(curr);
        }

        return sum.multiply(BigInteger.valueOf(4));
    }

    @Override
    public double solve(double m) {
        double root = Math.sqrt(4 * m + 1);
        return (2 * m + 1 - root) / (2 * m);
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
