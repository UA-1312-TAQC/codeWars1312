package org.academy.kata.implementation.daniilrusanov;

import org.academy.kata.ISix;

public class Six implements ISix {
    @Override
    public long findNb(long m) {
        return 0;
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
        if(lstOfArt.length == 0 || lstOf1stLetter.length == 0)
            return "";

        int[] quantities = new int[lstOf1stLetter.length];

        for (String art : lstOfArt) {
            String[] parts = art.trim().split(" ");
            String letter = parts[0].substring(0, 1);

            for (int i = 0; i < lstOf1stLetter.length; i++) {
                if(letter.equals(lstOf1stLetter[i]))
                    quantities[i] += Integer.parseInt(parts[1]);
            }
        }

        StringBuilder res = new StringBuilder();
        for (int i = 0; i < lstOf1stLetter.length; i++) {
            res.append("(").append(lstOf1stLetter[i]).append(" : ").append(quantities[i]).append(")");
            if (i != lstOf1stLetter.length-1) {
                res.append(" - ");
            }
        }
        return res.toString();
    }
}
