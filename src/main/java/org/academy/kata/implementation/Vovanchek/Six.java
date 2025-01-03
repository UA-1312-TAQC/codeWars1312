package org.academy.kata.implementation.Vovanchek;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.academy.kata.ISix;

public class Six implements ISix {
    @Override
    public long findNb(long m) {
        long totalVolume = 0;
        long n = 0;
        while (totalVolume < m) {
            n++;
            totalVolume += n * n * n;
        }
        return totalVolume == m ? n : -1;
    }

    @Override
    public String balance(String book) {
        String cleanedText = book.replaceAll("[^\\w\\s\\.]", ""); 
        String[] lines = cleanedText.split("\\n");

        double balance = Double.parseDouble(lines[0].trim());
        double originalBalance = balance;
        
        StringBuilder result = new StringBuilder();
        result.append(String.format("Original Balance: %.2f\\r\\n", originalBalance));

        ArrayList<Double> expenses = new ArrayList<>();
        double totalExpense = 0.0;

        for (int i = 1; i < lines.length; i++) {
            String line = lines[i].trim();

            Pattern pattern = Pattern.compile("([0-9]{3})\\s+([A-Za-z\\s]+)\\s+(\\d+\\.\\d+)");
            Matcher matcher = pattern.matcher(line);

            if (matcher.find()) {
                String id = matcher.group(1);
                String item = matcher.group(2).trim();
                double expense = Double.parseDouble(matcher.group(3));

                balance -= expense;
                expenses.add(expense);

                result.append(String.format("%s %s %.2f Balance %.2f\\r\\n", id, item, expense, balance));
            }
        }

        totalExpense = expenses.stream().mapToDouble(Double::doubleValue).sum();
        double averageExpense = expenses.isEmpty() ? 0.0 : totalExpense / expenses.size();

        result.append(String.format("Total expense  %.2f\\r\\n", totalExpense));
        result.append(String.format("Average expense  %.2f", averageExpense));

        return result.toString();
    }

    @Override
    public double f(double x) {
        return x / (Math.sqrt(1+x) + 1);
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
