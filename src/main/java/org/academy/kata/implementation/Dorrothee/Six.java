package org.academy.kata.implementation.Dorrothee;

import org.academy.kata.ISix;

public class Six implements ISix {
    @Override
    public long findNb(long m) {
        return 0;
    }

    @Override
    public String balance(String book) {
        return "";
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
        String[] towns = strng.split("\n");

        for (String townData : towns) {
            String[] parts = townData.split(":");
            String townName = parts[0].trim();
            if (townName.equals(town)) {

                String[] rainfalls = parts[1].trim().split(",");
                double sum = 0;
                double sumOfSquares = 0;

                for (String rainfall : rainfalls) {

                    String[] split = rainfall.trim().split(" ");
                    double value = Double.parseDouble(split[1].trim());
                    sum += value;
                    sumOfSquares += value * value;
                }

                double mean = sum / rainfalls.length;
                //Variance = Sum of Squared Differences / Number of Observations
                return (sumOfSquares / rainfalls.length) - (mean * mean);
            }
        }

        return -1;
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
