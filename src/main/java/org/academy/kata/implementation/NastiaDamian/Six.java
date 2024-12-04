package org.academy.kata.implementation.NastiaDamian;

import org.academy.kata.ISix;

import java.util.ArrayList;
import java.util.List;

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
        return "";
    }
}
