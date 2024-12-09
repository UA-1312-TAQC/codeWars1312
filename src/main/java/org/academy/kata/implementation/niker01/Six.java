package org.academy.kata.implementation.niker01;

import org.academy.kata.ISix;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Six implements ISix {
    @Override
    public long findNb(long m) {
        return 0;
    }

    @Override
    public String balance(String book) {
        String cleanBook = book.replaceAll("[^a-zA-Z0-9.\\s]", "");
        String[] lines = cleanBook.split("\\n");
        double originalBalance = Double.parseDouble(lines[0].trim());
        double balance = originalBalance;
        double totalExpense = 0;
        int transactionCount = 0;
        StringBuilder report = new StringBuilder();
        report.append(String.format("Original Balance: %.2f\\r\\n", originalBalance));
        for (int i = 1; i < lines.length; i++) {
            if (!lines[i].trim().isEmpty()) {
                String[] parts = lines[i].trim().split("\\s+");
                String checkNo = parts[0];
                String category = parts[1];
                double amount = Double.parseDouble(parts[2]);
                balance -= amount;
                totalExpense += amount;
                transactionCount++;
                report.append(String.format("%s %s %.2f Balance %.2f\\r\\n", checkNo, category, amount, balance));
            }
        }

        double averageExpense = transactionCount > 0 ? totalExpense / transactionCount : 0;
        report.append(String.format("Total expense  %.2f\\r\\n", totalExpense));
        report.append(String.format("Average expense  %.2f", averageExpense));

        return report.toString();
    }

    @Override
    public double f(double x) {
        return x / (Math.sqrt(1 + x) + 1);
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
        if (toFind == null || toFind.isEmpty()) {
            return "";
        }
        String[] games = resultSheet.split(",");
        int wins = 0, draws = 0, losses = 0, scored = 0, conceded = 0, points = 0;
        boolean played = false;
        Pattern pattern = Pattern.compile("([A-Za-z0-9 .]+) (\\d+) ([A-Za-z0-9 .]+) (\\d+)");
        for (String game : games) {
            Matcher matcher = pattern.matcher(game.trim());
            if (!matcher.matches()) {
                Pattern floatPattern = Pattern.compile("\\d+\\.\\d+");
                Matcher floatMatcher = floatPattern.matcher(game.trim());
                if (floatMatcher.find()) {
                    return "Error(float number):" + game.trim();
                }
                continue;
            }
            String team1 = matcher.group(1).trim();
            int score1 = Integer.parseInt(matcher.group(2).trim());
            String team2 = matcher.group(3).trim();
            int score2 = Integer.parseInt(matcher.group(4).trim());
            if (team1.equals(toFind) || team2.equals(toFind)) {
                played = true;
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
        if (!played) {
            return toFind + ":This team didn't play!";
        }
        return toFind + ":W=" + wins + ";D=" + draws + ";L=" + losses + ";Scored=" + scored + ";Conceded=" + conceded + ";Points=" + points;
    }

    @Override
    public String stockSummary(String[] lstOfArt, String[] lstOf1stLetter) {
        if (lstOfArt == null || lstOfArt.length == 0 || lstOf1stLetter == null || lstOf1stLetter.length == 0) {
            return "";
        }
        java.util.Map<String, Integer> categoryTotals = new java.util.HashMap<>();
        for (String category : lstOf1stLetter) {
            categoryTotals.put(category, 0);
        }

        for (String entry : lstOfArt) {
            String[] parts = entry.split(" ");
            String code = parts[0];
            int quantity = Integer.parseInt(parts[1]);
            String category = String.valueOf(code.charAt(0));

            if (categoryTotals.containsKey(category)) {
                categoryTotals.put(category, categoryTotals.get(category) + quantity);
            }
        }

        StringBuilder result = new StringBuilder();
        for (String category : lstOf1stLetter) {
            if (result.length() > 0) {
                result.append(" - ");
            }
            result.append("(").append(category).append(" : ").append(categoryTotals.get(category)).append(")");
        }

        return result.toString();
    }
}
