package org.academy.kata.implementation.TanyaB777;

import org.academy.kata.ISix;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Six implements ISix {
    @Override
    public long findNb(long m) {
        long n = 0;
        long volume = 0;

        while (volume < m) {
            n++;
            volume += (long) Math.pow(n, 3);
        }

        return volume == m ? n : -1;
    }

    @Override
    public String balance(String book) {
        String cleanedBook = book.replaceAll("[^a-zA-Z0-9.\\n ]", "");
        String[] originLines = cleanedBook.split("\\r?\\n");

        double originalBalance = Double.parseDouble(originLines[0]);

        double currentBalance = originalBalance;
        double totalExpense = 0.0;
        int expenseCount = 0;

        List<String> reportLines = new ArrayList<>();

        DecimalFormat df = new DecimalFormat("0.00");
        reportLines.add("Original Balance: " + df.format(originalBalance));

        for (int i = 1; i < originLines.length; i++) {
            String line = originLines[i].trim();

            if (line.isEmpty()) {
                continue;
            }

            String[] parts = line.split("\\s+");

            String number = parts[0];
            String category = parts[1];
            double amount = Double.parseDouble(parts[2]);

            currentBalance -= amount;
            totalExpense += amount;
            expenseCount++;

            reportLines.add(number + " " + category + " " + df.format(amount) + " Balance " + df.format(currentBalance));
        }

        double averageExpense = totalExpense / expenseCount;

        reportLines.add("Total expense  " + df.format(totalExpense));
        reportLines.add("Average expense  " + df.format(averageExpense));

        return String.join("\\r\\n", reportLines);
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
