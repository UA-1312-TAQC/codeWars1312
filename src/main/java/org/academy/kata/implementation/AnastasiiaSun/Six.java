package org.academy.kata.implementation.AnastasiiaSun;

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
        if (lstOfArt.length == 0 || lstOf1stLetter.length == 0) {
            return "";
        }

        Map<String, Integer> categoriesAndQuantities = new HashMap<>();
        for (String category : lstOf1stLetter) {
            categoriesAndQuantities.put(category, 0);
        }

        for (String stockItem : lstOfArt) {
            String[] parts = stockItem.split(" ");
            String category = parts[0].substring(0, 1);
            int quantity = Integer.parseInt(parts[1]);

            if (categoriesAndQuantities.containsKey(category)) {
                categoriesAndQuantities.put(category, categoriesAndQuantities.get(category) + quantity);
            }
        }
        StringBuilder result = new StringBuilder();
        for (String category : lstOf1stLetter) {
            if (!result.isEmpty()) {
                result.append(" - ");
            }
            result.append("(").append(category).append(" : ").append(categoriesAndQuantities.get(category)).append(")");
        }
        return result.toString();
    }
}
