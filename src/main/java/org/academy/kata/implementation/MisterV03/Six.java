package org.academy.kata.implementation.MisterV03;

import org.academy.kata.ISix;

import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Six implements ISix {


    private static Vector<String> getMatches(String data, String team) {
        String [] matches = data.split(",");
        Vector<String> res = new Vector<String>();
        for(int i = 0; i<matches.length; i++) {
            if(matches[i].indexOf(team + " ") != -1) {
                res.add(matches[i]);
            }
        }
        return res;
    }

    private static String findFloatScore(Vector<String> data) {
        Pattern pattern = Pattern.compile(" [0-9]+\\.[0-9]+ ");
        for (String datum : data) {
            Matcher matcher = pattern.matcher(datum + " ");
            if (matcher.find())
                return datum;
        }
        return null;
    }

    private static String[] parseResult(String in) {
        String[] results = new String[4];
        in=in+" ";//for regex search
        Pattern pattern = Pattern.compile(" [0-9]+ ");
        Matcher matcher = pattern.matcher(in);
        matcher.find();
        results[0] = in.substring(0, matcher.start());
        results[1] = in.substring(matcher.start(), matcher.end()).trim();
        int endIndex = matcher.end();
        matcher.find();
        results[2] = in.substring(endIndex, matcher.start());
        results[3] = in.substring(matcher.start(), matcher.end()).trim();
        return results;
    }

    private static Map<String, Integer> getScore(Vector<String> matches, String targetTeam) {
        Map<String, Integer> teamResults = new HashMap<String, Integer>();
        teamResults.put("W", 0);
        teamResults.put("L", 0);
        teamResults.put("D", 0);
        teamResults.put("Scored", 0);
        teamResults.put("Conceded", 0);
        teamResults.put("Points", 0);
        for(int i = 0; i<matches.size(); i++) {
            int Scored = 0;
            int Conceded = 0;
            String[] parsedResults = parseResult(matches.get(i));
            Scored = Integer.parseInt(parsedResults[1]);
            Conceded = Integer.parseInt(parsedResults[3]);
            if(!parsedResults[0].equals(targetTeam)) {
                int temp = Scored;
                Scored = Conceded;
                Conceded = temp;
            }
            teamResults.put("Scored", teamResults.get("Scored")+Scored);
            teamResults.put("Conceded", teamResults.get("Conceded")+Conceded);
            if(Scored>Conceded) {
                teamResults.put("W", teamResults.get("W")+1);
                teamResults.put("Points", teamResults.get("Points")+3);
            }
            if(Scored<Conceded) {
                teamResults.put("L", teamResults.get("L")+1);
            }
            if(Scored==Conceded) {
                teamResults.put("Points", teamResults.get("Points")+1);
                teamResults.put("D", teamResults.get("D")+1);
            }
        }
        return teamResults;
    }

    private static String formatResults(String Team, Map<String, Integer> results) {
        StringBuilder builder = new StringBuilder(Team);
        builder.append(":W=").append(results.get("W")).append(";D=").append(results.get("D")).append(";L=").append(results.get("L"));
        builder.append(";Scored=").append(results.get("Scored")).append(";Conceded=").append(results.get("Conceded"));
        builder.append(";Points=").append(results.get("Points"));
        return builder.toString();
    }

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
        if(toFind.isEmpty())
            return "";
        Vector<String> matches = getMatches(resultSheet, toFind);
        String error = findFloatScore(matches);
        if(error!=null) {
            return "Error(float number):" + error;
        }
        if(matches.isEmpty()) {
            return toFind+":This team didn't play!";
        }
        Map<String, Integer> results = getScore(matches, toFind);
        return formatResults(toFind, results);
    }

    @Override
    public String stockSummary(String[] lstOfArt, String[] lstOf1stLetter) {
        return "";
    }
}
