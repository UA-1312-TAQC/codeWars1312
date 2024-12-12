package org.academy.kata.implementation.NatalyKokhaniuk;

import org.academy.kata.ISix;

public class Six implements ISix {
    @Override
    public long findNb(long m) {
        return 0;
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
