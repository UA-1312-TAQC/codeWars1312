package org.academy.kata.implementation.TanyaB777;

import org.academy.kata.ISix;

import java.util.HashMap;
import java.util.Map;

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
        if (lstOfArt == null || lstOf1stLetter == null || lstOfArt.length == 0 || lstOf1stLetter.length == 0){
            return "";
        }

        Map<String, Integer> categoryCounts = new HashMap<>();

        for (String category : lstOf1stLetter) {
            categoryCounts.put(category, 0);
        }

        for (String book : lstOfArt) {
            String[] parts = book.split(" ");
            String category = parts[0].substring(0, 1);

            int bookCount = Integer.parseInt(parts[1]);

            if (categoryCounts.containsKey(category)) {
                categoryCounts.put(category, categoryCounts.get(category) + bookCount);
            }
        }

        StringBuilder result = new StringBuilder();
        for (String category : lstOf1stLetter) {
            if (!result.isEmpty()) {
                result.append(" - ");
            }
            result.append("(").append(category).append(" : ").append(categoryCounts.get(category)).append(")");
        }

        return result.toString();
    }
}
