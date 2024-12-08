package org.academy.kata.implementation.kiyanovskaa;

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
        double sum = 0.0;
        int count = 0;

        for (String record : records) {
            String[] parts = record.split(":");
            if (parts[0].equals(town)) {
                String[] monthlyData = parts[1].split(",");
                for (String data : monthlyData) {
                    sum += Double.parseDouble(data.split(" ")[1]);
                    count++;
                }
                return sum / count;
            }
        }
        return -1.0;
    }

    @Override
    public double variance(String town, String strng) {
        String[] records = strng.split("\n");
        double sum = 0.0;
        int count = 0;
        double[] rainfall = null;

        for (String record : records) {
            String[] parts = record.split(":");
            if (parts[0].equals(town)) {
                String[] monthlyData = parts[1].split(",");
                rainfall = new double[monthlyData.length];
                for (int i = 0; i < monthlyData.length; i++) {
                    rainfall[i] = Double.parseDouble(monthlyData[i].split(" ")[1]);
                    sum += rainfall[i];
                }
                count = rainfall.length;
                break;
            }
        }

        double mean = sum / count;
        double sumOfSquares = 0.0;
        for (double value : rainfall) {
            sumOfSquares += Math.pow(value - mean, 2);
        }
        return sumOfSquares / count;
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
