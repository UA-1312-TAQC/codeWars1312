package org.academy.kata.implementation.AnastasiiaSun;

import org.academy.kata.ISix;

import java.util.Locale;

public class Six implements ISix {
    @Override
    public long findNb(long m) {
        long sum = 0;
        int n = 0;
        while (sum < m) {
            n++;
            sum += (long) Math.pow(n, 3);
        }
        if (sum == m) {
            return n;
        }
        return -1;
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
        if (x < 1e-4) {
            return x / (Math.sqrt(1 + x) + 1);
        }
        return Math.sqrt(1 + x) - 1;
    }

    @Override
    public double mean(String town, String strng) {
        String[] records = strng.split("\n");
        String townData = null;

        for (String record : records) {
            if (record.startsWith(town)) {
                String[] parts = record.split(":");
                townData = parts[1];
                break;
            }
        }
        if (townData == null) {
            return -1;
        }
        String[] rainfallData = townData.split(",");

        double sumRainfall = 0;
        double countRainfall = 0;

        for (String rainfallDatum : rainfallData) {
            String[] monthData = rainfallDatum.split(" ");
            sumRainfall += Double.parseDouble(monthData[1]);
            countRainfall++;
        }
        return sumRainfall / countRainfall;
    }

    @Override
    public double variance(String town, String strng) {
        double meanRainfall = mean(town, strng);
        if (meanRainfall == -1) {
            return -1;
        }
        String[] records = strng.split("\n");
        String townData = null;

        for (String record : records) {
            if (record.startsWith(town)) {
                String[] parts = record.split(":");
                townData = parts[1];
                break;
            }
        }
        if (townData == null) {
            return -1;
        }
        String[] rainfallData = townData.split(",");

        double varianceSum = 0;
        double countRainfall = 0;

        for (String rainfallDatum : rainfallData) {
            String[] monthData = rainfallDatum.split(" ");
            varianceSum += Math.pow((Double.parseDouble(monthData[1]) - meanRainfall), 2);
            countRainfall++;
        }
        return varianceSum / countRainfall;
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
