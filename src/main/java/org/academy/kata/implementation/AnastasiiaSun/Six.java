package org.academy.kata.implementation.AnastasiiaSun;

import org.academy.kata.ISix;

import java.util.Locale;

public class Six implements ISix {
    @Override
    public long findNb(long m) {
        return 0;
    }

    @Override
    public String balance(String book) {
        book = book.replaceAll("[^\\w\\. \\n]", "");

        String[] lines = book.split("\n");

        double originalBalance = Double.parseDouble(lines[0]);
        double currentBalance = originalBalance;

        double totalExpense = 0;
        int expenseCount = 0;

        StringBuilder result = new StringBuilder();
        result.append(String.format(Locale.US, "Original Balance: %.2f\\r\\n", originalBalance));

        for (int i = 1; i < lines.length; i++) {
            if (lines[i].trim().isEmpty()) {
                continue;
            }

            String[] parts = lines[i].trim().split("\\s+", 3);
            String checkNumber = parts[0];
            String category = parts[1];
            double amount = Double.parseDouble(parts[2]);

            currentBalance -= amount;
            totalExpense += amount;
            expenseCount++;

            result.append(String.format(Locale.US, "%s %s %.2f Balance %.2f\\r\\n",
                    checkNumber, category, amount, currentBalance));
        }

        result.append(String.format(Locale.US, "Total expense  %.2f\\r\\n", totalExpense));
        result.append(String.format(Locale.US, "Average expense  %.2f", totalExpense / expenseCount));

        return result.toString();
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
