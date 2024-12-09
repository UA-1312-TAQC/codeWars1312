package org.academy.kata.implementation.Vovanchek;

import org.academy.kata.IFive;

import java.math.BigInteger;

public class Five implements IFive {
    @Override
    public long[] gap(int g, long m, long n) {
        long lastPrime = -1;

        for (long i = m; i <= n; i++) {
      
            boolean isPrime = true;
            if (i <= 1) {
                isPrime = false;
            } else if (i == 2) {
                isPrime = true;
            } else if (i % 2 == 0) {
                isPrime = false;
            } else {
                for (long j = 3; j <= Math.sqrt(i); j += 2) {
                    if (i % j == 0) {
                        isPrime = false;
                        break;
                    }
                }
            }

   
            if (isPrime) {
                if (lastPrime != -1 && i - lastPrime == g) {
               
                    return new long[]{lastPrime, i};
                }
             
                lastPrime = i;
            }
        }
        return null; 
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
