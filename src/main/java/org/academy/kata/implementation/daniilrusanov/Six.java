package org.academy.kata.implementation.daniilrusanov;

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

    public double mean(String town, String strng) {
        String[] cities = strng.split("\n");
        for (String city : cities) {
            if (city.startsWith(town + ":")) {
                String[] records = city.substring(town.length() + 1).split(",");
                double rainfallSum = 0.0;
                for (String record : records) {
                    rainfallSum += Double.parseDouble(record.split(" ")[1]);
                }
                return rainfallSum / records.length;
            }
        }

        return -1;
    }

    @Override
    public double variance(String town, String strng) {
        double avg = mean(town, strng);

        String[] cities = strng.split("\n");
        for (String city : cities) {
            if (city.startsWith(town + ":")) {
                String[] records = city.substring(town.length() + 1).split(",");
                double rainfallSum = 0.0;
                for (String record : records) {
                    double monthRainfall = Double.parseDouble(record.split(" ")[1]);
                    rainfallSum += (monthRainfall - avg) * (monthRainfall - avg);
                }
                return rainfallSum / records.length;
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
