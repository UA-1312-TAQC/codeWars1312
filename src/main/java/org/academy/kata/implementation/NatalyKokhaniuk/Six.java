package org.academy.kata.implementation.NatalyKokhaniuk;

import org.academy.kata.ISix;
import java.util.HashMap;
import java.util.Map;

import java.util.regex.*;
import java.util.*;

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
      if (toFind == null || toFind.isEmpty()) {
            return "";
        }
        String res;
        if (resultSheet.contains(".")) {
            Pattern floatPattern = Pattern.compile("([^,]+\\d+\\.\\d+[^,]*)");
            Matcher matcher = floatPattern.matcher(resultSheet);
            if (matcher.find()) {
                res="Error(float number):" + matcher.group(1).trim();
                System.out.println("nba_cup(r, \""+toFind+"\") -> \""+res+"\"");
                return res;
            }
        }

        String[] matches = resultSheet.split(",");
        int wins = 0, draws = 0, losses = 0, scored = 0, conceded = 0;

        boolean teamPlayed = false;

        for (String match : matches) {
            Pattern matchPattern = Pattern.compile("([a-zA-Z0-9\\s]+)\\s(\\d+)\\s([a-zA-Z0-9\\s]+)\\s(\\d+)");
            Matcher matcher = matchPattern.matcher(match.trim());

            if (matcher.find()) {
                String team1 = matcher.group(1).trim();
                int score1 = Integer.parseInt(matcher.group(2));
                String team2 = matcher.group(3).trim();
                int score2 = Integer.parseInt(matcher.group(4));

                if (team1.equals(toFind) || team2.equals(toFind)) {
                    teamPlayed = true;

                    if (team1.equals(toFind)) {
                        scored += score1;
                        conceded += score2;

                        if (score1 > score2) wins++;
                        else if (score1 == score2) draws++;
                        else losses++;
                    } else {
                        scored += score2;
                        conceded += score1;

                        if (score2 > score1) wins++;
                        else if (score2 == score1) draws++;
                        else losses++;
                    }
                }
            }
        }

        if (!teamPlayed) {
            res=toFind + ":This team didn't play!";
            System.out.println("nba_cup(r, \""+toFind+"\") -> \""+res+"\"");
            return res;
        }

        int points = wins * 3 + draws;
        res= String.format("%s:W=%d;D=%d;L=%d;Scored=%d;Conceded=%d;Points=%d",
                toFind, wins, draws, losses, scored, conceded, points);
        System.out.println("nba_cup(r, \""+toFind+"\") -> \""+res+"\"");
        return res;
    }

    @Override
    public String stockSummary(String[] lstOfArt, String[] lstOf1stLetter) {
    if (lstOfArt == null || lstOfArt.length == 0 || lstOf1stLetter == null || lstOf1stLetter.length == 0) {
            return "";
        }

        int[] categoryCounts = new int[lstOf1stLetter.length];

        for (String book : lstOfArt) {
            String[] parts = book.split(" ");
            if (parts.length != 2) continue;

            String category = parts[0].substring(0, 1);
            int quantity = Integer.parseInt(parts[1]);

            for (int i = 0; i < lstOf1stLetter.length; i++) {
                if (lstOf1stLetter[i].equals(category)) {
                    categoryCounts[i] += quantity;
                    break;
                }
            }
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < lstOf1stLetter.length; i++) {
            if (i > 0) result.append(" - ");
            result.append("(").append(lstOf1stLetter[i]).append(" : ").append(categoryCounts[i]).append(")");
        }

        return result.toString();
    }
}
