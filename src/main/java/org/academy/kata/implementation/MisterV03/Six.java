package org.academy.kata.implementation.MisterV03;

import org.academy.kata.ISix;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Six implements ISix {


    public static String format(Map<String, Integer> in) {
        List<String> elements = new ArrayList<>(in.keySet());
//		Collections.sort(elements);
        StringBuilder builder = new StringBuilder();
        for(int i = 0; i<elements.size(); i++) {
            builder.append("(").append(elements.get(i)).append(" : ").append(in.get(elements.get(i))).append(")");
            if(i+1<elements.size()) {
                builder.append(" - ");
            }
        }
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
        return "";
    }

    @Override
    public String stockSummary(String[] lstOfArt, String[] lstOf1stLetter) {
        if(lstOfArt.length == 0 || lstOf1stLetter.length == 0)
            return "";
        Map<String, Integer> res = new HashMap<>();
        for (String s : lstOf1stLetter) {
            res.put(s, 0);
        }
        for (String s : lstOfArt) {
            String temp = s.substring(0, 1);
            if (res.get(temp) == null)
                continue;
            int spaceIndex = s.indexOf(" ");
            String number = s.substring(spaceIndex + 1);
            res.put(temp, res.get(temp) + Integer.parseInt(number));
        }
        return format(res);
    }
}
