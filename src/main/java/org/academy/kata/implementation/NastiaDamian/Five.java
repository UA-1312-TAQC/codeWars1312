package org.academy.kata.implementation.NastiaDamian;

import org.academy.kata.Base;
import org.academy.kata.IFive;

import java.math.BigInteger;

public class Five extends Base implements IFive {
    @Override
    public long[] gap(int g, long m, long n) {
        long previousPrime = -1;

        for (long i = m; i <= n; i++) {
            if (isPrime(i)) {
                if (previousPrime != -1 && i - previousPrime == g) {
                    return new long[]{previousPrime, i};
                }
                previousPrime = i;
            }
        }
        return null;
    }

    static boolean isPrime(long num) {
        if (num < 2) return false;
        if (num == 2) return true;
        if (num % 2 == 0) return false;

        long sqrtNum = (long) Math.sqrt(num);
        for (long i = 3; i <= sqrtNum; i += 2) {
            if (num % i == 0) return false;
        }
        return true;
    }

    @Override
    public int zeros(int n) {
        int count = 0;
        for (int i = 5; n / i >= 1; i *= 5) {
            count += n / i;
        }
        return count;
    }

    @Override
    public BigInteger perimeter(BigInteger n) {
        if (n.equals(BigInteger.ZERO)) {
            return BigInteger.valueOf(4);
        }

        BigInteger fib1 = BigInteger.ONE;
        BigInteger fib2 = BigInteger.ONE;
        BigInteger fibNext = BigInteger.ZERO;

        for (BigInteger i = BigInteger.valueOf(2); i.compareTo(n.add(BigInteger.valueOf(2))) <= 0; i = i.add(BigInteger.ONE)) {
            fibNext = fib1.add(fib2);
            fib1 = fib2;
            fib2 = fibNext;
        }

        return fib2.subtract(BigInteger.ONE).multiply(BigInteger.valueOf(4));
    }

    @Override
    public double solve(double m) {
        return -(-2 * m + Math.sqrt(4 * m + 1) - 1) / (2 * m);
    }

    @Override
    public long[] smallest(long n) {
        long min = n;
        int indexI = 0;
        int indexJ = 0;
        String number = String.valueOf(n);

        for (int i = 0; i < number.length(); i++) {
            for (int j = 0; j < number.length(); j++) {
                if (i != j) {
                    StringBuilder newNumb = new StringBuilder(number);
                    char c = newNumb.charAt(i);
                    newNumb.deleteCharAt(i);
                    newNumb.insert(j, c);
                    long newNumber = Long.parseLong(newNumb.toString());
                    if (newNumber < min) {
                        min = newNumber;
                        indexI = i;
                        indexJ = j;
                    }
                }
            }
        }
        return new long[]{min, indexI, indexJ};
    }
}
