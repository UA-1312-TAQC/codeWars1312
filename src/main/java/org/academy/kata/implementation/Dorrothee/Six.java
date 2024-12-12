package org.academy.kata.implementation.Dorrothee;

import org.academy.kata.ISix;

import java.util.HashMap;
import java.util.Map;

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

    private static boolean isInteger(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    @Override
    public String nbaCup(String resultSheet, String toFind) {
        if (toFind.isEmpty()) { return ""; }

        String[] resultTeams = resultSheet.split(",");

        int wins = 0, draws = 0, losses = 0;
        int scored = 0, conceded = 0, points = 0;
        boolean found = false;

        for (String result : resultTeams) {

            result = result.trim();

            //Check for float numbers in the scores
            if (result.matches(".*\\d+\\.\\d+.*")) {
                return "Error(float number):" + result;
            }

            //Split the result of specific teams into parts: team names and scores
            String[] parts = result.split(" ");

            //Get team until we encounter the score (number)
            StringBuilder resultTeam1 = new StringBuilder();
            int i = 0;
            while (i < parts.length && !isInteger(parts[i])) {
                if (resultTeam1.length() > 0) {
                    resultTeam1.append(" ");
                }
                resultTeam1.append(parts[i]);
                i++;
            }
            String team1 = resultTeam1.toString(); //Team name
            int score1 = Integer.parseInt(parts[i]); //Team score

            //Same for the next team
            i++;
            StringBuilder resultTeam2 = new StringBuilder();
            while (i < parts.length && !isInteger(parts[i])) {
                if (resultTeam2.length() > 0) {
                    resultTeam2.append(" ");
                }
                resultTeam2.append(parts[i]);
                i++;
            }
            String team2 = resultTeam2.toString();
            int score2 = Integer.parseInt(parts[i]);

            //Calculations with results
            if (team1.equals(toFind) || team2.equals(toFind)) {

                found = true;

                for (String team:new String[] {team1, team2}) {

                    int teamScore = (team.equals(team1)) ? score1 : score2;
                    int opponentScore = (team.equals(team1)) ? score2 : score1;

                    if (team.equals(toFind)) {
                        scored += teamScore;
                        conceded += opponentScore;

                        //Determine the result
                        if (teamScore > opponentScore) {
                            wins++;
                            points += 3;
                        } else if (teamScore == opponentScore) {
                            draws++;
                            points += 1;
                        } else {
                            losses++;
                        }
                    }
                }
            }
        }

        if (!found) {
            return toFind + ":This team didn't play!";
        }

        return toFind + ":W=" + wins + ";D=" + draws + ";L=" + losses + ";Scored=" + scored + ";Conceded=" + conceded + ";Points=" + points;
    }

    @Override
    public String stockSummary(String[] lstOfArt, String[] lstOf1stLetter) {
        // 1st parameter is the stocklist (L in example),
        // 2nd parameter is list of categories (M in example)

        if (lstOfArt.length == 0 || lstOf1stLetter.length == 0) { return ""; }

        Map<String, Integer> categories = new HashMap<>();

        for (String category : lstOf1stLetter) {
            categories.put(category, 0); //Categories with quantity of 0
        }

        for (String art:lstOfArt) {
            String[] parts = art.split(" ");

            String code = parts[0];
            int quantity = Integer.parseInt(parts[1]);

            String category = code.substring(0, 1);  //The category is the first letter of the code

            //If the category is in the categories list, add the quantity to the total
            if (categories.containsKey(category)) {
                categories.put(category, categories.get(category) + quantity);
            }
        }

        StringBuilder result = new StringBuilder();

        //Iterate over the categories in the order they appear in lstOf1stLetter
        for (int i = 0; i < lstOf1stLetter.length; i++) {
            String category = lstOf1stLetter[i];
            int total = categories.get(category);

            result.append("(").append(category).append(" : ").append(total).append(")");

            //Add a separator if it's not the last category
            if (i < lstOf1stLetter.length - 1) {
                result.append(" - ");
            }
        }

        return result.toString();
    }
}
