package org.academy.kata.implementation.BasilJaworski;


import java.util.Arrays;
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
        String book_new = remove_add(book);
        String result = "Original Balance: ";
        result += row_get(book_new, 1) + "\\r\\n";
        short rows = row_count(book_new);
        double bal = row_price(row_get(book_new, 1));
        double total = 0.00;
        int expenseCount = 0;

        for (int i = 2; i <= rows; i++) {
            String row = row_get(book_new, i);
            double price = row_price(row);
            if (price > 0) {
                bal -= price;
                total += price;
                expenseCount++;
                result += row + " Balance " + String.format("%.2f", bal) + "\\r\\n";
            }
        }

        double average = (expenseCount > 0) ? total / expenseCount : 0.00;
        result = result.replaceAll("\\s+", " ");

        result += "Total expense  " + String.format("%.2f", total) + "\\r\\n";
        result += "Average expense  " + String.format("%.2f", average);

        return result;
    }

    public static byte row_count(String str){
        char ch = '\n';
        byte row_num = 1;
        for (int i=0; i<str.length(); i++){
            if (str.charAt(i)==ch) row_num++;
        }
        return row_num;
    }

    public static String row_get(String str, int idx){
        String row = "";
        boolean writer = false;
        short begins = 1;

        if (idx==1) {
            writer = true;
            begins++;
        }

        for (int i=0; i<str.length(); i++){
            if (str.charAt(i)=='\n'){
                begins++;
                if (begins==idx) writer = true;
                if (begins>idx) break;
                continue;
            }
            if (writer==true) row += str.charAt(i);
        }

        return row;
    }

    public static double row_price(String str){
        if (str == null || str.trim().isEmpty()) {
            return 0.00;

        }

        if (str.indexOf(' ') == -1) {
            return Double.parseDouble(str.trim());
        }

        String price_str = "";
        boolean writer = false;
        byte spaces = 0;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                if (spaces == 0) {
                    spaces++;
                } else if (spaces == 1) {
                    writer = true;
                }
            }

            if (writer) price_str += str.charAt(i);
        }

        if (price_str.trim().isEmpty()) {
            return 0.00;
        }

        double price_dob = Double.parseDouble(price_str.trim());
        return price_dob;
    }

    public static String remove_add(String str){
        String str_clear = str.replaceAll("(?<!\\d)\\.|\\.(?!\\d)|[^a-zA-Z0-9. \\n]", "");
        return str_clear;
    }

    @Override
    public double f(double x) {
        return x/(Math.sqrt(1+x)+1);
    }

    @Override
    public double mean(String town, String strng) {
        byte row_num = row_get_bymonth(strng, town);
        if (row_num == -1) return -1.0;

        String row = row_get(strng, row_num);
        double[] rainfalls = rainfall_get(row);
        double total = 0.00;

        for (double rainfall : rainfalls) total += rainfall;
        return total / 12;
    }

    @Override
    public double variance(String town, String strng) {
        byte row_num = row_get_bymonth(strng, town);
        if (row_num == -1) return -1.0;

        String row = row_get(strng, row_num);
        double[] rainfalls = rainfall_get(row);
        double mean = mean(town, strng);
        double variance = 0.00;

        for (double rainfall : rainfalls) {
            variance += (rainfall - mean) * (rainfall - mean);
        }
        return variance / 12;
    }

    public static String row_get(String str, int idx){
        String[] rows = str.split("\n");
        if (idx < 0 || idx >= rows.length) return "";
        return rows[idx];
    }

    public static double[] rainfall_get(String str){
        String[] parts = str.split(":");
        if (parts.length < 2) return new double[0];

        String[] rainData = parts[1].split(",");
        double[] rainfalls = new double[rainData.length];
        for (int i = 0; i < rainData.length; i++) {
            rainfalls[i] = Double.parseDouble(rainData[i].replaceAll("[^0-9.]", ""));
        }
        return rainfalls;
    }

    public static byte row_get_bymonth(String str, String town){
        String[] rows = str.split("\n");
        for (byte i = 0; i < rows.length; i++) {
            if (rows[i].startsWith(town + ":")) {
                return i;
            }
        }
        return -1;
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
