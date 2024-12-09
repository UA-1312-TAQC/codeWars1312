package org.academy.kata.implementation.NastiaDamian;

import org.academy.kata.ISix;

import java.util.ArrayList;
import java.util.List;

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
        return x / (1 + Math.sqrt(1 + x));
    }

    @Override
    public double mean(String town, String strng) {
        List<Double> rainfallData = extractRainfallData(town, strng);
        if (rainfallData.isEmpty()) return -1.0;

        double sum = 0;
        for (double value : rainfallData) {
            sum += value;
        }

        return sum / rainfallData.size();
    }

    @Override
    public double variance(String town, String strng) {
        List<Double> rainfallData = extractRainfallData(town, strng);
        if (rainfallData.isEmpty()) return -1.0;

        double mean = 0;
        double sum = 0;
        for (double value : rainfallData) {
            sum += value;
        }
        mean = sum / rainfallData.size();

        double varianceSum = 0;
        for (double value : rainfallData) {
            varianceSum += Math.pow(value - mean, 2);
        }

        return varianceSum / rainfallData.size();
    }

    private static List<Double> extractRainfallData(String town, String strng) {
        for (String record : strng.split("\n")) {
            String[] parts = record.split(":");
            if (parts[0].equals(town)) {
                String[] monthlyData = parts[1].split(",");
                List<Double> rainfallData = new ArrayList<>();
                for (String entry : monthlyData) {
                    rainfallData.add(Double.parseDouble(entry.split(" ")[1]));
                }
                return rainfallData;
            }
        }
        return new ArrayList<>();
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

        java.util.Map<String, Integer> categoryCount = new java.util.HashMap<>();

        for (String category : lstOf1stLetter) {
            categoryCount.put(category, 0);
        }

        for (String book : lstOfArt) {
            String[] parts = book.split(" ");
            String code = parts[0];
            int quantity = Integer.parseInt(parts[1]);
            String category = code.substring(0, 1);

            if (categoryCount.containsKey(category)) {
                categoryCount.put(category, categoryCount.get(category) + quantity);
            }
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < lstOf1stLetter.length; i++) {
            String category = lstOf1stLetter[i];
            int count = categoryCount.get(category);
            result.append("(").append(category).append(" : ").append(count).append(")");
            if (i < lstOf1stLetter.length - 1) {
                result.append(" - ");
            }
        }

        return result.toString();
    }
}
