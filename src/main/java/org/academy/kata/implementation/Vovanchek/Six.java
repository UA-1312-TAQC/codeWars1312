package org.academy.kata.implementation.Vovanchek;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        Pattern pattern = Pattern.compile(town + ":([A-Za-z]{3}\\s\\d+\\.\\d+(?:,[A-Za-z]{3}\\s\\d+\\.\\d+)*)");
        Matcher matcher = pattern.matcher(strng);
        double sum = 0.0;
        double i = 0.0;

        if (matcher.find()) {
            String nyData = matcher.group(1);

            String[] records = nyData.split(",");

            for (String record : records) {
                String[] parts = record.trim().split(" ");
                double value = Double.parseDouble(parts[1]); 
                sum += value; 
                i++;
            }
        } else {
          return -1.0;
        }

        return sum / i;
    }

    @Override
    public double variance(String town, String strng) {
        Pattern pattern = Pattern.compile(town + ":([A-Za-z]{3}\\s\\d+\\.\\d+(?:,[A-Za-z]{3}\\s\\d+\\.\\d+)*)");
        Matcher matcher = pattern.matcher(strng);
        double sum = 0;
        int i = 0;

        if (matcher.find()) {
            
            String nyData = matcher.group(1);

            String[] records = nyData.split(",");

            for (String record : records) {
                String[] parts = record.trim().split(" ");
                double value = Double.parseDouble(parts[1]);
                sum += value;
                i++;
            }
        }

        double avg = sum / i;
        System.out.println(avg);
        double disp = 0.0;
        Pattern pattern1 = Pattern.compile(town + ":([A-Za-z]{3}\\s\\d+\\.\\d+(?:,[A-Za-z]{3}\\s\\d+\\.\\d+)*)");
        Matcher matcher1 = pattern1.matcher(strng);
        if (matcher1.find()) {
        
            String nyData = matcher1.group(1);


            String[] records = nyData.split(",");

            for (String record : records) {
          
                String[] parts = record.trim().split(" ");
                double value = Double.parseDouble(parts[1]);
                disp += Math.pow(value - avg, 2);


            }
        } else {
          return -1.0;
        }
        return disp / i;
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
