package org.academy.kata.implementation.MisterV03;

import org.academy.kata.ISix;

public class Six implements ISix {


    private static boolean checkCityName(String town, String data) {
        String fullCityName = data.substring(0, data.indexOf(":"));
        return fullCityName.equals(town);
    }

    private static String getCityData(String town, String data){
        int index = data.indexOf(town);
        if(index == -1)
            return null;
        data = data.substring(index);
        index = data.indexOf("\n");
        if(!checkCityName(town, data))
            return null;
        if(index == -1)
            return data;
        return data.substring(town.length()+1, index);
    }

    private static String[] getRainValues(String data){
        data = data.replaceAll("[A-Za-z\\,:]", "");
        data = data.trim();
        return data.split(" ");
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
        String cityData = getCityData(town, strng);
        if(cityData == null)
            return -1;
        String [] cityDataParsed = getRainValues(cityData);
        double sum = 0;
        for (String s : cityDataParsed) {
            sum += Double.parseDouble(s);
        }
        return sum/12.0;
    }

    @Override
    public double variance(String town, String strng) {
        String cityData = getCityData(town, strng);
        if(cityData == null)
            return -1;
        String [] cityDataParsed = getRainValues(cityData);
        double sum = 0;
        double meanValue = mean(town, strng);
        for (String s : cityDataParsed) {
            sum += Math.pow((Double.parseDouble(s) - meanValue), 2);
        }
        return sum/12.0;
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
