package org.academy.kata.implementation.kiyanovskaa;

import org.academy.kata.ISix;

public class Six implements ISix {
    @Override
    public long findNb(long m) {
        return 0;
    }

    @Override
    public String balance(String book) {
        String[] lines = book.split("\n");
        StringBuilder result = new StringBuilder();
        double balance = 0;
        double totalExpense = 0;
        int expenseCount = 0;

        if (lines.length > 0) {
            balance = Double.parseDouble(lines[0].replaceAll("[^\\d.]", ""));
            result.append("Original Balance: " + String.format("%.2f", balance) + "\\r\\n");
        }
        for (int i = 1; i < lines.length; i++) {
            String line = lines[i].replaceAll("[^\\w\\d. ]", "");  // Clean the line
            if (line.isEmpty()) continue;  // Skip empty lines

            String[] parts = line.split(" ");
            int checkNumber = Integer.parseInt(parts[0]);
            String category = parts[1];
            double amount = Double.parseDouble(parts[2]);

            balance -= amount;
            totalExpense += amount;
            expenseCount++;

            result.append(checkNumber + " " + category + " " + String.format("%.2f", amount) + " Balance " + String.format("%.2f", balance) + "\\r\\n");
        }

        double averageExpense = totalExpense / expenseCount;
        result.append("Total expense  " + String.format("%.2f", totalExpense) + "\\r\\n");
        result.append("Average expense  " + String.format("%.2f", averageExpense));

        String finalResult = result.toString().replaceAll("\n", "\r\n");

        return finalResult;
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
