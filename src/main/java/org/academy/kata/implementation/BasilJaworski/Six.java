package org.academy.kata.implementation.BasilJaworski;


import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.academy.kata.ISix;

public class Six implements ISix {
    @Override
    public long findNb(long m) {
        long cubes_num = 1;
        long cubes_volume = 0;

        for (; cubes_volume<m; cubes_num++){
            cubes_volume += cubes_num*cubes_num*cubes_num;
        }
        System.out.println(m);
        System.out.println(cubes_volume);

        if (cubes_volume==m){
            return cubes_num-1;
        } else {
            return -1;
        }

    }

    @Override
    public String balance(String book) {
        return "";
    }

    @Override
    public double f(double x) {
        return x/(Math.sqrt(1+x)+1);
    }

    @Override
    public double mean(String town, String strng) {
        return 0;
    }

    @Override
    public double variance(String town, String strng) {
        return 0;
    }

    @Override
    public String nbaCup(String resultSheet, String toFind) {
        if (toFind.isEmpty()) {
            return "";
        }

        Pattern pattern = Pattern.compile("([A-Za-z0-9\\s]+) (\\d+(\\.\\d+)?) ([A-Za-z0-9\\s]+) (\\d+(\\.\\d+)?)");
        Matcher matcher = pattern.matcher(resultSheet);

        int wins = 0, draws = 0, losses = 0, scored = 0, conceded = 0, points = 0;

        boolean teamPlayed = false;
        while (matcher.find()) {
            String team1 = matcher.group(1).trim();
            String score1Str = matcher.group(2);
            String team2 = matcher.group(4).trim();
            String score2Str = matcher.group(5);

            if (score1Str.contains(".") || score2Str.contains(".")) {
                return "Error(float number):" + matcher.group(0);
            }

            int score1 = Integer.parseInt(score1Str);
            int score2 = Integer.parseInt(score2Str);

            if (team1.equals(toFind) || team2.equals(toFind)) {
                teamPlayed = true;

                if (team1.equals(toFind)) {
                    scored += score1;
                    conceded += score2;
                    if (score1 > score2) {
                        wins++;
                        points += 3;
                    } else if (score1 < score2) {
                        losses++;
                    } else {
                        draws++;
                        points += 1;
                    }
                } else if (team2.equals(toFind)) {
                    scored += score2;
                    conceded += score1;
                    if (score2 > score1) {
                        wins++;
                        points += 3;
                    } else if (score2 < score1) {
                        losses++;
                    } else {
                        draws++;
                        points += 1;
                    }
                }
            }
        }

        if (!teamPlayed) {
            return toFind + ":This team didn't play!";
        }

        return toFind + ":W=" + wins + ";D=" + draws + ";L=" + losses + ";Scored=" + scored + ";Conceded=" + conceded + ";Points=" + points;
    }

    @Override
    public String stockSummary(String[] lstOfArt, String[] lstOf1stLetter) {
        if (lstOfArt == null || lstOfArt.length == 0 || lstOf1stLetter == null || lstOf1stLetter.length == 0) {
            return "";
        }

        int[] categoryCounts = new int[lstOf1stLetter.length];

        for (String art : lstOfArt) {
            String[] parts = art.split(" ");
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
            result.append("(").append(lstOf1stLetter[i]).append(" : ").append(categoryCounts[i]).append(")");
            if (i < lstOf1stLetter.length - 1) {
                result.append(" - ");
            }
        }

        return result.toString();
    }
}
