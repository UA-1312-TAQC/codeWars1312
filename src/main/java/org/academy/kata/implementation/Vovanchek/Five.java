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
         int count = 0;

        while (n >= 5) {
            n /= 5; 
            count += n; 
        }

        return count;
     
    }

    @Override
    public BigInteger perimeter(BigInteger n) {
        BigInteger a = BigInteger.ONE; 
        BigInteger b = BigInteger.ONE; 
        BigInteger sum = a.add(b); 

        for (BigInteger i = BigInteger.TWO; i.compareTo(n) <= 0; i = i.add(BigInteger.ONE)) {
            BigInteger next = a.add(b); 
            sum = sum.add(next); 
            a = b;
            b = next; 
        }

        return sum.multiply(BigInteger.valueOf(4));
    }

    @Override
    public double solve(double m) {
        double low = 0.0;
        double high = 1.0;
        double eps = 1e-12;

        while (high - low > eps) {
            double mid = (low + high) / 2;
            double f = mid / Math.pow(1 - mid, 2) - m;

            if (f > 0) {
                high = mid; 
            } else {
                low = mid; 
            }
        }

        return (low + high) / 2;
    }

    @Override
    public long[] smallest(long n) {
        String num = String.valueOf(n);
        long minNumber = n;
        int fromIndex = 0; 
        int toIndex = 0;  


        for (int i = 0; i < num.length(); i++) {
            char digit = num.charAt(i);

           
            StringBuilder temp = new StringBuilder(num);
            temp.deleteCharAt(i);

            for (int j = 0; j <= temp.length(); j++) {
                StringBuilder newNumber = new StringBuilder(temp);
                newNumber.insert(j, digit);

                long candidate = Long.parseLong(newNumber.toString());
                if (candidate < minNumber) {
                    minNumber = candidate;
                    fromIndex = i;
                    toIndex = j;
                }
            }
        }

        return new long[]{minNumber, fromIndex, toIndex};
    }
}
