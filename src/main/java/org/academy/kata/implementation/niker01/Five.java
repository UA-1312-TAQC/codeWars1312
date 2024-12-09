package org.academy.kata.implementation.niker01;

import org.academy.kata.IFive;

import java.math.BigInteger;



import java.util.Arrays;
public class Five implements IFive {
    @Override
    public long[] gap(int g, long m, long n) {
         boolean[] sieve = new boolean[(int) n + 1];
        Arrays.fill(sieve, true);
        sieve[0] = sieve[1] = false;
        
        for (long i = 2; i * i <= n; i++) {
            if (sieve[(int) i]) {
                for (long j = i * i; j <= n; j += i) {
                    sieve[(int) j] = false;
                }
            }
        }
        long prevPrime = -1;
        for (long i = m; i <= n; i++) {
            if (sieve[(int) i]) {
                if (prevPrime != -1 && i - prevPrime == g) {
                    return new long[] { prevPrime, i };
                }
                prevPrime = i;
            }
        }
        return null;  
    }

    @Override
    public int zeros(int n) {
      int count = 0;
      while (n >= 5) {
          n /= 5;
          count += n;
      }
      return count;
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
