package org.academy.kata.implementation.Vovanchek;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.academy.kata.ISix;

public class Six implements ISix {
    @Override
    public long findNb(long m) {
        long totalVolume = 0;
        long n = 0;
        while (totalVolume < m) {
            n++;
            totalVolume += n * n * n;
        }
        return totalVolume == m ? n : -1;
    }

    @Override
    public String balance(String book) {
        String cleanedText = book.replaceAll("[^\\w\\s\\.]", ""); 
        String[] lines = cleanedText.split("\\n");

        double balance = Double.parseDouble(lines[0].trim());
        double originalBalance = balance;
        
        StringBuilder result = new StringBuilder();
        result.append(String.format("Original Balance: %.2f\\r\\n", originalBalance));

        ArrayList<Double> expenses = new ArrayList<>();
        double totalExpense = 0.0;

        for (int i = 1; i < lines.length; i++) {
            String line = lines[i].trim();

            Pattern pattern = Pattern.compile("([0-9]{3})\\s+([A-Za-z\\s]+)\\s+(\\d+\\.\\d+)");
            Matcher matcher = pattern.matcher(line);

            if (matcher.find()) {
                String id = matcher.group(1);
                String item = matcher.group(2).trim();
                double expense = Double.parseDouble(matcher.group(3));

                balance -= expense;
                expenses.add(expense);

                result.append(String.format("%s %s %.2f Balance %.2f\\r\\n", id, item, expense, balance));
            }
        }

        totalExpense = expenses.stream().mapToDouble(Double::doubleValue).sum();
        double averageExpense = expenses.isEmpty() ? 0.0 : totalExpense / expenses.size();

        result.append(String.format("Total expense  %.2f\\r\\n", totalExpense));
        result.append(String.format("Average expense  %.2f", averageExpense));

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
