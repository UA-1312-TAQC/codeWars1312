package org.academy.kata.implementation.NatalyKokhaniuk;

import org.academy.kata.IFive;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;

public class Five implements IFive {
    @Override
    public long[] gap(int g, long m, long n) {
        ArrayList<Long> primes = sieveOfEratosthenes(n);

        ArrayList<Long> primesInRange = new ArrayList<>();
        for (Long prime : primes) {
            if (prime >= m) {
                primesInRange.add(prime);
            }
        }

        for (int i = 0; i < primesInRange.size() - 1; i++) {
            long p1 = primesInRange.get(i);
            long p2 = primesInRange.get(i + 1);

            if (p2 - p1 == g) {
                return new long[] {p1, p2};
            }
        }
        return null;
    }

    private static ArrayList<Long> sieveOfEratosthenes(long n) {
        boolean[] isPrime = new boolean[(int) (n + 1)];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        for (long i = 2; i * i <= n; i++) {
            if (isPrime[(int) i]) {
                for (long j = i * i; j <= n; j += i) {
                    isPrime[(int) j] = false;
                }
            }
        }

        ArrayList<Long> primes = new ArrayList<>();
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
