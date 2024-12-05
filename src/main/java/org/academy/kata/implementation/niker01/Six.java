package org.academy.kata.implementation.niker01;

import org.academy.kata.ISix;

import static java.util.stream.Stream.of;

import java.util.stream.DoubleStream;

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
        String[] lines = strng.split("\n");
        for (String line : lines) {
            if (line.startsWith(town + ":")) {
                String rainfallData = line.substring(town.length() + 1);
                String[] rainfallArray = rainfallData.split(",\\s*"); 
                double sum = 0;
                int count = 0;
                System.out.println("Rainfall data for " + town + ": " + Arrays.toString(rainfallArray));
                for (String value : rainfallArray) {
                    try {
                        String[] parts = value.split(" ");  
                        double rainfall = Double.parseDouble(parts[1]);
                        sum += rainfall;
                        count++;
                    } catch (NumberFormatException e) {
                    }
                }
                System.out.println("Sum: " + sum + ", Count: " + count);
                if (count > 0) {
                    return sum / count; 
                }
            }
        }
        return -1.0;
    }

    @Override
    public double variance(String town, String strng) {
          String[] lines = strng.split("\n");
        for (String line : lines) {
            if (line.startsWith(town + ":")) {
                String rainfallData = line.substring(town.length() + 1);
                String[] rainfallArray = rainfallData.split(",\\s*"); 
                double sum = 0;
                int count = 0;
                System.out.println("Rainfall data for " + town + ": " + Arrays.toString(rainfallArray));
                for (String value : rainfallArray) {
                    try {
                        String[] parts = value.split(" ");  
                        double rainfall = Double.parseDouble(parts[1]); 
                        sum += rainfall;
                        count++;
                    } catch (NumberFormatException e) {
                    }
                }       
                double meanValue = sum / count;
                System.out.println("Mean value for " + town + ": " + meanValue);
                double varianceSum = 0;
                for (String value : rainfallArray) {
                    try {
                        String[] parts = value.split(" ");
                        double rainfall = Double.parseDouble(parts[1]);
                        varianceSum += Math.pow(rainfall - meanValue, 2);
                    } catch (NumberFormatException e) {
                    }
                }
                System.out.println("Variance sum: " + varianceSum);
                if (count > 0) {
                    return varianceSum / count;  
                }
            }
        }
        return -1.0;
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
