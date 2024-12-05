package org.academy.kata.implementation.TanyaB777;

import org.academy.kata.ISix;

import java.util.HashMap;
import java.util.Map;
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
        return "";
    }
}
