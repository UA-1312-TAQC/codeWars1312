package org.academy.kata.implementation.Dorrothee;

import org.academy.kata.ISix;




import java.util.Arrays;

public class Six implements ISix {
    @Override
    public long findNb(long m) {
        return 0;
    }

    @Override
    public String balance(String book) {
        //Clean the input by removing non-alphanumeric characters except spaces and dots
        book = book.replaceAll("[^\\w\\s.]", "");

        //Process the book and generate the report
        String[] lines = book.split("\n");
        double balance = Double.parseDouble(lines[0].trim()); //Original balance

        StringBuilder report = new StringBuilder();
        report.append("Original Balance: ").append(String.format("%.2f", balance));  //First line

        double totalExpense = 0.0;
        int expenseCount = 0;

        //Process each transaction line
        for (int i = 1; i < lines.length; i++) {
            String line = lines[i].trim();
            if (line.isEmpty()) continue;  //Skip blank lines

            //Extract check number, category, and check amount
            String[] parts = line.split("\\s+");
            double checkAmount = Double.parseDouble(parts[parts.length - 1]); //The last part is the amount

            String category = String.join(" ", Arrays.copyOfRange(parts, 1, parts.length - 1));  //Join the middle parts as category
            balance -= checkAmount;  //Deduct the check amount from the balance
            totalExpense += checkAmount;
            expenseCount++;

            //Append the transaction line to the report with '\\r\\n' for all lines except the last one
            report.append("\\r\\n").append(parts[0]).append(" ").append(category).append(" ").append(String.format("%.2f", checkAmount)).append(" Balance ").append(String.format("%.2f", balance));
        }

        //Append total expense and average expense with '\\r\\n' for the last lines
        report.append("\\r\\nTotal expense  ").append(String.format("%.2f", totalExpense));
        report.append("\\r\\nAverage expense  ").append(String.format("%.2f", totalExpense / expenseCount));

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
