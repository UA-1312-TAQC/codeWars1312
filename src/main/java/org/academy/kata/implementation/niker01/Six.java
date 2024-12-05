package org.academy.kata.implementation.niker01;

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
    if (lstOfArt == null || lstOfArt.length == 0 || lstOf1stLetter == null || lstOf1stLetter.length == 0) {
      return "";
    }
    java.util.Map<String, Integer> categoryTotals = new java.util.HashMap<>();
    for (String category : lstOf1stLetter) {
      categoryTotals.put(category, 0);
    }
    
    for (String entry : lstOfArt) {
      String[] parts = entry.split(" ");
      String code = parts[0];
      int quantity = Integer.parseInt(parts[1]);
      String category = String.valueOf(code.charAt(0));
      
      if (categoryTotals.containsKey(category)) {
        categoryTotals.put(category, categoryTotals.get(category) + quantity);
      }
    }
    
    StringBuilder result = new StringBuilder();
    for (String category : lstOf1stLetter) {
      if (result.length() > 0) {
        result.append(" - ");
      }
      result.append("(").append(category).append(" : ").append(categoryTotals.get(category)).append(")");
    }
    
    return result.toString();
    }
}
