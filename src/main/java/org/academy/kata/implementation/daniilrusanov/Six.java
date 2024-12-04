package org.academy.kata.implementation.daniilrusanov;

import org.academy.kata.ISix;

public class Six implements ISix {
    @Override
    public long findNb(long m) {
        return 0;
    }

    @Override
    public String balance(String book) {
        String clearStr = book.replaceAll("[^a-zA-Z0-9.\\s\n]", "");
        String[] trimStr = clearStr.split("\\n+");
        trimStr[0] = "Original Balance: " + trimStr[0];

        double total = 0;
        double average;
        double balance = Double.parseDouble(trimStr[0].split(":")[1].trim());

        for(int i = 1; i < trimStr.length; i++) {
            String[] temp = trimStr[i].split("\\s+");
            double expense = Double.parseDouble(temp[2]);
            total += expense;
            balance -= expense;
            trimStr[i] = temp[0] + " " + temp[1] + " " + temp[2] + " Balance " + String.format("%.2f", balance);
        }

        average = total / (trimStr.length - 1);
        StringBuilder res = new StringBuilder();
        for(String line : trimStr) {
            res.append(line).append("\\r\\n");
        }
        res.append("Total expense  ").append(String.format("%.2f", total)).append("\\r\\n");
        res.append("Average expense  ").append(String.format("%.2f", average));

        return res.toString();
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
