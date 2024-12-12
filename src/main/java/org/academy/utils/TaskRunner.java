package org.academy.utils;

import java.math.BigInteger;
import java.util.Arrays;

public class TaskRunner {
    Author author;
    ConsoleReader reader;

    public TaskRunner(Author author) {
        this.author = author;
        this.reader = new ConsoleReader();
    }

    public void runLiters() {
        System.out.println("input double number");
        double hours = reader.readDouble();
        int result = author.getEight().liters(hours);
        System.out.println("In " + hours + " Nathan will drink " + result + " liters");
    }

    public void runGetVolumeOfCuboid() {
        System.out.println("Input double length:");
        double length = reader.readDouble();
        System.out.println("Input double width:");
        double width = reader.readDouble();
        System.out.println("Input double height:");
        double height = reader.readDouble();
        double result = author.getEight().getVolumeOfCuboid(length, width, height);
        System.out.println("Volume of a cuboid: %.2f%n" + result);
    }

    public void runStringToNumber() {
        System.out.println("Input string of numbers: ");
        String str = reader.readString();
        int result = author.getEight().stringToNumber(str);
        System.out.println("Converted string to number: " + result);
    }

    public void runAmIWilson() {
        System.out.println("Input prime number:");
        long number = reader.readLong();
        boolean result = author.getEight().am_i_wilson(number);
        System.out.println("Number " + number + (result ? " is wilson prime" : " is not wilson prime"));
    }

    public void runRainfall() {
        System.out.println("Input town name:");
        String town = reader.readString();

        System.out.println("Input rainfall data:");
        String data = reader.readString();

        double meanResult = author.getSix().mean(town, data);
        double varianceResult = author.getSix().variance(town, data);

        System.out.println("For the town " + town + ":");
        System.out.println("Mean rainfall: " + meanResult);
        System.out.println("Variance of rainfall: " + varianceResult);
    }

    public void runMpgToKPM() {
        System.out.println("Enter miles per imperial gallon (mpg) to convert into kilometers per liter (kpl):");
        float mpg = reader.readFloat();
        float result = author.getEight().mpgToKPM(mpg);
        System.out.println("Kilometers per liter (kpl): " + result);
    }

    public void runSquareOrSquareRoot() {
        System.out.println("Enter integers separated by spaces:");
        int[] array = reader.readIntArr();
        int[] resultArray = author.getEight().squareOrSquareRoot(array);
        System.out.println("Result array:");
        for (int el : resultArray) {
            System.out.print(el + " ");
        }
    }

    public void runSmallest() {
        System.out.print("Plese enter the long number: ");
        long num = reader.readLong();
        String numStr = Long.toString(num);
        long[] result = author.getFive().smallest(num);
        System.out.println("The smallest number created is: " + result[0]);
        System.out.println("We takes the num with index: " + result[1]);
        System.out.println("And put it to the index: " + result[2]);
    }

    public void runCountPositivesSumNegatives() {
        System.out.println("input array of integers");
        int[] numbers = reader.readIntArr();
        int[] result = author.getEight().countPositivesSumNegatives(numbers);
        if (result.length == 0) {
            System.out.println("Result: empty array");
        } else {
            System.out.println("Count of positives: " + result[0]);
            System.out.println("Sum of negatives: " + result[1]);
        }
    }

    public void runNbaCup() {
        System.out.println("Input result sheet:");
        String resultSheet = reader.readString();

        System.out.println("Input team name:");
        String teamName = reader.readString();

        String result = author.getSix().nbaCup(resultSheet, teamName);
        System.out.println(result);
    }

    public void runDivisibleBy() {
        System.out.println("Enter integer numbers, separated by spaces:");
        int[] numbers = reader.readIntArr();

        System.out.println("Enter the divider:");
        int divider = reader.readInt();

        int[] result = author.getEight().divisibleBy(numbers, divider);

        System.out.println("Numbers divisible by " + divider + ": " + Arrays.toString(result));
    }

    public void runNewAvg() {
        System.out.println("Enter the list of donations separated by spaces:");
        double[] donations = reader.readDoubleArr();

        System.out.println("Enter the target average:");
        double targetAvg = reader.readDouble();

        long result = author.getSeven().newAvg(donations, targetAvg);

        System.out.println("The next donation should be: " + result);
    }

    public void runSeriesSum() {
        System.out.print("Enter the integer number: ");
        int num = reader.readInt();
        String result = author.getSeven().seriesSum(num);
        System.out.println("Result: " + result);
    }

    public void runFindNb() {
        System.out.println("Input the total volume of the building as a long number:");
        long volume = reader.readLong();
        long result = author.getSix().findNb(volume);
        if (result == -1) {
            System.out.println("No solution exists for volume: " + volume);
        } else {
            System.out.println("For volume " + volume + ", you need " + result + " cubes");
        }
    }

    public void runGap() {
        System.out.println("Enter gap size (g): ");
        int g = reader.readInt();

        System.out.println("Enter the starting number (m): ");
        long m = reader.readLong();

        System.out.println("Enter the ending number (n): ");
        long n = reader.readLong();

        long[] result = author.getFive().gap(g, m, n);

        if (result != null) {
            System.out.println("Gap found: [" + result[0] + ", " + result[1] + "]");
        } else {
            System.out.println("No such gap found in the given range.");
        }
    }

    public void runBalance() {
        ConsoleReader consoleReader = new ConsoleReader();

        System.out.println("Enter book info line by line in the following format:");
        System.out.println("Example:");
        System.out.println("1000.00");
        System.out.println("125 Market 125.45");
        System.out.println("126 Hardware 34.95");
        System.out.println("127 Video 7.45");
        System.out.println("Type 'DONE' when finished:");

        String bookInfo = consoleReader.readMultipleLines("DONE");

        try {
            String result = author.getSix().balance(bookInfo);
            System.out.println(result);
        } catch (Exception e) {
            System.out.println("Error processing input: " + e.getMessage());
        }
    }

    public void runTwoDecimalPlaces() {
        System.out.print("Enter the double number: ");

        double value = reader.readDouble();
        double result = author.getEight().TwoDecimalPlaces(value);
        System.out.println("The result is rounded to 2 decimal places: " + result);
    }

    public void runStockSummary() {
        System.out.println("Enter the stock list separated by commas (e.g. ABAR 200, CDXE 500):");
        String[] lstOfArt = reader.readStringArrByComma();

        System.out.println("Enter the list of categories separated by spaces (e.g., A B C D):");
        String[] lstOf1stLetter = reader.readStringArr();

        String result = author.getSix().stockSummary(lstOfArt, lstOf1stLetter);

        System.out.println("Stock summary: " + result);
    }

    public void runF() {
        System.out.print("Enter the double number: ");
        double value = reader.readDouble();
        double result = author.getSix().f(value);
        System.out.println("The result(approximation of f(x) in the neighborhood of 0): " + result);
    }

    public void runZeros(){
        System.out.print("Enter the int number: ");
        int number = reader.readInt();
        int result = author.getFive().zeros(number);
        System.out.println("The count of trailing zeros in a factorial of a given number: " + result);
    }

    public void runPerimeter(){
        System.out.print("Enter the BigInteger number: ");
        BigInteger number = reader.readBigInteger();
        BigInteger result = author.getFive().perimeter(number);
        System.out.println("The sum of the perimeters of all the squares in a rectangle: " + result);
    }

    public void runSolve() {
        System.out.println("Enter a number:");
        double m = reader.readDouble();
        double result = author.getFive().solve(m);
        System.out.println("Solution: " + result);
    }
}
