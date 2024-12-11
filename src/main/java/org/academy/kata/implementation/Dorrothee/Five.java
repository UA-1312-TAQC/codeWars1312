package org.academy.kata.implementation.Dorrothee;

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
        String strNumber = Long.toString(n);
        long number = n;
        int taken = -1;
        int inserted = -1;

        //Go through each digit in the number to find the smallest "combination"
        for (int i = 0; i < strNumber.length(); i++) {
            char digit = strNumber.charAt(i);
            StringBuilder sb = new StringBuilder(strNumber);
            sb.deleteCharAt(i);  //Remove the digit at index i

            //Inserting the digit at each position j to find the smallest "combination"
            for (int j = 0; j <= sb.length(); j++) {
                sb.insert(j, digit);
                long newNumber = Long.parseLong(sb.toString());

                //Update the number value if the new number is smaller
                if (newNumber < number) {
                    number = newNumber;
                    taken = i;
                    inserted = j;
                }

                //Restore the string for the next iteration
                sb.deleteCharAt(j);
            }
        }

        return new long[] {number, taken, inserted};
    }
}
