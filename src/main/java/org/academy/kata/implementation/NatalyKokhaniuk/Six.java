package org.academy.kata.implementation.NatalyKokhaniuk;

import org.academy.kata.ISix;

public class Six implements ISix {
    @Override
    public long findNb(long m) {
        long res=1, M=m;
        while(M>0){
            M-=res*res*res;
            if(M==0) break;
            res++;
            if(M<res*res*res) {
                System.out.println("Unable to buid a cube from "+m+" blocks.");
                return -1;}
        }
        System.out.println("findNb("+m+") --> "+res);
        return res;
    }

    @Override
    public String balance(String book) {
        return "";
    }

    @Override
    public double f(double x) {
        return 0;
    }

    @Override
    public double mean(String town, String strng) {
        return 0;
    }

    @Override
    public double variance(String town, String strng) {
        return 0;
    }

    @Override
    public String nbaCup(String resultSheet, String toFind) {
        return "";
    }

    @Override
    public String stockSummary(String[] lstOfArt, String[] lstOf1stLetter) {
        return "";
    }
}
