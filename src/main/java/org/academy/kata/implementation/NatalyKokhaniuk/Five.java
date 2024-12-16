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
       String numStr = Long.toString(n);
        List<Character> digits = new ArrayList<>();
        
        for (char c : numStr.toCharArray()) {
            digits.add(c);
        }
        
        long minNumber = n;   
        int bestI = -1;       
        int bestJ = -1;       

        for (int i = 0; i < digits.size(); i++) {
            char digit = digits.get(i);  
            
            for (int j = 0; j <= digits.size(); j++) {
                if (i == j) continue; 
                
                if (j == digits.size()) {
                    List<Character> newDigits = new ArrayList<>(digits);
                    newDigits.remove(i);   
                    newDigits.add(digit);  
                    StringBuilder newNumStr = new StringBuilder();
                    for (char c : newDigits) {
                        newNumStr.append(c);
                    }
                    long newNumber = Long.parseLong(newNumStr.toString());
                    
                    if (newNumber < minNumber) {
                        minNumber = newNumber;
                        bestI = i;
                        bestJ = j;
                    }
                    continue;
                }

                List<Character> newDigits = new ArrayList<>(digits);
                newDigits.remove(i);   
                newDigits.add(j, digit);  
                
                StringBuilder newNumStr = new StringBuilder();
                for (char c : newDigits) {
                    newNumStr.append(c);
                }
                
                long newNumber = Long.parseLong(newNumStr.toString());

                if (newNumber < minNumber) {
                    minNumber = newNumber;
                    bestI = i;
                    bestJ = j;
                }
            }
        }
        System.out.println("smallest("+n+") --> ["+minNumber+", "+bestI+", "+bestJ+"]");
        return new long[]{minNumber, bestI, bestJ};
    }
}
