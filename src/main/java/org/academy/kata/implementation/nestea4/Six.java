package org.academy.kata.implementation.nestea4;

import org.academy.kata.ISix;

public class Six implements ISix {
    @Override
    public long findNb(long m) {
        long n = 1;
        long volume = 0;

        while (volume < m){
            volume += n*n*n;
            if (volume==m){
                return n;
            }
            n++;
        }
        return -1;
    }

    @Override
    public String balance(String book) {
        String[] lines=book.replaceAll("[^a-zA-Z0-9.\\n ]", "").trim().split("\n");
        double originalBalance =Double.parseDouble(lines[0]);
        double curBalance = originalBalance;
        double totalExpense = 0;
        int transactionCount = 0;

        StringBuilder result = new StringBuilder();
        result.append(String.format("Original Balance: %.2f\\r\\n", originalBalance));

        for (int i= 1; i<lines.length; i++) {
            String line = lines[i].trim();
            if (line.isEmpty()) continue;

            String[] parts=line.split("\\s+");
            if (parts.length<3) continue;
            double amount=Double.parseDouble(parts[parts.length-1]);
            curBalance -= amount;
            totalExpense += amount;
            transactionCount++;

            result.append(String.format("%s %s %.2f Balance %.2f\\r\\n",parts[0], parts[1], amount, curBalance));
        }

        double averageExpense = totalExpense/transactionCount;
        result.append(String.format("Total expense  %.2f\\r\\n", totalExpense));
        result.append(String.format("Average expense  %.2f", averageExpense));
        return result.toString();
    }

    @Override
    public double f(double x) {
        return x / (Math.sqrt(1+x)+1);
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
