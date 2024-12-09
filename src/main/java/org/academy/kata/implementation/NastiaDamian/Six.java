package org.academy.kata.implementation.NastiaDamian;

import org.academy.kata.ISix;

public class Six implements ISix {
    @Override
    public long findNb(long m) {
        long totalVolume = 0;
        long n = 0;
        while (totalVolume < m) {
            n++;
            totalVolume += n * n * n;
            if (totalVolume == m) {
                return n;
            }
        }
        return -1;
    }

    @Override
    public String balance(String book) {
        String cleanedData = book.replaceAll("([^\\n. \\da-zA-Z])", "");
        String[] lines = cleanedData.split("[\\n]+");
        double startingBalance = Double.parseDouble(lines[0]);
        double totalExpenses = 0;
        int numberOfChecks = 0;
        StringBuilder report = new StringBuilder();
        report.append("Original Balance: " + lines[0]);
        for (int i = 1; i < lines.length; i++) {
            String[] transactionDetails = lines[i].split("[ ]+");
            double expense = Double.parseDouble(transactionDetails[2]);
            startingBalance -= expense;
            totalExpenses += expense;
            numberOfChecks++;
            String transactionReport = String.format("\\r\\n%s %s %s Balance %.2f",
                    transactionDetails[0],
                    transactionDetails[1],
                    transactionDetails[2],
                    startingBalance);
            report.append(transactionReport);
        }
        report.append(String.format("\\r\\nTotal expense  %.2f\\r\\nAverage expense  %.2f",
                totalExpenses,
                totalExpenses / numberOfChecks));
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
