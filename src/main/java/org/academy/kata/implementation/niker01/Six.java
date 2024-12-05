package org.academy.kata.implementation.niker01;

import org.academy.kata.ISix;

public class Six implements ISix {
    @Override
    public long findNb(long m) {
        return 0;
    }

    @Override
    public String balance(String book) {
        String cleanBook = book.replaceAll("[^a-zA-Z0-9.\\s]", "");
        String[] lines = cleanBook.split("\\n");
        double originalBalance = Double.parseDouble(lines[0].trim());
        double balance = originalBalance;
        double totalExpense = 0;
        int transactionCount = 0;
        StringBuilder report = new StringBuilder();
        report.append(String.format("Original Balance: %.2f\\r\\n", originalBalance));
        for (int i = 1; i < lines.length; i++) {
            if (!lines[i].trim().isEmpty()) {
                String[] parts = lines[i].trim().split("\\s+");
                String checkNo = parts[0];
                String category = parts[1];
                double amount = Double.parseDouble(parts[2]);
                balance -= amount;
                totalExpense += amount;
                transactionCount++;
                report.append(String.format("%s %s %.2f Balance %.2f\\r\\n", checkNo, category, amount, balance));
            }
        }

        double averageExpense = transactionCount > 0 ? totalExpense / transactionCount : 0;
        report.append(String.format("Total expense  %.2f\\r\\n", totalExpense));
        report.append(String.format("Average expense  %.2f", averageExpense));

        return report.toString();
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
