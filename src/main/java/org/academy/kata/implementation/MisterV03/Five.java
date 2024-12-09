package org.academy.kata.implementation.MisterV03;

import org.academy.kata.IFive;

import java.math.BigInteger;

public class Five implements IFive {

    private static boolean isPrime(long n) {
        for(long i = 2; i<=n/2; i++) {
            if(n%i==0)
                return false;
        }
        return true;
    }

    @Override
    public long[] gap(int g, long m, long n) {
        long maxGap = 1;
        long i = 0;
        long startIndex = 0;
        for(i = m; i<=n; i++) {
            if(isPrime(i))
                break;
        }
        startIndex = i;
        for(; i<=n; i++) {
            if(isPrime(i)) {
                if(g==maxGap) {
                    return new long[]{(long)startIndex, (long)i};
                }
                maxGap = 1;
                startIndex = i;
                continue;
            }
            maxGap++;
        }
        return null;
    }

    @Override
    public int zeros(int n) {
        int totalSum = 0;
        while(n>0){
            n=n/5;
            totalSum+=n;
        }
        return totalSum;
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
