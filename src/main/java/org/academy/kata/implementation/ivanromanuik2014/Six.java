package org.academy.kata.implementation.ivanromanuik2014;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.academy.kata.ISix;

public class Six implements ISix {
    @Override
    public long findNb(long m) {
        long n = 0;
        long totalValue = 0;

        while (totalValue < m) {
            n++;
            totalValue += n * n * n;
            if (totalValue == m) {
                return n;
            }
        }
        return -1;
    }

    @Override
    public String balance(String book) {
        String cleanedBook = book.replaceAll("[^a-zA-Z0-9.\\n ]", "");
        String[] lines = cleanedBook.split("\\n");

        double originalBalance = Double.parseDouble(lines[0]);
        double balance = originalBalance;
        double totalExpense = 0.0;
        int countExpenses = 0;

        String lineSeparator = System.lineSeparator();
        StringBuilder report = new StringBuilder();
        report.append(String.format("Original Balance: %.2f\\r\\n", originalBalance));

        for (int i = 1; i < lines.length; i++) {
            String line = lines[i].trim();
            if (!line.isEmpty()) {
                String[] parts = line.split(" ");
                if (parts.length < 3)
                    continue;

                String checkNumber = parts[0];
                String category = parts[1];
                double amount = Double.parseDouble(parts[2]);

                balance -= amount;
                totalExpense += amount;
                countExpenses++;

                report.append(String.format("%s %s %.2f Balance %.2f\\r\\n", checkNumber, category, amount, balance));
            }
        }

        report.append(String.format("Total expense  %.2f\\r\\n", totalExpense));
        if (countExpenses > 0) {
            report.append(String.format("Average expense  %.2f", totalExpense / countExpenses));
        } else {
            report.append("Average expense  0.00" + lineSeparator);
        }

        return report.toString().trim();
    }

    @Override
    public double f(double x) {
        return x / (Math.sqrt(1 + x) + 1);
    }

    @Override
    public double mean(String town, String strng) {

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
                return sum / rainfallData.length;
            }
        }
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
                return variance / (rainfallData.length);
            }
        }
        return -1.0;
    }

    @Override
    public String nbaCup(String resultSheet, String toFind) {
        if (toFind == null || toFind.isEmpty()) {
            return "";
        }

        int countWins = 0, countDraw = 0, countLose = 0, countScored = 0, countConceded = 0, countPoints = 0;

        ArrayList<String> matches = new ArrayList<>();
        for (String item : resultSheet.split(",")) {
            if (item.contains(toFind)) {
                matches.add(item);
            }
        }

        Pattern pattern = Pattern.compile("(.+?)\\s(\\d+)\\s(.+?)\\s(\\d+)$");
        for (String match : matches) {
            match = match.trim();
            Matcher matcher = pattern.matcher(match);

            if (!matcher.find()) {
                if (match.matches(".*\\d+\\.\\d+.*")) {
                    return "Error(float number):" + match;
                }
                continue;
            }

            String team1 = matcher.group(1).trim();
            Integer score1 = Integer.parseInt(matcher.group(2));
            String team2 = matcher.group(3).trim();
            Integer score2 = Integer.parseInt(matcher.group(4));

            if (!team1.equals(toFind) && !team2.equals(toFind)) {
                return toFind + ":This team didn't play!";
            }

            if (team1.equals(toFind)) {
                if (score1 > score2) {
                    countWins++;
                } else if (score1 == score2) {
                    countDraw++;
                } else if (score1 < score2) {
                    countLose++;
                }
                countScored += score1;
                countConceded += score2;
            }
            if (team2.equals(toFind)) {
                if (score2 > score1) {
                    countWins++;
                } else if (score2 == score1) {
                    countDraw++;
                } else if (score2 < score1) {
                    countLose++;
                }
                countScored += score2;
                countConceded += score1;
            }
        }

        countPoints = countWins * 3 + countDraw;

        return String.format("%s:W=%d;D=%d;L=%d;Scored=%d;Conceded=%d;Points=%d",
                toFind, countWins, countDraw, countLose, countScored, countConceded, countPoints);

    }

    @Override
    public String stockSummary(String[] lstOfArt, String[] lstOf1stLetter) {

        if (lstOfArt.length == 0 || lstOf1stLetter.length == 0) {
            return "";
        }

        Map<String, Integer> countOfBookInCategory = new HashMap<>();

        for (String category : lstOf1stLetter) {
            countOfBookInCategory.put(category, 0);
        }

        for (String bookName : lstOfArt) {
            String[] parts = bookName.split(" ");
            String category = parts[0].substring(0, 1);
            int quantity = Integer.parseInt(parts[1]);

            if (countOfBookInCategory.containsKey(category)) {
                countOfBookInCategory.put(category, countOfBookInCategory.get(category) + quantity);
            }
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < lstOf1stLetter.length; i++) {
            String category = lstOf1stLetter[i];
            int count = countOfBookInCategory.get(category);
            result.append("(").append(category).append(" : ").append(count).append(")");
            if (i < lstOf1stLetter.length - 1) {
                result.append(" - ");
            }
        }
        return result.toString();
    }
}
