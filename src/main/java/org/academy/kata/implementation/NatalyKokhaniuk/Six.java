package org.academy.kata.implementation.NatalyKokhaniuk;

import org.academy.kata.ISix;
import java.util.HashMap;
import java.util.Map;

import java.util.regex.*;
import java.util.*;

public class Six implements ISix {
    @Override
    public long findNb(long m) {
        long res=1, M=m;
        while(M>0){
            M-=res*res*res;
            if(M==0) break;
            res++;
            if(M<res*res*res) {
                System.out.println("Unable to buid a cube from "+m+" blocks.");
                return -1;}
        }
        System.out.println("findNb("+m+") --> "+res);
        return res;
    }

    @Override
    public String balance(String book) {
        String[] lines = book.split("\\n");
        for(int i=0;i<lines.length;i++){
            lines[i] = lines[i].replaceAll("[^a-zA-Zа-яА-Я0-9.\\n ]", "").replaceAll("\\s+", " ").trim();
        }
        double balance = 0.0;
        double totalExpense = 0.0;
        int products=0;
        String res="Original Balance: "+lines[0].trim()+"\\r\\n";
        try{
            balance=Double.parseDouble(lines[0].trim());
        }
        catch(NumberFormatException e){
            System.out.println("Balance can`t be read.");
            return null;
        }

        for (int i = 1; i < lines.length; i++) {
            String line = lines[i].trim();
            String[] parts = line.split(" ");
            if (parts.length < 3) continue;
            products++;
            double amount = Double.parseDouble(parts[2]);
            balance -= amount;
            totalExpense += amount;
            res+=(line+" Balance "+num(balance)+"\\r\\n");
        }
        res+="Total expense  "+num(totalExpense)+"\\r\\n";
        res+="Average expense  "+num(totalExpense/products);
        System.out.println(book+"\n\n"+res);
        return res;
    }
    private static String num (double n){
        String res;
        if(Math.round(n)==n) res=Math.round(n)+".00";
        else res=""+Math.round(n*100)/100.00;
        String[] x = res.split("\\.");
        if(x.length>0) if(x[1].length()==1) res+="0";
        return res;
    }

    @Override
    public double f(double x) {
        return x / (Math.sqrt(1 + x) + 1);
    }
    private static Map<String, double[]> parseData(String strng) {
        Map<String, double[]> rainfallData = new HashMap<>();
        String[] lines = strng.split("\\n");
        for (String line : lines) {
            String[] parts = line.split(":");
            if (parts.length < 2) continue;
            String town = parts[0];
            String[] monthlyData = parts[1].split(",");
            double[] rainfalls = new double[monthlyData.length];
            for (int i = 0; i < monthlyData.length; i++) {
                String[] monthAndValue = monthlyData[i].trim().split(" ");
                rainfalls[i] = Double.parseDouble(monthAndValue[1]);
            }
            rainfallData.put(town, rainfalls);
        }
        return rainfallData;
    }
    private static double Mean(String town, String strng) {
        Map<String, double[]> rainfallData = parseData(strng);
        if (!rainfallData.containsKey(town)) {
            return -1.0;
        }
        double[] rainfalls = rainfallData.get(town);
        double sum = 0.0;
        for (double rainfall : rainfalls) {
            sum += rainfall;
        }
        return sum / rainfalls.length;
    }
        private static String Format(double x) {
        String f=""+x;
        String []parts=f.split("\\.");
        if(parts.length<2) return f;
        else {
            String res;
            if(parts[1].length()>5) res=parts[0]+"."+parts[1].substring(0, 2)+"("+parts[1].substring(2)+")";
            else  res=f;

            return res;
        }
    }
    @Override
    public double mean(String town, String strng) {
        double sum = Mean(town, strng);
        System.out.println("mean(\""+town+"\", data), "+Format(sum));
        return sum;
    }

    @Override
    public double variance(String town, String strng) {
       Map<String, double[]> rainfallData = parseData(strng);
        if (!rainfallData.containsKey(town)) {
            return -1.0;
        }
        double[] rainfalls = rainfallData.get(town);
        double mean = Mean(town, strng);
        double sumSquaredDiff = 0.0;
        for (double rainfall : rainfalls) {
            sumSquaredDiff += Math.pow(rainfall - mean, 2);
        }

        System.out.println("variance(\""+town+"\", data), "+Format(sumSquaredDiff / rainfalls.length));
        return sumSquaredDiff / rainfalls.length;
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
