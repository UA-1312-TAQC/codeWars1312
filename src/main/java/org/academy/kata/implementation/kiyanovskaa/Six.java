package org.academy.kata.implementation.kiyanovskaa;

import org.academy.kata.ISix;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Six implements ISix {
    @Override
    public long findNb(long m) {
        long n = 0;
        long sum = 0;

        while (sum < m) {
            n++;
            sum += n * n * n;
        }

        return sum == m ? n : -1;
    }

    @Override
    public String balance(String book) {
        String[] lines = book.split("\n");
        StringBuilder result = new StringBuilder();
        double balance = 0;
        double totalExpense = 0;
        int expenseCount = 0;

        if (lines.length > 0) {
            balance = Double.parseDouble(lines[0].replaceAll("[^\\d.]", ""));
            result.append("Original Balance: " + String.format("%.2f", balance) + "\\r\\n");
        }
        for (int i = 1; i < lines.length; i++) {
            String line = lines[i].replaceAll("[^\\w\\d. ]", "");  // Clean the line
            if (line.isEmpty()) continue;  // Skip empty lines

            String[] parts = line.split(" ");
            int checkNumber = Integer.parseInt(parts[0]);
            String category = parts[1];
            double amount = Double.parseDouble(parts[2]);

            balance -= amount;
            totalExpense += amount;
            expenseCount++;

            result.append(checkNumber + " " + category + " " + String.format("%.2f", amount) + " Balance " + String.format("%.2f", balance) + "\\r\\n");
        }

        double averageExpense = totalExpense / expenseCount;
        result.append("Total expense  " + String.format("%.2f", totalExpense) + "\\r\\n");
        result.append("Average expense  " + String.format("%.2f", averageExpense));

        String finalResult = result.toString().replaceAll("\n", "\r\n");

        return finalResult;
    }

    @Override
    public double f(double x) {
        return x / (Math.sqrt(1 + x) + 1);
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
        String[] matches = resultSheet.split(",");
        int wins = 0, draws = 0, losses = 0;
        int scored = 0, conceded = 0, points = 0;
        boolean teamPlayed = false;

        Pattern pattern = Pattern.compile("([A-Za-z0-9 ]+) (\\d+) ([A-Za-z0-9 ]+) (\\d+)");

        for (String match : matches) {
            Matcher matcher = pattern.matcher(match);

            if (!matcher.find()) {
                continue;
            }

            String team1 = matcher.group(1).trim();
            int score1 = Integer.parseInt(matcher.group(2).trim());
            String team2 = matcher.group(3).trim();
            int score2 = Integer.parseInt(matcher.group(4).trim());

            if (match.matches(".*\\d+\\.\\d+.*")) {
                return "Error(float number):" + match;
            }

            if (team1.equals(toFind) || team2.equals(toFind)) {
                teamPlayed = true;
                if (team1.equals(toFind)) {
                    scored += score1;
                    conceded += score2;
                    if (score1 > score2) {
                        wins++;
                        points += 3;
                    } else if (score1 == score2) {
                        draws++;
                        points += 1;
                    } else {
                        losses++;
                    }
                } else if (team2.equals(toFind)) {
                    scored += score2;
                    conceded += score1;
                    if (score2 > score1) {
                        wins++;
                        points += 3;
                    } else if (score2 == score1) {
                        draws++;
                        points += 1;
                    } else {
                        losses++;
                    }
                }
            }
        }

        if (!teamPlayed) {
            return toFind + ":This team didn't play!";
        }

        return String.format("%s:W=%d;D=%d;L=%d;Scored=%d;Conceded=%d;Points=%d",
                toFind, wins, draws, losses, scored, conceded, points);
    }

    @Override
    public String stockSummary(String[] lstOfArt, String[] lstOf1stLetter) {
        int[] categoryCounts = new int[lstOf1stLetter.length];
        for (String book : lstOfArt) {
            char category = book.charAt(0);
            int quantity = Integer.parseInt(book.split(" ")[1]);

            for (int i = 0; i < lstOf1stLetter.length; i++) {
                if (lstOf1stLetter[i].charAt(0) == category) {
                    categoryCounts[i] += quantity;
                    break;
                }
            }
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < lstOf1stLetter.length; i++) {
            if (result.length() > 0) {
                result.append(" - ");
            }
            result.append("(").append(lstOf1stLetter[i]).append(" : ").append(categoryCounts[i]).append(")");
        }

        return result.toString();
    }
}
