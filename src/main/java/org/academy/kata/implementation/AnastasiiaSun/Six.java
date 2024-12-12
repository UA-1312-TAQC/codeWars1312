package org.academy.kata.implementation.AnastasiiaSun;

import org.academy.kata.ISix;


import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Locale;


public class Six implements ISix {
    @Override
    public long findNb(long m) {
        long sum = 0;
        int n = 0;
        while (sum < m) {
            n++;
            sum += (long) Math.pow(n, 3);
        }
        if (sum == m) {
            return n;
        }
        return -1;
    }

    @Override
    public String balance(String book) {
        book = book.replaceAll("[^\\w\\. \\n]", "").trim();

        String[] lines = book.split("\\n");

        if (lines.length == 0) {
            throw new IllegalArgumentException("Input is empty or improperly formatted.");
        }

        double originalBalance;
        try {
            originalBalance = Double.parseDouble(lines[0]);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid original balance format: " + lines[0]);
        }

        double currentBalance = originalBalance;
        double totalExpense = 0;
        int expenseCount = 0;

        StringBuilder result = new StringBuilder();
        result.append(String.format(Locale.US, "Original Balance: %.2f%s", originalBalance, System.lineSeparator()));

        for (int i = 1; i < lines.length; i++) {
            if (lines[i].trim().isEmpty()) {
                continue;
            }

            try {
                String[] parts = lines[i].trim().split("\\s+", 3);
                if (parts.length < 3) {
                    throw new IllegalArgumentException("Invalid line format: " + lines[i]);
                }

                String checkNumber = parts[0];
                String category = parts[1];
                double amount = Double.parseDouble(parts[2]);

                currentBalance -= amount;
                totalExpense += amount;
                expenseCount++;

                result.append(String.format(Locale.US, "%s %s %.2f Balance %.2f%s",
                        checkNumber, category, amount, currentBalance, System.lineSeparator()));
            } catch (Exception e) {
                result.append("Error processing line: ").append(lines[i]).append(System.lineSeparator());
            }
        }

        result.append(String.format(Locale.US, "Total expense  %.2f%s", totalExpense, System.lineSeparator()));
        result.append(String.format(Locale.US, "Average expense  %.2f", totalExpense / expenseCount));

        return result.toString();
    }

    @Override
    public double f(double x) {
        if (x < 1e-4) {
            return x / (Math.sqrt(1 + x) + 1);
        }
        return Math.sqrt(1 + x) - 1;
    }

    @Override
    public double mean(String town, String strng) {
        String[] records = strng.split("\n");
        String townData = null;

        for (String record : records) {
            if (record.startsWith(town)) {
                String[] parts = record.split(":");
                townData = parts[1];
                break;
            }
        }
        if (townData == null) {
            return -1;
        }
        String[] rainfallData = townData.split(",");

        double sumRainfall = 0;
        double countRainfall = 0;

        for (String rainfallDatum : rainfallData) {
            String[] monthData = rainfallDatum.split(" ");
            sumRainfall += Double.parseDouble(monthData[1]);
            countRainfall++;
        }
        return sumRainfall / countRainfall;
    }

    @Override
    public double variance(String town, String strng) {
        double meanRainfall = mean(town, strng);
        if (meanRainfall == -1) {
            return -1;
        }
        String[] records = strng.split("\n");
        String townData = null;

        for (String record : records) {
            if (record.startsWith(town)) {
                String[] parts = record.split(":");
                townData = parts[1];
                break;
            }
        }
        if (townData == null) {
            return -1;
        }
        String[] rainfallData = townData.split(",");

        double varianceSum = 0;
        double countRainfall = 0;

        for (String rainfallDatum : rainfallData) {
            String[] monthData = rainfallDatum.split(" ");
            varianceSum += Math.pow((Double.parseDouble(monthData[1]) - meanRainfall), 2);
            countRainfall++;
        }
        return varianceSum / countRainfall;
    }

    @Override
    public String nbaCup(String resultSheet, String toFind) {
        if (toFind.isEmpty()) {
            return "";
        }

        String[] matches = resultSheet.split(",");
        TeamStats stats = new TeamStats();

        Pattern pattern = Pattern.compile("([A-Za-z0-9 .]+) (\\d+) ([A-Za-z0-9 .]+) (\\d+)");

        boolean teamPlayed = false;

        for (String match : matches) {
            Matcher matcher = pattern.matcher(match.trim());
            if (matcher.matches()) {
                String team1 = matcher.group(1).trim();
                int score1 = Integer.parseInt(matcher.group(2));
                String team2 = matcher.group(3).trim();
                int score2 = Integer.parseInt(matcher.group(4));

                if (team1.equals(toFind) || team2.equals(toFind)) {
                    if (match.contains(".")) {
                        return "Error(float number):" + match.trim();
                    }

                    teamPlayed = true;

                    if (team1.equals(toFind)) {
                        updateStatistics(score1, score2, stats);
                    } else if (team2.equals(toFind)) {
                        updateStatistics(score2, score1, stats);
                    }
                }
            }
        }

        if (!teamPlayed) {
            return toFind + ":This team didn't play!";
        }

        return String.format("%s:W=%d;D=%d;L=%d;Scored=%d;Conceded=%d;Points=%d",
                toFind, stats.wins, stats.draws, stats.losses, stats.scored, stats.conceded, stats.points);
    }

    private static class TeamStats {
        int wins = 0;
        int draws = 0;
        int losses = 0;
        int scored = 0;
        int conceded = 0;
        int points = 0;
    }

    private static void updateStatistics(int scored, int conceded, TeamStats stats) {
        stats.scored += scored;
        stats.conceded += conceded;
        if (scored > conceded) {
            stats.wins++;
            stats.points += 3;
        } else if (scored == conceded) {
            stats.draws++;
            stats.points += 1;
        } else {
            stats.losses++;
        }
    }

    @Override
    public String stockSummary(String[] lstOfArt, String[] lstOf1stLetter) {
        if (lstOfArt.length == 0 || lstOf1stLetter.length == 0) {
            return "";
        }

        Map<String, Integer> categoriesAndQuantities = new HashMap<>();
        for (String category : lstOf1stLetter) {
            categoriesAndQuantities.put(category, 0);
        }

        for (String stockItem : lstOfArt) {
            String[] parts = stockItem.split(" ");
            String category = parts[0].substring(0, 1);
            int quantity = Integer.parseInt(parts[1]);

            if (categoriesAndQuantities.containsKey(category)) {
                categoriesAndQuantities.put(category, categoriesAndQuantities.get(category) + quantity);
            }
        }
        StringBuilder result = new StringBuilder();
        for (String category : lstOf1stLetter) {
            if (!result.isEmpty()) {
                result.append(" - ");
            }
            result.append("(").append(category).append(" : ").append(categoriesAndQuantities.get(category)).append(")");
        }
        return result.toString();
    }
}
