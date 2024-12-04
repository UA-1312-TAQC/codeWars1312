package org.academy.kata.implementation.BasilJaworski;

import org.academy.kata.IFive;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.math.BigInteger;

public class Five implements IFive {
    @Override
    public long[] gap(int g, long m, long n) {
        List<Long> primes = sieveOfEratosthenes(n);
        for (int i = 0; i < primes.size() - 1; i++) {
            if (primes.get(i) >= m && primes.get(i + 1) <= n && primes.get(i + 1) - primes.get(i) == g) {
                return new long[]{primes.get(i), primes.get(i + 1)};
            }
        }
        return null;
    }

    private static List<Long> sieveOfEratosthenes(long n) {
        boolean[] isPrime = new boolean[(int) (n + 1)];
        Arrays.fill(isPrime, true);
        List<Long> primes = new ArrayList<>();

        isPrime[0] = isPrime[1] = false;

        for (long i = 2; i * i <= n; i++) {
            if (isPrime[(int) i]) {
                for (long j = i * i; j <= n; j += i) {
                    isPrime[(int) j] = false;
                }
            }
        }

        for (long i = 2; i <= n; i++) {
            if (isPrime[(int) i]) {
                primes.add(i);
            }
        }

        return primes;
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
        return new long[0];
    }
}
