package org.academy.kata.implementation.BasilJaworski;

import org.academy.kata.ISix;

public class Six implements ISix {
    @Override
    public long findNb(long m) {
        return 0;
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
        return "";
    }

    @Override
    public String stockSummary(String[] lstOfArt, String[] lstOf1stLetter) {
        return "";
    }
}
