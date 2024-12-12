package org.academy.kata.implementation.NatalyKokhaniuk;

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
