package org.academy.kata.implementation.BasilJaworski;

import java.util.Arrays;
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
        byte row_num = row_get_bymonth(strng, town);
        if (row_num == -1) return -1.0;

        String row = row_get(strng, row_num);
        double[] rainfalls = rainfall_get(row);
        double total = 0.00;

        for (double rainfall : rainfalls) total += rainfall;
        return total / 12;
    }

    @Override
    public double variance(String town, String strng) {
        byte row_num = row_get_bymonth(strng, town);
        if (row_num == -1) return -1.0;

        String row = row_get(strng, row_num);
        double[] rainfalls = rainfall_get(row);
        double mean = mean(town, strng);
        double variance = 0.00;

        for (double rainfall : rainfalls) {
            variance += (rainfall - mean) * (rainfall - mean);
        }
        return variance / 12;
    }

    public static String row_get(String str, int idx){
        String[] rows = str.split("\n");
        if (idx < 0 || idx >= rows.length) return "";
        return rows[idx];
    }

    public static double[] rainfall_get(String str){
        String[] parts = str.split(":");
        if (parts.length < 2) return new double[0];

        String[] rainData = parts[1].split(",");
        double[] rainfalls = new double[rainData.length];
        for (int i = 0; i < rainData.length; i++) {
            rainfalls[i] = Double.parseDouble(rainData[i].replaceAll("[^0-9.]", ""));
        }
        return rainfalls;
    }

    public static byte row_get_bymonth(String str, String town){
        String[] rows = str.split("\n");
        for (byte i = 0; i < rows.length; i++) {
            if (rows[i].startsWith(town + ":")) {
                return i;
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
