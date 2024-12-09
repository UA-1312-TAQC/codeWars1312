package org.academy.kata.implementation.ivanromanuik2014;

import org.academy.kata.ISix;

public class Six implements ISix {
    @Override
    public long findNb(long m) {
        long n = 0;
        long totalValue = 0;

        while (totalValue < m) {
            n++;
            totalValue += n * n * n;
            if (totalValue == m) {
                return n;
            }
        }
        return -1;
    }

    @Override
    public String balance(String book) {
        String cleanedBook = book.replaceAll("[^a-zA-Z0-9.\\n ]", "");
        String[] lines = cleanedBook.split("\\n");

        double originalBalance = Double.parseDouble(lines[0]);
        double balance = originalBalance;
        double totalExpense = 0.0;
        int countExpenses = 0;

        String lineSeparator = System.lineSeparator();
        StringBuilder report = new StringBuilder();
        report.append(String.format("Original Balance: %.2f\\r\\n", originalBalance));

        for (int i = 1; i < lines.length; i++) {
            String line = lines[i].trim();
            if (!line.isEmpty()) {
                String[] parts = line.split(" ");
                if (parts.length < 3)
                    continue; // Пропустити некоректний рядок

                String checkNumber = parts[0];
                String category = parts[1];
                double amount = Double.parseDouble(parts[2]);

                balance -= amount;
                totalExpense += amount;
                countExpenses++;

                report.append(String.format("%s %s %.2f Balance %.2f\\r\\n", checkNumber, category, amount, balance));
            }
        }

        report.append(String.format("Total expense  %.2f\\r\\n", totalExpense));
        if (countExpenses > 0) {
            report.append(String.format("Average expense  %.2f", totalExpense / countExpenses));
        } else {
            report.append("Average expense  0.00" + lineSeparator);
        }

        return report.toString().trim();
    }

    @Override
    public double f(double x) {
        return x / (Math.sqrt(1 + x) + 1);
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
