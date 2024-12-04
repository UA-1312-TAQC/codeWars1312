package org.academy.kata.implementation.NastiaDamian;

import org.academy.kata.ISix;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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
        if (toFind.isEmpty()) return "";

        List<String[]> list = Arrays.stream(resultSheet.split(","))
                .filter(a -> a.contains(toFind))
                .map(x -> (x.replaceAll("(.*[0-9]+[.,]?[0-9]*)(\\s)(.*[0-9]+[.,]?[0-9]*)", "$1;$3")).split(";"))
                .collect(Collectors.toList());

        int wins = 0, draws = 0, losses = 0, scored = 0, conceded = 0;

        for (String[] teamRes : list) {
            int scoreOurTeam = 0, score2 = 0;

            if (teamRes[0].substring(teamRes[0].lastIndexOf(" ") + 1).contains(".") || teamRes[1].substring(teamRes[1].lastIndexOf(" ") + 1).contains("."))
                return "Error(float number):" + String.join(" ", teamRes);

            if (!(teamRes[0].substring(0, teamRes[0].lastIndexOf(" "))).equals(toFind) && !(teamRes[1].substring(0, teamRes[1].lastIndexOf(" "))).equals(toFind))
                return toFind + ":This team didn't play!";

            scoreOurTeam = teamRes[0].contains(toFind) ? Integer.parseInt(teamRes[0].substring(teamRes[0].lastIndexOf(" ") + 1)) : Integer.parseInt(teamRes[1].substring(teamRes[1].lastIndexOf(" ") + 1));
            score2 = !teamRes[0].contains(toFind) ? Integer.parseInt(teamRes[0].substring(teamRes[0].lastIndexOf(" ") + 1)) : Integer.parseInt(teamRes[1].substring(teamRes[1].lastIndexOf(" ") + 1));

            wins += scoreOurTeam > score2 ? 1 : 0;
            losses += scoreOurTeam < score2 ? 1 : 0;
            draws += scoreOurTeam == score2 ? 1 : 0;
            scored += scoreOurTeam;
            conceded += score2;
        }

        return String.format("%s:W=%d;D=%d;L=%d;Scored=%d;Conceded=%d;Points=%d", toFind, wins, draws, losses, scored, conceded, wins * 3 + draws);
    }

    @Override
    public String stockSummary(String[] lstOfArt, String[] lstOf1stLetter) {
        return "";
    }
}
