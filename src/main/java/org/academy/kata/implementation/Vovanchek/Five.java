package org.academy.kata.implementation.Vovanchek;

import org.academy.kata.IFive;

import java.math.BigInteger;

public class Five implements IFive {
    @Override
    public long[] gap(int g, long m, long n) {
        return new long[0];
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
