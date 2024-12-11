package org.academy.utils;

import java.math.BigInteger;

public class TaskRunner {
    Author author;
    ConsoleReader reader;

    public TaskRunner(Author author) {
        this.author = author;
        this.reader = new ConsoleReader();
    }

    public void runAmIWilson() {
        System.out.println("Input prime number:");
        long number = reader.readLong();
        boolean result = author.getEight().am_i_wilson(number);
        System.out.println("Number " + number + (result ? " is a Wilson prime." : " is not a Wilson prime."));
    }

    public void runLiters() {
        System.out.println("Input time in hours:");
        double time = reader.readDouble();
        int result = author.getEight().liters(time);
        System.out.println("Liters of water: " + result);
    }

    public void runVolumeOfCuboid() {
        System.out.println("Enter length, width, and height of the cuboid:");
        double length = reader.readDouble();
        double width = reader.readDouble();
        double height = reader.readDouble();
        double result = author.getEight().getVolumeOfCuboid(length, width, height);
        System.out.println("Volume of cuboid: " + result);
    }

    public void runMpgToKpm() {
        System.out.println("Enter MPG value:");
        float mpg = reader.readFloat();
        float result = author.getEight().mpgToKPM(mpg);
        System.out.println("Converted value: " + result + " KPM");
    }

    public void runSquareOrSquareRoot() {
        System.out.println("Enter a space-separated list of integers:");
        int[] array = reader.readIntArr();
        int[] result = author.getEight().squareOrSquareRoot(array);
        System.out.println("Result: " + java.util.Arrays.toString(result));
    }

    public void runCountPositivesSumNegatives() {
        System.out.println("Enter a space-separated list of integers:");
        int[] input = reader.readIntArr();
        int[] result = author.getEight().countPositivesSumNegatives(input);
        System.out.println("Positives count: " + result[0] + ", Sum of negatives: " + result[1]);
    }

    public void runStringToNumber() {
        System.out.println("Enter a number in string format:");
        String str = reader.readString();
        int result = author.getEight().stringToNumber(str);
        System.out.println("Converted number: " + result);
    }

    public void runTwoDecimalPlaces() {
        System.out.println("Enter a number:");
        double number = reader.readDouble();
        double result = author.getEight().TwoDecimalPlaces(number);
        System.out.println("Rounded to 2 decimal places: " + result);
    }

    public void runDivisibleBy() {
        System.out.println("Enter a space-separated list of numbers:");
        int[] numbers = reader.readIntArr();
        System.out.println("Enter a divider:");
        int divider = reader.readInt();
        int[] result = author.getEight().divisibleBy(numbers, divider);
        System.out.println("Numbers divisible by " + divider + ": " + java.util.Arrays.toString(result));
    }

    public void runGap() {
        System.out.println("Enter gap, min, and max:");
        int gap = reader.readInt();
        long min = reader.readLong();
        long max = reader.readLong();
        long[] result = author.getFive().gap(gap, min, max);
        if (result != null) {
            System.out.println("Prime gap: " + java.util.Arrays.toString(result));
        } else {
            System.out.println("No prime gap found.");
        }
    }

    public void runZeros() {
        System.out.println("Enter a number:");
        int n = reader.readInt();
        int result = author.getFive().zeros(n);
        System.out.println("Number of trailing zeros: " + result);
    }

    public void runPerimeter() {
        System.out.println("Enter a number:");
        BigInteger n = new BigInteger(reader.readString());
        BigInteger result = author.getFive().perimeter(n);
        System.out.println("Perimeter: " + result);
    }

    public void runSolve() {
        System.out.println("Enter a number:");
        double m = reader.readDouble();
        double result = author.getFive().solve(m);
        System.out.println("Solution: " + result);
    }

    public void runSmallest() {
        System.out.println("Enter a number:");
        long n = reader.readLong();
        long[] result = author.getFive().smallest(n);
        System.out.println("Smallest number: " + result[0] + ", Indexes: " + result[1] + " " + result[2]);
    }

    public void runNewAvg() {
        System.out.println("Enter an array of numbers (space-separated):");
        double[] arr = reader.readDoubleArr();
        System.out.println("Enter target average:");
        double navg = reader.readDouble();
        long result = author.getSeven().newAvg(arr, navg);
        System.out.println("New average required: " + result);
    }

    public void runSeriesSum() {
        System.out.println("Enter the number of terms:");
        int n = reader.readInt();
        String result = author.getSeven().seriesSum(n);
        System.out.println("Series sum: " + result);
    }

    public void runFindNb() {
        System.out.println("Enter a number:");
        long m = reader.readLong();
        long result = author.getSix().findNb(m);
        System.out.println("Result: " + (result != -1 ? result : "Not found"));
    }

    public void runBalance() {
        System.out.println("Enter book content:");
        String book = reader.readString();
        String result = author.getSix().balance(book);
        System.out.println(result);
    }

    public void runFunctionF() {
        System.out.println("Enter x:");
        double x = reader.readDouble();
        double result = author.getSix().f(x);
        System.out.println("f(x): " + result);
    }

    public void runMean() {
        System.out.println("Enter town and data:");
        String town = reader.readString();
        String data = reader.readString();
        double result = author.getSix().mean(town, data);
        System.out.println("Mean rainfall: " + result);
    }

    public void runVariance() {
        System.out.println("Enter town and data:");
        String town = reader.readString();
        String data = reader.readString();
        double result = author.getSix().variance(town, data);
        System.out.println("Variance: " + result);
    }

    public void runNbACup() {
        System.out.println("Enter result sheet and team name:");
        String resultSheet = reader.readString();
        String toFind = reader.readString();
        String result = author.getSix().nbaCup(resultSheet, toFind);
        System.out.println(result);
    }
}
