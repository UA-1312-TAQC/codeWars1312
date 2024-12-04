package org.academy.kata.implementation.TanyaB777;

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
        double[] rainfallData = getDataForTown(town, strng);

        if (rainfallData == null) {
            return -1.0;
        }

        double sum = 0;
        for (double value : rainfallData) {
            sum += value;
        }

        return sum / rainfallData.length;
    }

    @Override
    public double variance(String town, String strng) {
        double[] rainfallData = getDataForTown(town, strng);

        if (rainfallData == null) {
            return -1.0;
        }

        double mean = 0;
        for (double value : rainfallData) {
            mean += value;
        }
        mean /= rainfallData.length;

        double sumOfSquares = 0;
        for (double value : rainfallData) {
            sumOfSquares += Math.pow(value - mean, 2);
        }

        return sumOfSquares / rainfallData.length;
    }

    private static double[] getDataForTown(String town, String strng) {
        if (strng == null || town == null || town.isEmpty()) {
            return null;
        }

        String[] records = strng.split("\\n");
        for (String record : records) {
            String[] parts = record.split(":");
            if (parts.length < 2) continue;

            if (parts[0].trim().equals(town)) {
                String[] monthlyData = parts[1].split(",");
                double[] rainfallValues = new double[monthlyData.length];

                try {
                    for (int i = 0; i < monthlyData.length; i++) {
                        rainfallValues[i] = Double.parseDouble(monthlyData[i].split(" ")[1]);
                    }
                } catch (NumberFormatException ex) {
                    return null;
                }
                return rainfallValues;
            }
        }
        return null;
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
