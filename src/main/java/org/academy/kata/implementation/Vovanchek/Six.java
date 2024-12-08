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
        return 0;
    }

    @Override
    public double variance(String town, String strng) {
        return 0;
    }

    @Override
    public String nbaCup(String resultSheet, String toFind) {
        if (toFind == null || toFind.isEmpty()) {
            return "";
        }

        String[] matches = resultSheet.split(",");

      
        int wins = 0, draws = 0, losses = 0;
        int scored = 0, conceded = 0;

        boolean teamPlayed = false;

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
            int score1 = Integer.parseInt(matcher.group(2));
            String team2 = matcher.group(3).trim();
            int score2 = Integer.parseInt(matcher.group(4));

            if (team1.equals(toFind) || team2.equals(toFind)) {
                teamPlayed = true;

                if (team1.equals(toFind)) {
                    scored += score1;
                    conceded += score2;
                    if (score1 > score2) {
                        wins++;
                    } else if (score1 < score2) {
                        losses++;
                    } else {
                        draws++;
                    }
                }

                if (team2.equals(toFind)) {
                    scored += score2;
                    conceded += score1;
                    if (score2 > score1) {
                        wins++;
                    } else if (score2 < score1) {
                        losses++;
                    } else {
                        draws++;
                    }
                }
            }
        }

        if (!teamPlayed) {
            return toFind + ":This team didn't play!";
        }
        int points = wins * 3 + draws;
        return String.format(
            "%s:W=%d;D=%d;L=%d;Scored=%d;Conceded=%d;Points=%d",
            toFind, wins, draws, losses, scored, conceded, points
        );
    }

    @Override
    public String stockSummary(String[] lstOfArt, String[] lstOf1stLetter) {
        return "";
    }
}
