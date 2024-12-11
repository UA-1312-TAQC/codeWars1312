package org.academy.kata.implementation.Dorrothee;

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
        // 1st parameter is the stocklist (L in example),
        // 2nd parameter is list of categories (M in example)

        if (lstOfArt.length == 0 || lstOf1stLetter.length == 0) { return ""; }

        Map<String, Integer> categories = new HashMap<>();

        for (String category : lstOf1stLetter) {
            categories.put(category, 0); //Categories with quantity of 0
        }

        for (String art:lstOfArt) {
            String[] parts = art.split(" ");

            String code = parts[0];
            int quantity = Integer.parseInt(parts[1]);

            String category = code.substring(0, 1);  //The category is the first letter of the code

            //If the category is in the categories list, add the quantity to the total
            if (categories.containsKey(category)) {
                categories.put(category, categories.get(category) + quantity);
            }
        }

        StringBuilder result = new StringBuilder();

        //Iterate over the categories in the order they appear in lstOf1stLetter
        for (int i = 0; i < lstOf1stLetter.length; i++) {
            String category = lstOf1stLetter[i];
            int total = categories.get(category);

            result.append("(").append(category).append(" : ").append(total).append(")");

            //Add a separator if it's not the last category
            if (i < lstOf1stLetter.length - 1) {
                result.append(" - ");
            }
        }

        return result.toString();
    }
}
