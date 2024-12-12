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
        double left = 0.0;  //Start of the domain
        double right = 1.0; //End of the domain
        double epsilon = 1e-12; //Precision threshold

        while (right - left > epsilon) {
            double mid = (left + right) / 2.0;
            double seriesValue = mid / Math.pow(1 - mid, 2);

            if (seriesValue < m) {
                left = mid; //Move closer to the solution
            } else {
                right = mid; //Narrow down the range
            }
        }

        return (left + right) / 2.0; //Midpoint as the final answer
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
