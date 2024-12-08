package org.academy.kata.implementation.ivanromanuik2014;

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
        return x / (Math.sqrt(1 + x) + 1);
    }

    @Override
    public double mean(String town, String strng) {
        // Розбиваємо вхідний рядок на окремі міста
        String[] townsData = strng.split("\n");

        // Перебираємо кожне місто
        for (String townData : townsData) {
            // Розділяємо на назву міста та дані про опади
            String[] parts = townData.split(":");
            String name = parts[0].trim();
            String[] rainfallData = parts[1].trim().split(",");

            // Якщо знайдено потрібне місто, обчислюємо середнє
            if (name.equals(town)) {
                double sum = 0;
                for (String rainfall : rainfallData) {
                    // Отримуємо значення опадів, розділяючи за пробілом
                    String[] monthData = rainfall.split(" ");
                    sum += Double.parseDouble(monthData[1]);
                }
                return sum / rainfallData.length;
            }
        }
        // Якщо місто не знайдено, повертаємо -1
        return -1.0;
    }

    @Override
    public double variance(String town, String strng) {
        String[] townsData = strng.split("\n");

        for (String townData : townsData) {
            String[] parts = townData.split(":");
            String name = parts[0].trim();
            String[] rainfallData = parts[1].trim().split(",");

            if (name.equals(town)) {
                double sum = 0;
                for (String rainfall : rainfallData) {
                    String[] monthData = rainfall.split(" ");
                    sum += Double.parseDouble(monthData[1]);
                }
                double mean = sum / rainfallData.length;

                double variance = 0;
                for (String rainfall : rainfallData) {
                    String[] monthData = rainfall.split(" ");
                    variance += Math.pow(Double.parseDouble(monthData[1]) - mean, 2);
                }
                // Для вибіркової дисперсії ділимо на (n-1)
                return variance / (rainfallData.length);
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
