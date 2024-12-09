package org.academy.kata.implementation.nestea4;

import org.academy.kata.IFive;

import java.math.BigInteger;

public class Five implements IFive {
    @Override
    public long[] gap(int g, long m, long n) {
        long lastPrime = 0;

        for (long current = m; current <= n; current++) {
            boolean isPrime = true;
            if (current < 2 || (current > 2 && current % 2 == 0)) {
                isPrime = false;
            } else {
                for (long i = 3; i * i <= current; i += 2) {
                    if (current % i == 0) {
                        isPrime = false;
                        break;
                    }
                }
            }
            if (isPrime) {
                if (lastPrime != 0 && current - lastPrime == g) {
                    return new long[]{lastPrime, current};
                }
                lastPrime = current;
            }
        }
        return null;
    }

    @Override
    public int zeros(int n) {
        int count = 0;
        for (int i = 5; n/i >= 1; i *= 5) {
            count += n/i;
        }
        return count;
    }

    @Override
    public BigInteger perimeter(BigInteger n) {
        int num = n.intValue();
        BigInteger a = BigInteger.ONE;
        BigInteger b = BigInteger.ONE;
        BigInteger sum = a;

        for (int i=1; i<=num; i++) {
            sum = sum.add(b);
            BigInteger temp = b;
            b = a.add(b);
            a = temp;
        }
        return sum.multiply(BigInteger.valueOf(4));
    }

    @Override
    public double solve(double m) {
        double left = 0;
        double right = 1;

        for (int i=0; i<100; i++) {
            double x = (left+right) / 2;
            double result = x / ((1-x) * (1-x));

            if (Math.abs(result-m) < 1e-12) {
                return x;
            }

            if (result<m) {
                left = x;
            } else {
                right = x;
            }
        }

        return (left + right)/2;
    }

    @Override
    public long[] smallest(long n) {
        return new long[0];
    }
}
