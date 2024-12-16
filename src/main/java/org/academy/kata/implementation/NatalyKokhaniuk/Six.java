package org.academy.kata.implementation.NatalyKokhaniuk;

import org.academy.kata.ISix;

import java.util.regex.*;
import java.util.*;

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
        String res;
        if (resultSheet.contains(".")) {
            Pattern floatPattern = Pattern.compile("([^,]+\\d+\\.\\d+[^,]*)");
            Matcher matcher = floatPattern.matcher(resultSheet);
            if (matcher.find()) {
                res="Error(float number):" + matcher.group(1).trim();
                System.out.println("nba_cup(r, \""+toFind+"\") -> \""+res+"\"");
                return res;
            }
        }

        String[] matches = resultSheet.split(",");
        int wins = 0, draws = 0, losses = 0, scored = 0, conceded = 0;

        boolean teamPlayed = false;

        for (String match : matches) {
            Pattern matchPattern = Pattern.compile("([a-zA-Z0-9\\s]+)\\s(\\d+)\\s([a-zA-Z0-9\\s]+)\\s(\\d+)");
            Matcher matcher = matchPattern.matcher(match.trim());

            if (matcher.find()) {
                String team1 = matcher.group(1).trim();
                int score1 = Integer.parseInt(matcher.group(2));
                String team2 = matcher.group(3).trim();
                int score2 = Integer.parseInt(matcher.group(4));

                if (team1.equals(toFind) || team2.equals(toFind)) {
                    teamPlayed = true;

                    if (team1.equals(toFind)) {
                        scored += score1;
                        conceded += score2;

                        if (score1 > score2) wins++;
                        else if (score1 == score2) draws++;
                        else losses++;
                    } else {
                        scored += score2;
                        conceded += score1;

                        if (score2 > score1) wins++;
                        else if (score2 == score1) draws++;
                        else losses++;
                    }
                }
            }
        }

        if (!teamPlayed) {
            res=toFind + ":This team didn't play!";
            System.out.println("nba_cup(r, \""+toFind+"\") -> \""+res+"\"");
            return res;
        }

        int points = wins * 3 + draws;
        res= String.format("%s:W=%d;D=%d;L=%d;Scored=%d;Conceded=%d;Points=%d",
                toFind, wins, draws, losses, scored, conceded, points);
        System.out.println("nba_cup(r, \""+toFind+"\") -> \""+res+"\"");
        return res;
    }

    @Override
    public String stockSummary(String[] lstOfArt, String[] lstOf1stLetter) {
    if (lstOfArt == null || lstOfArt.length == 0 || lstOf1stLetter == null || lstOf1stLetter.length == 0) {
            return "";
        }

        int[] categoryCounts = new int[lstOf1stLetter.length];

        for (String book : lstOfArt) {
            String[] parts = book.split(" ");
            if (parts.length != 2) continue;

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
            if (i > 0) result.append(" - ");
            result.append("(").append(lstOf1stLetter[i]).append(" : ").append(categoryCounts[i]).append(")");
        }

        return result.toString();
    }
}
