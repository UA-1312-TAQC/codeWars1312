package org.academy.kata.implementation.daniilrusanov;

import org.academy.kata.ISix;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    public double mean(String town, String strng) {
        String[] cities = strng.split("\n");
        for (String city : cities) {
            if (city.startsWith(town + ":")) {
                String[] records = city.substring(town.length() + 1).split(",");
                double rainfallSum = 0.0;
                for (String record : records) {
                    rainfallSum += Double.parseDouble(record.split(" ")[1]);
                }
                return rainfallSum / records.length;
            }
        }

        return -1;
    }

    @Override
    public double variance(String town, String strng) {
        double avg = mean(town, strng);

        String[] cities = strng.split("\n");
        for (String city : cities) {
            if (city.startsWith(town + ":")) {
                String[] records = city.substring(town.length() + 1).split(",");
                double rainfallSum = 0.0;
                for (String record : records) {
                    double monthRainfall = Double.parseDouble(record.split(" ")[1]);
                    rainfallSum += (monthRainfall - avg) * (monthRainfall - avg);
                }
                return rainfallSum / records.length;
            }
        }

        return -1;
    }

    @Override
    public String nbaCup(String resultSheet, String toFind) {
        if (toFind == null || toFind.isEmpty() || resultSheet == null || resultSheet.isEmpty()){
            return "";
        }

        boolean hasPlayed = false;
        int won = 0;
        int draws = 0;
        int lost = 0;
        int scoredPoints = 0;
        int concededPoints = 0;
        int points = 0;

        String[] matches = resultSheet.split(",");
        String floatErrorRegex = ".*\\d+\\.\\d+.*";

        for (String match : matches) {
            if (match.matches(floatErrorRegex)) {
                return "Error(float number):" + match.trim();
            }

            String regex = "(.+?) (\\d+) (.+?) (\\d+)";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(match.trim());

            if(matcher.matches()) {
                String team1 = matcher.group(1).trim();
                int score1  = Integer.parseInt(matcher.group(2));
                String team2 = matcher.group(3).trim();
                int score2 = Integer.parseInt(matcher.group(4));

                if (team1.equals(toFind)) {
                    hasPlayed = true;
                    if (score1 > score2) {
                        won++;
                        points += 3;
                    }
                    else if (score1 < score2) {
                        lost++;
                    }
                    else {
                        draws++;
                        points++;
                    }

                    scoredPoints += score1;
                    concededPoints += score2;
                }
                else if (team2.equals(toFind)) {
                    hasPlayed = true;
                    if (score1 < score2) {
                        won++;
                        points += 3;
                    }
                    else if (score1 > score2) {
                        lost++;
                    }
                    else {
                        draws++;
                        points++;
                    }

                    scoredPoints += score2;
                    concededPoints += score1;
                }
            }
        }
        if (hasPlayed) {
            return toFind + ":W=" + won + ";D=" + draws + ";L=" + lost + ";Scored=" + scoredPoints + ";Conceded=" + concededPoints + ";Points=" + points;
        } else
            return toFind + ":This team didn't play!";
    }

    @Override
    public String stockSummary(String[] lstOfArt, String[] lstOf1stLetter) {
        return "";
    }
}
