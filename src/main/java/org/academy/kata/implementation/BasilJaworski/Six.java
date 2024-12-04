package org.academy.kata.implementation.BasilJaworski;

import org.academy.kata.ISix;

public class Six implements ISix {
    @Override
    public long findNb(long m) {
        long cubes_num = 1;
        long cubes_volume = 0;

        for (; cubes_volume<m; cubes_num++){
            cubes_volume += cubes_num*cubes_num*cubes_num;
        }
        System.out.println(m);
        System.out.println(cubes_volume);

        if (cubes_volume==m){
            return cubes_num-1;
        } else {
            return -1;
        }

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
