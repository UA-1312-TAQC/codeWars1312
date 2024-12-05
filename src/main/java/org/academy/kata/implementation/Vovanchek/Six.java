package org.academy.kata.implementation.Vovanchek;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.academy.kata.ISix;

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
        return "";
    }

    @Override
    public String stockSummary(String[] lstOfArt, String[] lstOf1stLetter) {
        if(lstOfArt.length == 0 || lstOf1stLetter.length == 0) {
          return "";
        }
        Pattern pattern = Pattern.compile("(^\\w)\\w+\\s(\\d+)");
        ArrayList<String> categories = new ArrayList<>();
        ArrayList<Integer> sums = new ArrayList<>();

        for(int i = 0; i < lstOfArt.length; i++) {
            lstOfArt[i] = lstOfArt[i].trim();
            Matcher matcher = pattern.matcher(lstOfArt[i]);
            if(matcher.find() && !categories.contains(matcher.group(1))) {
                String first = matcher.group(1);
                int second = Integer.parseInt(matcher.group(2));
                categories.add(first);
                sums.add(second);
            } else if (categories.contains(matcher.group(1))) {
                int index = categories.indexOf(matcher.group(1));
                sums.set(index, sums.get(index) + Integer.parseInt(matcher.group(2)));
            }
        }
        ArrayList<String> results = new ArrayList<>();
        for(String elem : lstOf1stLetter) {
            if(categories.contains(elem)) {
                int index = categories.indexOf(elem);
                String element = String.valueOf(sums.get(index));
                String result = "(" + categories.get(index) + " : " + element + ")";
                results.add(result);

            } else {
                results.add("(" + elem + " : " + "0" + ")");

            }
        }
        String finish = String.join(" - ", results);
		    return finish;   
    }
}
