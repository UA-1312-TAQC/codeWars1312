package org.academy.kata.implementation.TanyaB777;

import org.academy.kata.ISix;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;


public class Six implements ISix {
    @Override
    public long findNb(long m) {
        long n = 0;
        long volume = 0;

        while (volume < m) {
            n++;
            volume += (long) Math.pow(n, 3);
        }

        return volume == m ? n : -1;
    }

    @Override
    public String balance(String book) {
        String cleanedBook = book.replaceAll("[^a-zA-Z0-9.\\n ]", "");
        String[] originLines = cleanedBook.split("\\r?\\n");

        double originalBalance = Double.parseDouble(originLines[0]);

        double currentBalance = originalBalance;
        double totalExpense = 0.0;
        int expenseCount = 0;

        List<String> reportLines = new ArrayList<>();

        DecimalFormat df = new DecimalFormat("0.00");
        reportLines.add("Original Balance: " + df.format(originalBalance));

        for (int i = 1; i < originLines.length; i++) {
            String line = originLines[i].trim();

            if (line.isEmpty()) {
                continue;
            }

            String[] parts = line.split("\\s+");

            String number = parts[0];
            String category = parts[1];
            double amount = Double.parseDouble(parts[2]);

            currentBalance -= amount;
            totalExpense += amount;
            expenseCount++;

            reportLines.add(number + " " + category + " " + df.format(amount) + " Balance " + df.format(currentBalance));
        }

        double averageExpense = totalExpense / expenseCount;

        reportLines.add("Total expense  " + df.format(totalExpense));
        reportLines.add("Average expense  " + df.format(averageExpense));

        return String.join("\\r\\n", reportLines);
    }

    @Override
    public double f(double x) {
        return x / (Math.sqrt(1 + x) + 1);
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

    private double[] getDataForTown(String town, String strng) {
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
        String[] matches = resultSheet.split(",");
        Map<String, int[]> teamStats = new HashMap<>();

        for (String match : matches) {

            Pattern pattern = Pattern.compile("\\.");
            Matcher matcher = pattern.matcher(match);

            if (matcher.find()) {
                return "Error(float number):" + match;
            }

            String[] words = match.split(" ");
            StringBuilder team1 = new StringBuilder();
            StringBuilder team2 = new StringBuilder();
            int score1 = 0;
            int score2 = 0;
            boolean foundScore1 = false;

            for (String word : words) {
                try {
                    int score = Integer.parseInt(word);
                    if (!foundScore1) {
                        score1 = score;
                        foundScore1 = true;
                    } else {
                        score2 = score;
                    }
                } catch (NumberFormatException e) {
                    if (!foundScore1) {
                        if (!team1.isEmpty()) team1.append(" ");
                        team1.append(word);
                    } else {
                        if (!team2.isEmpty()) team2.append(" ");
                        team2.append(word);
                    }
                }
            }

            updateStats(teamStats, team1.toString().trim(), score1, score2);
            updateStats(teamStats, team2.toString().trim(), score2, score1);
        }

        if (toFind.isEmpty()) {
            return "";
        }

        if (!teamStats.containsKey(toFind)) {
            return toFind + ":This team didn't play!";
        }

        int[] stats = teamStats.get(toFind);
        int wins = stats[0], draws = stats[1], losses = stats[2];
        int scored = stats[3], conceded = stats[4];
        int points = wins * 3 + draws;

        return String.format("%s:W=%d;D=%d;L=%d;Scored=%d;Conceded=%d;Points=%d",
                toFind, wins, draws, losses, scored, conceded, points);
    }

    private void updateStats(Map<String, int[]> teamStats, String teamName, int scored, int conceded) {
        if (!teamStats.containsKey(teamName)) {
            teamStats.put(teamName, new int[5]);
        }

        int[] stats = teamStats.get(teamName);

        if (scored > conceded) {
            stats[0]++;
        } else if (scored == conceded) {
            stats[1]++;
        } else {
            stats[2]++;
        }

        stats[3] += scored;
        stats[4] += conceded;
    }

    @Override
    public String stockSummary(String[] lstOfArt, String[] lstOf1stLetter) {
        if (lstOfArt == null || lstOf1stLetter == null || lstOfArt.length == 0 || lstOf1stLetter.length == 0){
            return "";
        }

        Map<String, Integer> categoryCounts = new HashMap<>();

        for (String category : lstOf1stLetter) {
            categoryCounts.put(category, 0);
        }

        for (String book : lstOfArt) {
            String[] parts = book.split(" ");
            String category = parts[0].substring(0, 1);

            int bookCount = Integer.parseInt(parts[1]);

            if (categoryCounts.containsKey(category)) {
                categoryCounts.put(category, categoryCounts.get(category) + bookCount);
            }
        }

        StringBuilder result = new StringBuilder();
        for (String category : lstOf1stLetter) {
            if (!result.isEmpty()) {
                result.append(" - ");
            }
            result.append("(").append(category).append(" : ").append(categoryCounts.get(category)).append(")");
        }

        return result.toString();
    }
}
