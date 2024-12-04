package org.academy.kata.implementation.AnastasiiaSun;

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
