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
       if (n.compareTo(BigInteger.ZERO) <= 0) {
            return BigInteger.valueOf(-1);
        }

        if (n.compareTo(BigInteger.ONE) == 0) {
            return BigInteger.valueOf(4);
        }
        if (n.compareTo(BigInteger.TWO) == 0) {
            return BigInteger.valueOf(8);
        }
        BigInteger in = BigInteger.ZERO;
        ArrayList<BigInteger> list = new ArrayList<>();
        list.add(BigInteger.ONE);
        list.add(BigInteger.ONE);
        for (BigInteger i = BigInteger.TWO; i.compareTo(n) <= 0; i = i.add(BigInteger.ONE)) {
            list.add(list.get(list.size() - 1).add(list.get(list.size() - 2)));
        }
        for (int i=0;i<list.size();i++) in=in.add(list.get(i));
        BigInteger result = in.multiply(BigInteger.valueOf(4));
        System.out.println("perimeter("+n+")  should return "+result);
        return result;
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
