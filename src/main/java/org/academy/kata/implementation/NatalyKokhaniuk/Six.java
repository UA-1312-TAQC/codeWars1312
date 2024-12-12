package org.academy.kata.implementation.NatalyKokhaniuk;

import org.academy.kata.ISix;
import java.util.HashMap;
import java.util.Map;

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
    private static Map<String, double[]> parseData(String strng) {
        Map<String, double[]> rainfallData = new HashMap<>();
        String[] lines = strng.split("\\n");
        for (String line : lines) {
            String[] parts = line.split(":");
            if (parts.length < 2) continue;
            String town = parts[0];
            String[] monthlyData = parts[1].split(",");
            double[] rainfalls = new double[monthlyData.length];
            for (int i = 0; i < monthlyData.length; i++) {
                String[] monthAndValue = monthlyData[i].trim().split(" ");
                rainfalls[i] = Double.parseDouble(monthAndValue[1]);
            }
            rainfallData.put(town, rainfalls);
        }
        return rainfallData;
    }
    private static double Mean(String town, String strng) {
        Map<String, double[]> rainfallData = parseData(strng);
        if (!rainfallData.containsKey(town)) {
            return -1.0;
        }
        double[] rainfalls = rainfallData.get(town);
        double sum = 0.0;
        for (double rainfall : rainfalls) {
            sum += rainfall;
        }
        return sum / rainfalls.length;
    }
        private static String Format(double x) {
        String f=""+x;
        String []parts=f.split("\\.");
        if(parts.length<2) return f;
        else {
            String res;
            if(parts[1].length()>5) res=parts[0]+"."+parts[1].substring(0, 2)+"("+parts[1].substring(2)+")";
            else  res=f;

            return res;
        }
    }
    @Override
    public double mean(String town, String strng) {
        double sum = Mean(town, strng);
        System.out.println("mean(\""+town+"\", data), "+Format(sum));
        return sum;
    }

    @Override
    public double variance(String town, String strng) {
       Map<String, double[]> rainfallData = parseData(strng);
        if (!rainfallData.containsKey(town)) {
            return -1.0;
        }
        double[] rainfalls = rainfallData.get(town);
        double mean = Mean(town, strng);
        double sumSquaredDiff = 0.0;
        for (double rainfall : rainfalls) {
            sumSquaredDiff += Math.pow(rainfall - mean, 2);
        }

        System.out.println("variance(\""+town+"\", data), "+Format(sumSquaredDiff / rainfalls.length));
        return sumSquaredDiff / rainfalls.length;
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
