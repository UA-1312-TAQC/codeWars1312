package org.academy.kata.implementation.AnastasiiaSun;

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
        return "";
    }
}
