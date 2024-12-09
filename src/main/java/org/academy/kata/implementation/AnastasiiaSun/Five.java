package org.academy.kata.implementation.AnastasiiaSun;

import org.academy.kata.IFive;

import java.math.BigInteger;

public class Five implements IFive {
    @Override
    public long[] gap(int g, long m, long n) {
        long lastPrime = -1;
        for (long i = m; i <= n; i++) {
            if (isPrime(i)) {
                if (lastPrime != -1 && i - lastPrime == g) {
                    return new long[]{lastPrime, i};
                }
                lastPrime = i;
            }
        }
        return null;
    }

    private static boolean isPrime(long inputNumber) {
        boolean isItPrime = true;
        if (inputNumber <= 1) {
            isItPrime = false;
        } else {
            for (int i = 2; i <= inputNumber / 2; i++) {
                if ((inputNumber % i) == 0) {
                    isItPrime = false;
                    break;
                }
            }
        }
        return isItPrime;
    }

    @Override
    public int zeros(int n) {
        if (n < 0) {
            return 0;
        }
        int zeroCount = 0;
        for (long i = 5; i <= n; i *= 5) {
            zeroCount += (int) (n / i);
        }
        return zeroCount;
    }

    @Override
    public BigInteger perimeter(BigInteger n) {
        BigInteger a = BigInteger.ONE;
        BigInteger b = BigInteger.ONE;
        BigInteger sum = BigInteger.TWO;

        for (int i = 2; i <= n.intValue(); i++) {
            BigInteger next = a.add(b);
            sum = sum.add(next);
            a = b;
            b = next;
        }
        return sum.multiply(BigInteger.valueOf(4));
    }

    @Override
    public double solve(double m) {
        double low = 0;
        double high = 1;
        double epsilon = 1e-12;

        while (high - low > epsilon) {
            double mid = (low + high) / 2;
            double sum = mid / Math.pow(1 - mid, 2);

            if (sum < m) {
                low = mid;
            } else {
                high = mid;
            }
        }

        double result = (low + high) / 2;

        if (Math.abs(result / Math.pow(1 - result, 2) - m) > 1e-9) {
            throw new IllegalStateException("The result does not match the expected value.");
        }
        return result;
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
